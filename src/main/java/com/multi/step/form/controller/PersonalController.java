package com.multi.step.form.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.multi.step.form.entities.Personal;
import com.multi.step.form.service.PersonalService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonalController {

	@Autowired
	private PersonalService personalService;
	
	@GetMapping("/getPersonal/userId={id}")
	public ResponseEntity<?> getPersonal(@PathVariable String id) throws Exception {
		
		Map<String, Object> responseBody = new HashMap<>();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getPrincipal())) {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
        }
			
		String username = authentication.getName();
		
		Personal personal = null;
		
		if(username.equals(id)) {
			personal = personalService.getPersonalByUserId(id);
		} else {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
		}
		
		responseBody.put("personal", personal);
        return ResponseEntity.ok(responseBody);
	}
	
	@PostMapping("/savePersonal")
	public ResponseEntity<?> savePersonal(@RequestBody Personal personal) throws Exception {

		Map<String, Object> responseBody = new HashMap<>();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getPrincipal())) {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
        }
			
		String username = authentication.getName();
		
		Personal newPersonal = null;
		
		if(username.equals(personal.getUserId())) {
			newPersonal = personalService.savePersonal(personal);
			
			if(newPersonal==null) {
				responseBody.put("message", "Internal Server Error!");
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
			}
			
			responseBody.put("message", "Data Saved Successfully !!!");
			return ResponseEntity.ok(responseBody);
		} else {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
		}
	}
	
	@PutMapping("/updatePersonal")
	public ResponseEntity<?> updatePersonal(@RequestBody Personal personal) throws Exception {
		
		Map<String, Object> responseBody = new HashMap<>();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getPrincipal())) {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
        }
			
		String username = authentication.getName();
		
		if(username.equals(personal.getUserId())) {
			
			Personal oldPersonal = personalService.getPersonalByUserId(personal.getUserId());
			if(oldPersonal!=null) {

				oldPersonal.setTitle(personal.getTitle());
				oldPersonal.setFirstname(personal.getFirstname());
				oldPersonal.setMiddlename(personal.getMiddlename());
				oldPersonal.setLastname(personal.getLastname());
				oldPersonal.setGender(personal.getGender());
				oldPersonal.setDob(personal.getDob());
				oldPersonal.setEmail(personal.getEmail());
				oldPersonal.setRelation(personal.getRelation());
				oldPersonal.setAlteremail(personal.getAlteremail());
				oldPersonal.setMobile(personal.getMobile());
				oldPersonal.setAltermobile(personal.getAltermobile());
				oldPersonal.setRelationpersonname(personal.getRelationpersonname());
				oldPersonal.setRelationpersonmobile(personal.getRelationpersonmobile());
				oldPersonal.setNationality(personal.getNationality());
				oldPersonal.setCitizen(personal.getCitizen());
				oldPersonal.setReligion(personal.getReligion());
				oldPersonal.setState(personal.getState());
				oldPersonal.setDistrict(personal.getDistrict());
				oldPersonal.setBlood(personal.getBlood());
				oldPersonal.setReservation(personal.getReservation());
				oldPersonal.setAadhar(personal.getAadhar());
				oldPersonal.setMarital(personal.getMarital());
				oldPersonal.setDrivinglicense(personal.getDrivinglicense());
				oldPersonal.setDrivinglicensenumber(personal.getDrivinglicensenumber());
				oldPersonal.setDrivinglicensename(personal.getDrivinglicensename());
				oldPersonal.setDrivinglicenseplace(personal.getDrivinglicenseplace());
				oldPersonal.setPancard(personal.getPancard());
				oldPersonal.setPancardnumber(personal.getPancardnumber());
				oldPersonal.setPancardname(personal.getPancardname());
				oldPersonal.setPancardplace(personal.getPancardplace());
				oldPersonal.setVotercard(personal.getVotercard());
				oldPersonal.setVotercardnumber(personal.getVotercardnumber());
				oldPersonal.setVotercardname(personal.getVotercardname());
				oldPersonal.setVotercardplace(personal.getVotercardplace());
				oldPersonal.setPassport(personal.getPassport());
				oldPersonal.setPassportnumber(personal.getPassportnumber());
				oldPersonal.setPassportname(personal.getPassportname());
				oldPersonal.setPassportplace(personal.getPassportplace());
				oldPersonal.setAddress1(personal.getAddress1());
				oldPersonal.setAddress2(personal.getAddress2());
				oldPersonal.setLandmark(personal.getLandmark());
				oldPersonal.setCountry(personal.getCountry());
				oldPersonal.setMailingstate(personal.getMailingstate());
				oldPersonal.setMailingdistrict(personal.getMailingdistrict());
				oldPersonal.setCity(personal.getCity());
				oldPersonal.setPostalcode(personal.getPostalcode());
				
				oldPersonal = personalService.savePersonal(oldPersonal);
				
				responseBody.put("message", "Data Updated Successfully !!!");
				return ResponseEntity.ok(responseBody);
			}
			else {
				responseBody.put("message", "Personal Data is not saved . First save the data !!!");
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
			}
			
		} else {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
		}
	
		
	}
}
