package com.multi.step.form.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.multi.step.form.entities.User;
import com.multi.step.form.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@PreAuthorize("hasRole('ROLE_STUDENT') and #username==authentication.name")
	@Cacheable(value = "user", key = "#username")
	public String getName(String username) {
		System.out.println("DB is hit .");
		return userRepository.findByUsername(username).getName();
	}
	
	public String getUsername(String email) {
		User user = this.userRepository.findByEmail(email);
		return user.getUsername();
	}
	
	public String getStudentId(String email) {
		return this.userRepository.findByEmail(email).getStudentId();
	}
	
	public User getUser(String email) {
		return this.userRepository.findByEmail(email);
	}
	
	public User getUserByUsername(String username) {
		return this.userRepository.findByUsername(username);
	}
	
	public String generateStudentId() {
		
		String prefix = "SYN2025K80P16K";
		
		Random random = new Random();
		int otp = 100000 + random.nextInt(900000);
		String studentId = prefix + String.valueOf(otp);
		
		return studentId;
	}
	
	@CacheEvict(value = "user", key = "#username")
	public void removeUserCache(String username) {
	    System.out.println("🧹 Cache cleared for user: " + username);
	}

}
