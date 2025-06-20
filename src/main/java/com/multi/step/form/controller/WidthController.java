package com.multi.step.form.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.multi.step.form.entities.Width;
import com.multi.step.form.service.WidthService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class WidthController {

	@Autowired
	private WidthService widthService;

	@PostMapping("/saveWidth")
	public ResponseEntity<?> saveWidth(@RequestBody Width width) throws Exception {

		Map<String, String> responseBody = new HashMap<>();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getPrincipal())) {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
        }
			
		String username = authentication.getName();
		
		Width newWidth = null;
		
		if(username.equals(width.getUserId())) {
			newWidth = widthService.saveWidth(width);
			
			if(newWidth==null) {
				responseBody.put("message", "Internal Server Error!");
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
			}
			
			responseBody.put("message", "Width Saved");
			return ResponseEntity.ok(responseBody);
		} else {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
		}
	}
	
	@GetMapping("/getWidth/userId={id}/form={formname}")
	public ResponseEntity<?> getWidth(@PathVariable String id , @PathVariable String formname) throws Exception {

		Map<String, String> responseBody = new HashMap<>();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getPrincipal())) {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
        }
			
		String username = authentication.getName();
		
		Width width = null;
		
		if(username.equals(id)) {
			width = widthService.getWidth(id, formname);
			if(width==null) {
				responseBody.put("width", null);
			}
			else {
				responseBody.put("width", String.valueOf(width.getWidth()) );
			}
			System.out.println("Formname -> "+formname+" -> Width - " + width);
            return ResponseEntity.ok(responseBody);
		} else {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
		}
	}
	
	
	@GetMapping("/getWidth/userId={id}")
	public ResponseEntity<?> getWidthById(@PathVariable String id) throws Exception {
		
		Map<String, String> responseBody = new HashMap<>();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getPrincipal())) {
			System.out.println("Wdith User -> " + authentication.getName());
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
        }
			
		String username = authentication.getName();
		
		int max = 0;
		
		if(username.equals(id)) {
			List<Width> width = widthService.getAllWidthById(id);
			for(int i=0;i<width.size();i++) {
				if(width.get(i).getWidth()>=max) {
					max = width.get(i).getWidth();
				}
			}
		} else {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
		}
		
		responseBody.put("width", String.valueOf(max));
        return ResponseEntity.ok(responseBody);
	}
	
	@GetMapping("/getAllWidth/userId={id}")
	public ResponseEntity<?> getAllWidth(@PathVariable String id) throws Exception {
		
		Map<String, Object> responseBody = new HashMap<>();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getPrincipal())) {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
        }
			
		String username = authentication.getName();
		
		List<Width> width = null;
		List<Integer> result = new ArrayList<>();
		
		if(username.equals(id)) {
			
			width = widthService.getAllWidthById(id);
			for(int i=0;i<width.size();i++) {
				result.add(width.get(i).getWidth());
			}
            
            if(width == null) {
				responseBody.put("width", "width not saved !");
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
			}
            
			responseBody.put("width", result);
            return ResponseEntity.ok(responseBody);
            
		} else {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
		}
	}
	
	@DeleteMapping("/deleteWidth/userId={id}/form={name}")
	public ResponseEntity<?> deleteWidth(@PathVariable String id,@PathVariable String name) throws Exception {

		Map<String, String> responseBody = new HashMap<>();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getPrincipal())) {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
        }
			
		String username = authentication.getName();
		
		if(username.equals(id)) {
			widthService.deleteWidth(name,id);
			responseBody.put("width", "ok");
            return ResponseEntity.ok(responseBody);
            
		} else {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
		}
	}
}
