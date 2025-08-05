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
import org.springframework.web.bind.annotation.RestController;

import com.multi.step.form.entities.User;
import com.multi.step.form.response.UserResponse;
import com.multi.step.form.service.CustomUserDetailsService;
import com.multi.step.form.service.UserService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class UserController {
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/home")
	public String homePage() {
		return "This is Home Page";
	}
	
	@GetMapping("/student-dashboard")
	public String StudentPage() {
		return "This is Student Page";
	}
	
	@GetMapping("/about")
	public String AdminPage() {
		return "This is Admin Page";
	}
	
	@GetMapping("/user")
	public Map<String, Object> getUser() {
	    
		Map<String, Object> response = new HashMap<>();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getPrincipal())) {
			System.out.println(authentication.getName());
			response.put("authenticated", false);
            return response;
        }
			
		String username = authentication.getName();
		
		System.out.println("/User -> Username - "+username);
		
		User user = customUserDetailsService.getUserDetails(username);

		UserResponse userResponse = null;
		if(user!=null) {
			userResponse = new UserResponse(user.getStudentId(),user.getName(),user.getUsername());
		}
		
        response.put("user", userResponse);
        response.put("authenticated", true);

        return response;
	}
	
	@GetMapping("/getName/userId={id}")
	public ResponseEntity<?> getName(@PathVariable String id) {
		Map<String, String> responseBody = new HashMap<>();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getPrincipal())) {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
        }
			
		String username = authentication.getName();
		String name = "";
		if(username.equals(id)) {
			name = userService.getName(id);
		} else {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
		}
		
		responseBody.put("name", name);
        return ResponseEntity.ok(responseBody);
	}
	
	
	@GetMapping("/user/logout")
	public ResponseEntity<?> logout(HttpServletRequest request, HttpServletResponse response) {
		
		Map<String, String> responseBody = new HashMap<>();
		
		System.out.println("Logout is called .");
		// Invalidate session
	    HttpSession session = request.getSession(false);
	    if (session != null) {
	        session.invalidate();
	    }

	    // Clear Spring Security context
	    SecurityContextHolder.clearContext();
	    
	 // Remove remember-me cookie if using it
	    Cookie cookie = new Cookie("remember-me", null);
	    cookie.setPath("/");
	    cookie.setHttpOnly(true);
	    cookie.setMaxAge(0);
	    response.addCookie(cookie);
	    
	    Cookie sessionCookie = new Cookie("JSESSIONID", null);
	    sessionCookie.setPath("/");
	    sessionCookie.setMaxAge(0);
	    response.addCookie(sessionCookie);

	    responseBody.put("logout", "Logged out successfully");
	    return ResponseEntity.ok(responseBody);
	}
	
}

