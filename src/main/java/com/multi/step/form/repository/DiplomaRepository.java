package com.multi.step.form.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multi.step.form.entities.Diploma;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface DiplomaRepository extends JpaRepository<Diploma, Integer>{

	public Diploma findDiplomaByUserId(String id);
	public void deleteDiplomaByUserId(String userId);
}
