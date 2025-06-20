package com.multi.step.form.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multi.step.form.entities.AuthenticatedUser;

@Repository
public interface AuthRepository extends JpaRepository<AuthenticatedUser, Integer> {

	public AuthenticatedUser findAuthUserByEmail(String email);
}
