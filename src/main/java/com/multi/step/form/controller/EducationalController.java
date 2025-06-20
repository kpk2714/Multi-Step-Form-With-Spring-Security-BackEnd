package com.multi.step.form.controller;

import java.util.HashMap;
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

import com.multi.step.form.controlleradvice.UnAuthorizedUserException;
import com.multi.step.form.entities.Diploma;
import com.multi.step.form.entities.Graduation;
import com.multi.step.form.entities.HigherSecondary;
import com.multi.step.form.entities.Secondary;
import com.multi.step.form.service.DiplomaService;
import com.multi.step.form.service.GraduationService;
import com.multi.step.form.service.HigherSecondaryService;
import com.multi.step.form.service.SecondaryService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EducationalController {

	@Autowired
	private SecondaryService secondaryService;
	
	@Autowired
	private HigherSecondaryService higherSecondaryService;
	
	@Autowired
	private DiplomaService diplomaService;
	
	@Autowired
	private GraduationService graduationService;
	
	
	@PostMapping("/save/secondary/userId={id}")
	public ResponseEntity<?> saveSecondary(@PathVariable String id , @RequestBody Secondary secondary) throws Exception {
		
		Map<String, Object> responseBody = new HashMap<>();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getPrincipal())) {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
        }
			
		String username = authentication.getName();
		
		Secondary sec = secondaryService.getSecondary(id);
		
		if(username.equals(id)) {
			if(sec!=null) {
				secondaryService.deleteSecondary(id);
			}
			secondary.setUserId(id);
			sec = secondaryService.save(secondary);
			
			if(sec==null) {
				responseBody.put("message", "Internal Server Error!");
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
			}
			
			responseBody.put("secondary", "Data Saved Successfully !!!");
			return ResponseEntity.ok(responseBody);
		} else {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
		}
	}
	
	@PostMapping("/save/highsecondary/userId={id}")
	public ResponseEntity<?> saveHighSecondary(@PathVariable String id , @RequestBody HigherSecondary hs) throws Exception {
		
		Map<String, Object> responseBody = new HashMap<>();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getPrincipal())) {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
        }
			
		String username = authentication.getName();
		
		HigherSecondary newHS = higherSecondaryService.getHigherSecondary(id);
		
		if(username.equals(id)) {
			if(newHS!=null) {
				higherSecondaryService.deleteHigherSecondary(id);
			}
			hs.setUserId(id);
			higherSecondaryService.save(hs);
			
			responseBody.put("hs", "Data Saved Successfully !!!");
			return ResponseEntity.ok(responseBody);
		} else {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
		}
	}
	
	@PostMapping("/save/diploma/userId={id}")
	public ResponseEntity<?> saveDiploma(@PathVariable String id , @RequestBody Diploma diploma) throws Exception {
		
		Map<String, Object> responseBody = new HashMap<>();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getPrincipal())) {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
        }
			
		String username = authentication.getName();
		
		Diploma newDiploma = diplomaService.getDiploma(id);
		
		if(username.equals(id)) {
			if(newDiploma!=null) {
				diplomaService.deleteDiploma(id);
			}
			diploma.setUserId(id);
			diplomaService.save(diploma);
			
			responseBody.put("diploma", "Data Saved Successfully !!!");
			return ResponseEntity.ok(responseBody);
		} else {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
		}
	}
	
	@PostMapping("/save/graduation/userId={id}")
	public ResponseEntity<?> saveGraduation(@PathVariable String id , @RequestBody Graduation graduation) throws Exception {
		
		Map<String, Object> responseBody = new HashMap<>();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getPrincipal())) {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
        }
			
		String username = authentication.getName();
		
		Graduation newGraduation = graduationService.getGraduation(id);
		
		if(username.equals(id)) {
			if(newGraduation!=null) {
				graduationService.deleteGraduation(id);
			}
			graduation.setUserId(id);
			graduationService.save(graduation);
			
			responseBody.put("graduation", "Data Saved Successfully !!!");
			return ResponseEntity.ok(responseBody);
		} else {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
		}
	}
	
	@GetMapping("/get/secondary/userId={id}")
	public ResponseEntity<?> getSecondary(@PathVariable String id) throws Exception {
		
		Map<String, Object> responseBody = new HashMap<>();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getPrincipal())) {
			throw new UnAuthorizedUserException("Unauthorized User");
        }
		
		String username = authentication.getName();
		Secondary secondary = null;
		
		if(username.equals(id)) {
			secondary = secondaryService.getSecondary(id);
			responseBody.put("secondary", secondary);
			return ResponseEntity.ok(responseBody);
		} else {
			throw new UnAuthorizedUserException("Unauthorized User");
		}
	}
	
	@GetMapping("/get/highersecondary/userId={id}")
	public ResponseEntity<?> getHigherSecondary(@PathVariable String id) throws Exception {
		
		Map<String, Object> responseBody = new HashMap<>();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getPrincipal())) {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
        }
			
		String username = authentication.getName();
		
		HigherSecondary hs = null;
		
		if(username.equals(id)) {
			hs = higherSecondaryService.getHigherSecondary(id);
			responseBody.put("hs", hs);
			return ResponseEntity.ok(responseBody);
		} else {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
		}
	}
	
	@GetMapping("/get/diploma/userId={id}")
	public ResponseEntity<?> getDiploma(@PathVariable String id ) throws Exception {
		
		Map<String, Object> responseBody = new HashMap<>();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getPrincipal())) {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
        }
			
		String username = authentication.getName();
		
		Diploma diploma = null;
		
		if(username.equals(id)) {
			diploma = diplomaService.getDiploma(id);
			responseBody.put("diploma", diploma);
			return ResponseEntity.ok(responseBody);
		} else {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
		}
	}
	
	@GetMapping("/get/graduation/userId={id}")
	public ResponseEntity<?> getGraduation(@PathVariable String id) throws Exception {
		
		Map<String, Object> responseBody = new HashMap<>();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getPrincipal())) {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
        }
			
		String username = authentication.getName();
		
		Graduation graduation = null;
		
		if(username.equals(id)) {
			graduation = graduationService.getGraduation(id);
			responseBody.put("graduation", graduation);
			return ResponseEntity.ok(responseBody);
		} else {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
		}
	}
	
	@DeleteMapping("/deleteSecondary/userId={id}")
	public ResponseEntity<?> deleteSecondary(@PathVariable String id) throws Exception {
		
		Map<String, Object> responseBody = new HashMap<>();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getPrincipal())) {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
        }
			
		String username = authentication.getName();
		
		if(username.equals(id)) {
			
			secondaryService.deleteSecondary(id);
			responseBody.put("secondary", "Secondary Details are deleted !");
			return ResponseEntity.ok(responseBody);
			
		} else {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
		}
	}
	
	@DeleteMapping("/deleteHigherSecondary/userId={id}")
	public ResponseEntity<?> deleteHigherSecondary(@PathVariable String id) throws Exception {
		
		Map<String, Object> responseBody = new HashMap<>();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getPrincipal())) {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
        }
			
		String username = authentication.getName();
		
		if(username.equals(id)) {
			
			higherSecondaryService.deleteHigherSecondary(id);
			responseBody.put("hs", "Higher Secondary Details are deleted !");
			return ResponseEntity.ok(responseBody);
			
		} else {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
		}
	}
	
	@DeleteMapping("/deleteDiploma/userId={id}")
	public ResponseEntity<?> deleteDiploma(@PathVariable String id) throws Exception {
		
		Map<String, Object> responseBody = new HashMap<>();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getPrincipal())) {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
        }
			
		String username = authentication.getName();
		
		if(username.equals(id)) {
			
			diplomaService.deleteDiploma(id);
			responseBody.put("diploma", "Diploma Details are deleted !");
			return ResponseEntity.ok(responseBody);
			
		} else {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
		}
	}
	
	@DeleteMapping("/deleteGraduation/userId={id}")
	public ResponseEntity<?> deleteGraduation(@PathVariable String id) throws Exception {
		
		Map<String, Object> responseBody = new HashMap<>();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getPrincipal())) {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
        }
			
		String username = authentication.getName();
		
		if(username.equals(id)) {
			
			graduationService.deleteGraduation(id);
			responseBody.put("graduation", "Graduation Details are deleted !");
			return ResponseEntity.ok(responseBody);
			
		} else {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
		}
	}
}
