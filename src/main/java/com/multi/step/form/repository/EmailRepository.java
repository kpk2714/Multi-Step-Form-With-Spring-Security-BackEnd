package com.multi.step.form.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multi.step.form.entities.EmailOTP;

@Repository
public interface EmailRepository extends JpaRepository<EmailOTP, Integer> {
	public EmailOTP findByUsername(String username);
}
