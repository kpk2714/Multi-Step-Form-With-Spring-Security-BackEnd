package com.multi.step.form.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multi.step.form.entities.Personal;

@Repository
public interface PersonalRepository extends JpaRepository<Personal, Integer> {
	public Personal findPersonalByUserId(String userId);
}
