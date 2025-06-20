package com.multi.step.form.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.multi.step.form.entities.Technical;
import com.multi.step.form.service.TechnicalService;

@RestController
@CrossOrigin("http://localhost:4200")
public class TechnicalController {

	@Autowired
	private TechnicalService technicalService;
	
	@PostMapping("/saveTechnical/userId={userId}")
	public ResponseEntity<?> saveTechnical(@PathVariable String userId , @RequestBody Technical technical) throws Exception {
		
		Map<String, Object> responseBody = new HashMap<>();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getPrincipal())) {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
        }
			
		String username = authentication.getName();
		
		Technical newTechnical = null;
		
		if(username.equals(userId)) {
			String skillId = "S"+technical.getCertificationName().charAt(0)+technical.getCertificationName().charAt(technical.getCertificationName().length()-1)+new DecimalFormat("000").format(new Random().nextInt(999));
			technical.setSkillId(skillId);
			newTechnical = technicalService.save(technical);
			
			if(newTechnical == null) {
				responseBody.put("message", "Internal Server Error !");
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
			}
			
			responseBody.put("technical", "Data Saved Successfully !!!");
	        return ResponseEntity.ok(responseBody);
		}
		else {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
		}
	}
	
	@GetMapping("/getTechnical/userId={id}")
	public ResponseEntity<?> getAllTechnical(@PathVariable String id) throws Exception{
		
		Map<String, Object> responseBody = new HashMap<>();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getPrincipal())) {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
        }
			
		String username = authentication.getName();
		
		List<Technical> technical = new ArrayList<>();
		
		if(username.equals(id)) {
			technical = technicalService.getAllTechnical(id);
			
			responseBody.put("technical", technical);
	        return ResponseEntity.ok(responseBody);
		}
		else {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
		}
	}
	
	@DeleteMapping("/deleteTechnical/userId={id}")
	public ResponseEntity<?> deleteWork(@PathVariable String id , @RequestParam("skillId") String skillId) throws Exception {
		
		Map<String, Object> responseBody = new HashMap<>();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getPrincipal())) {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
        }
			
		String username = authentication.getName();
		
		if(username.equals(id)) {
			technicalService.deleteTechnical(skillId, id);
			
			responseBody.put("technical", "Technical Skills are deleted !");
	        return ResponseEntity.ok(responseBody);
		}
		else {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
		}
	}
}

