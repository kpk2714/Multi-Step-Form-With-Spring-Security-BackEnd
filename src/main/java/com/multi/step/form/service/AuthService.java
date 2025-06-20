package com.multi.step.form.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.step.form.entities.AuthenticatedUser;
import com.multi.step.form.repository.AuthRepository;

@Service
public class AuthService {

	@Autowired
	private AuthRepository authRepository;
	
	public AuthenticatedUser getSecretKey(String email) {
		return this.authRepository.findAuthUserByEmail(email);
	}
	
	public AuthenticatedUser saveAuthUser(AuthenticatedUser authUser) {
		return this.authRepository.save(authUser);
	}
	
	public AuthenticatedUser isAuthBind(String email) {
		return this.authRepository.findAuthUserByEmail(email);
	}
}
