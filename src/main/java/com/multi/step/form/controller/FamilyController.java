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

import com.multi.step.form.entities.Child;
import com.multi.step.form.entities.Father;
import com.multi.step.form.entities.Mother;
import com.multi.step.form.entities.WifeHus;
import com.multi.step.form.service.ChildService;
import com.multi.step.form.service.FatherService;
import com.multi.step.form.service.MotherService;
import com.multi.step.form.service.WifeHusService;

@RestController
@CrossOrigin("http://localhost:4200")
public class FamilyController {

	@Autowired
	private FatherService fatherService;
	
	@Autowired
	private MotherService motherService;
	
	@Autowired
	private WifeHusService wifeHusService;
	
	@Autowired
	private ChildService childService;
	
	@PostMapping("/saveFather")
	public ResponseEntity<?> saveFather(@RequestBody Father father) throws Exception {
		
		Map<String, Object> responseBody = new HashMap<>();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getPrincipal())) {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
        }
			
		String username = authentication.getName();
		
		Father newfather = fatherService.getFatherByUserId(father.getUserId());
		
		if(username.equals(father.getUserId())) {
			
			if(newfather!=null) {
				fatherService.deleteFather(father.getUserId());
			}
			newfather = fatherService.save(father);
			
			if(newfather == null) {
				responseBody.put("father", "Data Not Saved , Please Check !!!");
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
			}
			
			responseBody.put("father", "Data Saved Successfully !!!");
	        return ResponseEntity.ok(responseBody);
			
		} else {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
		}
	}
	
	@PostMapping("/saveMother")
	public ResponseEntity<?> saveMother(@RequestBody Mother mother) throws Exception {
		
		Map<String, Object> responseBody = new HashMap<>();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getPrincipal())) {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
        }
			
		String username = authentication.getName();
		
		Mother newmother = motherService.getMotherByUserId(mother.getUserId());
		
		if(username.equals(mother.getUserId())) {
			
			if(newmother!=null) {
				motherService.deleteMother(mother.getUserId());
			}
			newmother = motherService.save(mother);
			
			if(newmother == null) {
				responseBody.put("mother", "Data Not Saved , Please Check !!!");
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
			}
			
			responseBody.put("mother", "Data Saved Successfully !!!");
	        return ResponseEntity.ok(responseBody);
			
		} else {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
		}
	}
	
	@PostMapping("/saveWifeHus")
	public ResponseEntity<?> saveWifeHus(@RequestBody WifeHus wifeHus) throws Exception {
		
		Map<String, Object> responseBody = new HashMap<>();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getPrincipal())) {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
        }
			
		String username = authentication.getName();
		
		WifeHus newWifeHus = wifeHusService.getWifeHusByUserId(wifeHus.getUserId());
		
		if(username.equals(wifeHus.getUserId())) {
			
			if(newWifeHus!=null) {
				wifeHusService.deleteWifeHus(wifeHus.getUserId());
			}
			newWifeHus = wifeHusService.save(wifeHus);
			
			if(newWifeHus == null) {
				responseBody.put("wifeHus", "Data Not Saved , Please Check !!!");
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
			}
			
			responseBody.put("wifeHus", "Data Saved Successfully !!!");
	        return ResponseEntity.ok(responseBody);
			
		} else {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
		}
	}
	
	@PostMapping("/saveChild")
	public ResponseEntity<?> saveChild(@RequestBody Child child) throws Exception {
		
		Map<String, Object> responseBody = new HashMap<>();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getPrincipal())) {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
        }
			
		String username = authentication.getName();
		
		Child newchild = childService.getChildByUserId(child.getUserId());
		
		if(username.equals(child.getUserId())) {
			
			if(newchild!=null) {
				childService.deleteChild(child.getUserId());
			}
			newchild = childService.save(child);
			
			if(newchild == null) {
				responseBody.put("child", "Data Not Saved , Please Check !!!");
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
			}
			
			responseBody.put("child", "Data Saved Successfully !!!");
	        return ResponseEntity.ok(responseBody);
			
		} else {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
		}
	}
	
	@GetMapping("/getFather/userId={id}")
	public ResponseEntity<?> getFather(@PathVariable String id) throws Exception {
		
		Map<String, Object> responseBody = new HashMap<>();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getPrincipal())) {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
        }
			
		String username = authentication.getName();
		
		Father father = null;
		
		if(username.equals(id)) {
			father = fatherService.getFatherByUserId(id);
		} else {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
		}
		
		responseBody.put("father", father);
        return ResponseEntity.ok(responseBody);
	}
	
	@GetMapping("/getMother/userId={id}")
	public ResponseEntity<?> getMother(@PathVariable String id) throws Exception {
		
		Map<String, Object> responseBody = new HashMap<>();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getPrincipal())) {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
        }
			
		String username = authentication.getName();
		
		Mother mother = null;
		
		if(username.equals(id)) {
			mother = motherService.getMotherByUserId(id);
		} else {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
		}
		
		responseBody.put("mother", mother);
        return ResponseEntity.ok(responseBody);
	}
	
	@GetMapping("/getWifeHus/userId={id}")
	public ResponseEntity<?> getWifeHus(@PathVariable String id) throws Exception {
		
		Map<String, Object> responseBody = new HashMap<>();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getPrincipal())) {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
        }
			
		String username = authentication.getName();
		
		WifeHus wifeHus = null;
		
		if(username.equals(id)) {
			wifeHus = wifeHusService.getWifeHusByUserId(id);
		} else {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
		}
		
		responseBody.put("wifeHus", wifeHus);
        return ResponseEntity.ok(responseBody);
	}
	
	@GetMapping("/getChild/userId={id}")
	public ResponseEntity<?> getChild(@PathVariable String id) throws Exception {
		
		Map<String, Object> responseBody = new HashMap<>();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getPrincipal())) {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
        }
			
		String username = authentication.getName();
		
		Child child = null;
		
		if(username.equals(id)) {
			child = childService.getChildByUserId(id);
		} else {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
		}
		
		responseBody.put("child", child);
        return ResponseEntity.ok(responseBody);
	}
	
	@DeleteMapping("/deleteFather/userId={id}")
	public ResponseEntity<?> deleteFather(@PathVariable String id) throws Exception {
		
		Map<String, Object> responseBody = new HashMap<>();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getPrincipal())) {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
        }
			
		String username = authentication.getName();
		
		if(username.equals(id)) {
			
			fatherService.deleteFather(id);
			responseBody.put("father", "Father Details are deleted !");
			return ResponseEntity.ok(responseBody);
			
		} else {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
		}
	}
	
	@DeleteMapping("/deleteMother/userId={id}")
	public ResponseEntity<?> deleteMother(@PathVariable String id) throws Exception {
		
		Map<String, Object> responseBody = new HashMap<>();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getPrincipal())) {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
        }
			
		String username = authentication.getName();
		
		if(username.equals(id)) {
			
			motherService.deleteMother(id);
			responseBody.put("mother", "Mother Details are deleted !");
			return ResponseEntity.ok(responseBody);
			
		} else {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
		}
	}
	
	@DeleteMapping("/deleteWifeHus/userId={id}")
	public ResponseEntity<?> deleteWifeHus(@PathVariable String id) throws Exception {
		
		Map<String, Object> responseBody = new HashMap<>();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getPrincipal())) {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
        }
			
		String username = authentication.getName();
		
		if(username.equals(id)) {
			
			wifeHusService.deleteWifeHus(id);
			responseBody.put("wifehus", "WifeHus Details are deleted !");
			return ResponseEntity.ok(responseBody);
			
		} else {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
		}
	}
	
	@DeleteMapping("/deleteChild/userId={id}")
	public ResponseEntity<?> deleteChild(@PathVariable String id) throws Exception {
		
		Map<String, Object> responseBody = new HashMap<>();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getPrincipal())) {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
        }
			
		String username = authentication.getName();
		
		if(username.equals(id)) {
			
			childService.deleteChild(id);
			responseBody.put("child", "Child Details are deleted !");
			return ResponseEntity.ok(responseBody);
			
		} else {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
		}
	}
}
