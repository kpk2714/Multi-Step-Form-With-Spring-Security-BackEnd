package com.multi.step.form.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.multi.step.form.entities.User;
import com.multi.step.form.service.CustomUserDetailsService;
import com.multi.step.form.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class AuthClientController {

	@Autowired
	private PersistentTokenBasedRememberMeServices rememberMeServices;
	
	@Autowired
	private UserService userService;
	
	@Autowired
    private CustomUserDetailsService userDetailsService;
	
	@GetMapping("/continueWithGoogleLogin")
	public ResponseEntity<?> getUser(@RequestParam(name="remember-me") boolean rememberMe,  HttpServletRequest request, HttpServletResponse response) {
		
		Map<String, Object> responseBody = new HashMap<>();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
        Map<String, Object> attributes = oAuth2User.getAttributes();

        String loggedUserEmail = (String) attributes.get("email");
        
        String registeredUserEmail = userService.getUser(loggedUserEmail).getEmail();
		
		if(loggedUserEmail.equals(registeredUserEmail)) {
			
			try {
				
				User user = this.userService.getUser(loggedUserEmail);
				
				// Load user (throws exception if not found)
	            UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());

	            // Manually create authentication token
	            Authentication loginAuthentication = new UsernamePasswordAuthenticationToken(
	                userDetails, null, userDetails.getAuthorities()
	            );
	            
	         // Store in security context
	            SecurityContext securityContext = SecurityContextHolder.getContext();
	            securityContext.setAuthentication(loginAuthentication);
	            request.getSession().setAttribute("SPRING_SECURITY_CONTEXT", securityContext);

	            // Trigger remember-me login if selected
	            if (rememberMe) {
	                rememberMeServices.loginSuccess(request, response, loginAuthentication);
	            }
	            
	         // Determine redirect URL
	            String role = userDetails.getAuthorities().iterator().next().getAuthority();

	            switch (role) {
	                case "ROLE_ADMIN":
	                    responseBody.put("redirectUrl", "/admin-dashboard");
	                    break;
	                case "ROLE_STUDENT":
	                    responseBody.put("redirectUrl", "/student/pages/home");
	                    break;
	                default:
	                    responseBody.put("redirectUrl", "/login");
	                    break;
	            }

	            responseBody.put("isAuthenticated", true);
	            return ResponseEntity.ok(responseBody);
	            
			} catch (UsernameNotFoundException ex) {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
	                .body(Map.of("message", "User not registered."));
	        } catch (Exception ex) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body(Map.of("message", "Something went wrong."));
	        }
		}
		else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
	                			 .body(Map.of("message", "User not registered."));
		}
	}
}
