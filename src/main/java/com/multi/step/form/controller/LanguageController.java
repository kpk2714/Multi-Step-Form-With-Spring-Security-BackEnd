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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.multi.step.form.entities.Language;
import com.multi.step.form.service.LanguageService;

@RestController
@CrossOrigin("http://localhost:4200")
public class LanguageController {

	@Autowired
	private LanguageService languageService;
	
	@PostMapping("/saveLanguage")
	public ResponseEntity<?> saveLanguage(@RequestBody Language language) throws Exception {
		
		Map<String, Object> responseBody = new HashMap<>();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getPrincipal())) {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
        }
			
		String username = authentication.getName();
		
		Language newLanguage = null;
		
		if(username.equals(language.getUserId())) {
			newLanguage = languageService.saveLanguage(language);
			
			if(newLanguage == null) {
				responseBody.put("message", "Internal Server Error !");
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
			}
			
			responseBody.put("language", "Data Saved Successfully !!!");
	        return ResponseEntity.ok(responseBody);
		}
		else {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
		}
	}
	
	@GetMapping("/getLanguage/userId={id}")
	public ResponseEntity<?> getLanguage(@PathVariable String id) throws Exception{
		
		Map<String, Object> responseBody = new HashMap<>();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getPrincipal())) {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
        }
			
		String username = authentication.getName();
		
		List<Language> language = new ArrayList<>();
		
		if(username.equals(id)) {
			language = languageService.getAllLanguage(id);
			
			responseBody.put("language", language);
	        return ResponseEntity.ok(responseBody);
		}
		else {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
		}
	}
	
	@DeleteMapping("/deleteLanguage/languageId={id}")
	public ResponseEntity<?> deleteLanguage(@PathVariable String id, @RequestParam("userId") String userId) throws Exception {
		
		Map<String, Object> responseBody = new HashMap<>();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getPrincipal())) {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
        }
			
		String username = authentication.getName();
		
		if(username.equals(userId)) {
			languageService.deleteLanguage(id, userId);
			
			responseBody.put("language", "Language is deleted !");
	        return ResponseEntity.ok(responseBody);
		}
		else {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
		}
	}
}
