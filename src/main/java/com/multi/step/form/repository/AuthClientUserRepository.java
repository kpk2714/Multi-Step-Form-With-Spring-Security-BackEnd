package com.multi.step.form.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multi.step.form.entities.AuthClientUser;

@Repository
public interface AuthClientUserRepository extends JpaRepository<AuthClientUser, Integer> {
	public AuthClientUser findByEmail(String email);
}
