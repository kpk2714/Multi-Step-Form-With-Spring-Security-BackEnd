package com.multi.step.form.config;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.multi.step.form.service.CustomUserDetailsService;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfiguration {

	private static final String REMEMBER_ME_KEY = "my-remember-me-key";
	
	@Autowired
    private CustomUserDetailsService userDetailsService;
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private OAuth2LoginSuccessHandler oauth2LoginSuccessHandler;
	
	@Autowired
	private CustomLogoutSuccessHandler customLogoutSuccessHandler;
	
	@Bean
    public AuthenticationManager authenticationManager(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder);
        return new ProviderManager(authProvider);
    }
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		http.csrf(csrf -> csrf.disable())
			.cors(cors -> cors.configurationSource(corsConfigurationSource()))
			.authorizeHttpRequests(auth -> auth.requestMatchers("/save","/login","/auth/logout","/user", "/verifyDomain", "/getOtp", 
																"/verifyOtp", "/verifyStudent", "/generate-secret", "/generate-qrcode",
																"/verify-secret", "/verify-authenticator-bind", "/update-authenticator-bind",
																"/ssologin").permitAll()
									   .requestMatchers("/home","/getWidth", "/saveWidth","/getName", "/getPersonal", "/upload",
											   			"/savePersonal", "/updatePersonal", "/savePdf", "/getPdfByDocumentName").hasAuthority("ROLE_STUDENT")
									   .requestMatchers("/about").hasAuthority("ROLE_ADMIN")
									   .anyRequest().authenticated()
								  )
			
								  .oauth2Login(oauth2 -> oauth2
										  .successHandler(oauth2LoginSuccessHandler)
								   )
			
								  .formLogin(form -> form.disable())
								  .logout(logout -> logout
//										  .logoutUrl("/logout")
//										  .logoutSuccessHandler(customLogoutSuccessHandler)
										  .invalidateHttpSession(true)
										  .deleteCookies("JSESSIONID", "remember-me")
										  .permitAll()
								  )
								  .sessionManagement( session -> session
										  .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
								   )
								  .rememberMe( rememberMe -> rememberMe
										  .key(REMEMBER_ME_KEY)  // 🔴 REQUIRED! Without this, tokens are not stored.
										  .rememberMeParameter("remember-me")  // Must match frontend parameter
										  .rememberMeServices(rememberMeServices())
										  .tokenRepository(persistentTokenRepository())
										  .userDetailsService(userDetailsService)
										  //.tokenValiditySeconds(20000)
								  );
								 
		return http.build();
	}
	
	@Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl repo = new JdbcTokenRepositoryImpl();
        repo.setDataSource(dataSource);
        return repo;
    }
	
	@Bean
	public PersistentTokenBasedRememberMeServices rememberMeServices() {
		PersistentTokenBasedRememberMeServices services = new PersistentTokenBasedRememberMeServices(
        		REMEMBER_ME_KEY , userDetailsService, persistentTokenRepository()
        );
		
		services.setTokenValiditySeconds(7 * 24 * 60 * 60);
		return services;
    }
	
	@Bean
    public CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        	config.setAllowCredentials(true);
        	config.setAllowedOrigins(List.of("http://localhost:4200")); // Adjust based on Angular host
        	config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        	config.setAllowedHeaders(List.of("*"));
        	config.setExposedHeaders(List.of("Authorization")); // optional
        source.registerCorsConfiguration("/**", config);
        return source;
    }
}
