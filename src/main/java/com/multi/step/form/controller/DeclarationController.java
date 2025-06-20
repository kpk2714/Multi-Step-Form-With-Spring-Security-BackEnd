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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.multi.step.form.entities.Declaration;
import com.multi.step.form.service.DeclarationService;

@RestController
@CrossOrigin("http://localhost:4200")
public class DeclarationController {

	@Autowired
	private DeclarationService declarationService;
	
	@PostMapping("/saveDeclaration")
	public ResponseEntity<?> saveDeclaration(@RequestBody Declaration declaration) throws Exception {
		
		Map<String, Object> responseBody = new HashMap<>();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getPrincipal())) {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
        }
			
		String username = authentication.getName();
		
		Declaration newDec = null;
		
		if(username.equals(declaration.getUserId())) {
			
			newDec = declarationService.getDeclarationByUserId(declaration.getUserId());
			
			if(newDec==null) {
				newDec = declarationService.saveDeclaration(declaration);
				
				responseBody.put("message", "Form Submitted Successfully !!!");
				return ResponseEntity.ok(responseBody);
			} else {
				responseBody.put("message", "Already Declared !!!");
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
			}
			
		} else {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
		}
	}
	
	@GetMapping("/getDeclaration/userId={id}")
	public ResponseEntity<?> getDeclaration(@PathVariable String id) throws Exception {
		
		Map<String, Object> responseBody = new HashMap<>();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getPrincipal())) {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
        }
			
		String username = authentication.getName();
		
		Declaration dec = null;
		
		if(username.equals(id)) {
			
			dec = declarationService.getDeclarationByUserId(id);
			
			responseBody.put("dec", dec);
			return ResponseEntity.ok(responseBody);
			
		} else {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
		}
	}
	
}
