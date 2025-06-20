package com.multi.step.form.controller;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.multi.step.form.entities.Query;
import com.multi.step.form.entities.Reply;
import com.multi.step.form.service.EmailService;
import com.multi.step.form.service.PersonalService;
import com.multi.step.form.service.QueryService;

import jakarta.mail.MessagingException;

@RestController
@CrossOrigin("http://localhost:4200")
public class QueryController {

	@Autowired
	private QueryService queryService;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private PersonalService personalService;
	
	@Autowired
	private ReplyController replyController;
	
	@PostMapping("/registerquery")
	public ResponseEntity<?> saveQuery(@RequestBody Query query) throws Exception {
		
		Map<String, Object> responseBody = new HashMap<>();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getPrincipal())) {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
        }
			
		String username = authentication.getName();
		
		String id = null;
		
		if(query.getUserId()!=null && username.equals(query.getUserId()) ) {
			
			if(query.getCategory()!=null && query.getDescription()!=null) {
				
				String random = new DecimalFormat("000000").format(new Random().nextInt(999999));
				id = "REQ0002024000" + random;
				
				query.setId(id);
				query.setStatus("Open");
				
				String queryDate = queryService.getDate(query.getUserId());
				
				Date date = new Date();
		        query.setQueryDate(queryDate);
		        query.setQueryTime(date);
				query.setAction("New");
				
				queryService.saveQuery(query);
			}
			else {
				responseBody.put("message", "Query category and description can't be empty !!!");
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
			}
			
			String subject = "SYN Portal: Your query has been submitted successfully!";
			
			String firstName = personalService.getPersonalByUserId(query.getUserId()).getFirstname();
			String middleName = personalService.getPersonalByUserId(query.getUserId()).getMiddlename();
			String lastName = personalService.getPersonalByUserId(query.getUserId()).getLastname();
			
			String emailId = personalService.getPersonalByUserId(query.getUserId()).getEmail();
			
			String body = "Dear "+firstName+" "+middleName+" "+lastName+" "+",\n\n"
					+ 		"Greetings from SYN Portal!\n\n"
					+ 		"Your query has been submitted successfully with Request ID "+id+" .\n\n"
					+ 		"For more details, please navigate to the Trainee Help Desk >> View Request tab on the SYN Portal.\n\n\n"
					+ 		"Warm Regards,\n"
					+ 		"SYN Portal HM Team";
			
			emailService.sendEmail(emailId, subject , body);
		}
		else {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
		}
		
		responseBody.put("query", "Query Submitted Successfully !");
        return ResponseEntity.ok(responseBody);
	}

	
	
	@GetMapping("/getAllQuery/userId={id}")
	public ResponseEntity<?> getAllQueryData(@PathVariable String id) throws Exception{
		
		Map<String, Object> responseBody = new HashMap<>();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getPrincipal())) {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
        }
			
		String username = authentication.getName();
		
		List<Query> list = null;
		
		if(id!=null && username.equals(id)) {
			
			list = queryService.getAllQueryByUserId(id);
			
			for(Query q : list) {
				if(q.getAction().equals("New")) {
					queryService.changeAction(q.getId(),q.getQueryTime(), id);
				}
				
				if(q.getAction().equals("In-Progress")) {
					closeAction(q.getId(),id , q.getQueryTime());
				}
				
				if(q.getAction().equals("Closed")) {
					Reply reply = new Reply();
					reply.setRequestId(q.getId());
					replyController.saveReply(reply,id);
					
					Query query = queryService.getQuerByReqId(q.getId(), id);
					query.setAction("Replied");
					queryService.saveQuery(query);
				}
				
			}
		}
		else {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
		}
		
		responseBody.put("allQuery", list);
        return ResponseEntity.ok(responseBody);
	}
	
	public void closeAction(String reqId,String userId,Date queryTime) throws MessagingException {
		
		Date currentTime = new Date();
		long timeDifference = currentTime.getTime() - queryTime.getTime();
		
		String firstName = personalService.getPersonalByUserId(userId).getFirstname();
		String middleName = personalService.getPersonalByUserId(userId).getMiddlename();
		String lastName = personalService.getPersonalByUserId(userId).getLastname();
		
		String emailId = personalService.getPersonalByUserId(userId).getEmail();
		
		if(timeDifference/(60 * 60 * 1000)>=24) {
			Query query = queryService.getQuerByReqId(reqId, userId);
			query.setAction("Closed");
			query.setStatus("Close");
			queryService.saveQuery(query);
			
			String subject = "SYN Portal: Update regarding your CampBuzz query";
			
			String body = "Dear "+firstName+" "+middleName+" "+lastName+" "+",\n\n"
					+ 		"Greetings from SYN Portal!\n\n"
					+ 		"Your Request ID "+reqId+" has been updated as Closed.\n\n"
					+		"You can view the details by navigating to the following screen on the portal:\n\n\n"
					+ 		"Home Page >> Trainee helpdesk >> View Request\n\n\n"
					+ 		"Warm Regards,\n"
					+ 		"SYN Portal HM Team";
			
			emailService.sendEmail(emailId, subject , body);
		}
	}
}
