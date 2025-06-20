package com.multi.step.form.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multi.step.form.entities.Graduation;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface GraduationRepository extends JpaRepository<Graduation, Integer> {

	public Graduation findGraduationByUserId(String id);
	public void deleteGraduationByUserId(String userId);
}
