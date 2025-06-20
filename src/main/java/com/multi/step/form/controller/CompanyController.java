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

import com.multi.step.form.entities.Company;
import com.multi.step.form.service.CompanyService;


@RestController
@CrossOrigin("http://localhost:4200")
public class CompanyController {

	@Autowired
	private CompanyService companyService;
	
	@PostMapping("/saveCompany")
	public ResponseEntity<?> saveCompany(@RequestBody Company company) throws Exception {
		
		Map<String, Object> responseBody = new HashMap<>();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getPrincipal())) {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
        }
			
		String username = authentication.getName();
		
		Company newCompany = null;
		
		if(username.equals(company.getUserId())) {
			String companyId = "C"+company.getCompanyname().charAt(0)+company.getCompanyname().charAt(company.getCompanyname().length()-1)+new DecimalFormat("000").format(new Random().nextInt(999));
			company.setCompanyId(companyId);
			newCompany = companyService.saveCompany(company);
			
			if(newCompany == null) {
				responseBody.put("message", "Internal Server Error !");
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
			}
			
			responseBody.put("company", "Data Saved Successfully !!!");
	        return ResponseEntity.ok(responseBody);
		}
		else {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
		}
	}
	
	
	@GetMapping("/getCompany/userId={id}")
	public ResponseEntity<?> getCompany(@PathVariable String id) throws Exception {
		
		Map<String, Object> responseBody = new HashMap<>();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getPrincipal())) {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
        }
			
		String username = authentication.getName();
		
		List<Company> company = new ArrayList<>();
		
		if(username.equals(id)) {
			company = companyService.getAllCompanyByUserId(id);
			
			responseBody.put("company", company);
	        return ResponseEntity.ok(responseBody);
		}
		else {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
		}
	}
	
	@DeleteMapping("/deleteWork/userId={id}")
	public ResponseEntity<?> deleteWork(@PathVariable String id , @RequestParam("companyId") String companyId) throws Exception {
		
		Map<String, Object> responseBody = new HashMap<>();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getPrincipal())) {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
        }
			
		String username = authentication.getName();
		
		if(username.equals(id)) {
			companyService.deleteCompany(companyId, username);
			
			responseBody.put("company", "Company Details are deleted !");
	        return ResponseEntity.ok(responseBody);
		}
		else {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
		}
	}
}