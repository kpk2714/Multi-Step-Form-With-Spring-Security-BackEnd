package com.multi.step.form.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.multi.step.form.entities.User;
import com.multi.step.form.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class LoginController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private PersistentTokenBasedRememberMeServices rememberMeServices;
	
	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestParam(name="username") String username, @RequestParam(name="password") String password, @RequestParam(name="remember-me") boolean rememberMe, HttpServletRequest request, HttpServletResponse response) {
		try {
			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
			
			Authentication authentication = authenticationManager.authenticate(token);
			
			SecurityContext securityContext = SecurityContextHolder.getContext();
			securityContext.setAuthentication(authentication);
			request.getSession().setAttribute("SPRING_SECURITY_CONTEXT", securityContext); // Store auth in session
			
			User user = null;
			
			if(rememberMe) {
				
				rememberMeServices.loginSuccess(request, response, authentication);
				UserDetails userDetails = (UserDetails)authentication.getPrincipal();
				user = this.userService.getUserByUsername(userDetails.getUsername());
			}
			
			String role = authentication.getAuthorities().iterator().next().getAuthority();
			
			System.out.println("Remember Me Applied -> "+rememberMe);
			
			Map<String, String> responseBody = new HashMap<>();
			System.out.println("Role -> "+role);
			if (role.equals("ROLE_ADMIN")) {
				responseBody.put("redirectUrl", "/admin-dashboard");
				responseBody.put("role", role);
				responseBody.put("username", authentication.getName());
            } else if (role.equals("ROLE_STUDENT")) {
            	responseBody.put("redirectUrl", "student/pages/home");
            	responseBody.put("role", role);
            	responseBody.put("username", authentication.getName());
            	responseBody.put("email", user.getEmail());
            } else {
            	responseBody.put("redirectUrl", "/login"); // Default
            }
			
			return ResponseEntity.ok(responseBody);
	        
		} catch (BadCredentialsException ex) {
			
	        Map<String, String> responseBody = new HashMap<>();
	        responseBody.put("message", "Invalid username or password !");
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody); // Ensure JSON response
	        
	    } catch (Exception ex) {
	    	
	        Map<String, String> responseBody = new HashMap<>();
	        responseBody.put("message", "Something went wrong! Please try again.");
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
	        
	    }
	}
}

