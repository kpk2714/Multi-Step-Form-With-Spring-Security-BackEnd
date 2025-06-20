package com.multi.step.form.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.multi.step.form.entities.EmailOTP;
import com.multi.step.form.service.EmailService;
import com.multi.step.form.service.UserService;

import jakarta.mail.MessagingException;

@RestController
@CrossOrigin("http://localhost:4200")
public class EmailController {

	@Autowired
	private EmailService emailService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/getOtp")
	public ResponseEntity<?> getEmailVerifyOtp(@RequestParam("email") String email) throws MessagingException {
		
		Map<String, Object> responseBody = new HashMap<>();
		
		if(email != null) {
			
			String username = this.userService.getUsername(email);
			System.out.println(username);
			if(username == null) {
				responseBody.put("message", "Email is not registered !");
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
			}
			
			String otp = this.emailService.generateOtp();
			System.out.println(otp);
			this.emailService.sendOtp(email, otp);
			
			EmailOTP emailOtp = this.emailService.getOtp(username);
			LocalDateTime now = LocalDateTime.now();
		    LocalDateTime expiryTime = now.plusMinutes(5);
			if(emailOtp == null) {
				
				emailOtp = new EmailOTP();
				
				emailOtp.setEmail(email);
				emailOtp.setUsername(username);
				emailOtp.setOtp(otp);
				emailOtp.setCreatedAt(now);
				emailOtp.setExpiresAt(expiryTime);
				
			} else {
				emailOtp.setOtp(otp);
				emailOtp.setCreatedAt(now);
				emailOtp.setExpiresAt(expiryTime);
			}
			
			this.emailService.saveEmailOtp(emailOtp);
			
			responseBody.put("otp", "OTP Send Successfully !!!");
	        return ResponseEntity.ok(responseBody);
	        
		} else {
			
			responseBody.put("message", "Internal Server Error !");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
			
		}
	}
	
	@GetMapping("/verifyOtp")
	public ResponseEntity<?> verifyEmailOtp(@RequestParam("email") String email, @RequestParam("otp") String requestOtp) throws MessagingException {
		
		Map<String, Object> responseBody = new HashMap<>();
		
		if(email != null && requestOtp != null) {
			
			String username = this.userService.getUsername(email);
			EmailOTP emailOtp = this.emailService.getOtp(username);
			
			String otp = emailOtp.getOtp();
			
			if(emailOtp.getExpiresAt().isAfter(LocalDateTime.now())) {
				
				if(otp.equals(requestOtp)) {
					
					responseBody.put("verified", "Email Verified Successfully !!!");
			        return ResponseEntity.ok(responseBody);
			        
				} else {
					responseBody.put("message", "OTP Mismatched !");
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
				}
			} else {
				responseBody.put("message", "OTP Expired !");
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
			}
		} else {
			
			responseBody.put("message", "Internal Server Error !");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
			
		}
	}
}
