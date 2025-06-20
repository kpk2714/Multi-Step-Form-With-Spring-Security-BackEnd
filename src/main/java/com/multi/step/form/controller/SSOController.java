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
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.multi.step.form.entities.Domain;
import com.multi.step.form.entities.User;
import com.multi.step.form.service.CustomUserDetailsService;
import com.multi.step.form.service.DomainService;
import com.multi.step.form.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin("http://localhost:4200")
public class SSOController {
	
	@Autowired
	private PersistentTokenBasedRememberMeServices rememberMeServices;
	
	@Autowired
	private UserService userService;

	@Autowired
	private DomainService domainService;
	
	@Autowired
    private CustomUserDetailsService userDetailsService;
	
	@GetMapping("/verifyDomain")
	public ResponseEntity<?> verifyComanyDomain(@RequestParam("domain") String companyDomain) {
		
		Map<String, Object> responseBody = new HashMap<>();
		
		Domain domain = null;
		
		if(companyDomain != null) {
			domain = domainService.getCompanyDomain(companyDomain);
			
			if(domain == null) {
				responseBody.put("message", "Wrong Domain !!!");
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
			}
			
		}
		
		responseBody.put("domain", true);
		return ResponseEntity.ok(responseBody);
	}
	
	
	@PostMapping("/ssologin")
	public ResponseEntity<?> verifySSOLogin(@RequestParam String email, @RequestParam(name="remember-me") boolean rememberMe,  HttpServletRequest request, HttpServletResponse response) {
		try {
			
			User user = this.userService.getUser(email);
			
			// Load user (throws exception if not found)
            UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());

            // Manually create authentication token
            Authentication authentication = new UsernamePasswordAuthenticationToken(
                userDetails, null, userDetails.getAuthorities()
            );
            
         // Store in security context
            SecurityContext securityContext = SecurityContextHolder.getContext();
            securityContext.setAuthentication(authentication);
            request.getSession().setAttribute("SPRING_SECURITY_CONTEXT", securityContext);

            // Trigger remember-me login if selected
            if (rememberMe) {
                rememberMeServices.loginSuccess(request, response, authentication);
            }
            
         // Determine redirect URL
            String role = userDetails.getAuthorities().iterator().next().getAuthority();
            Map<String, Object> responseBody = new HashMap<>();

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
}
