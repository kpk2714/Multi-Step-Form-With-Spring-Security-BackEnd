package com.multi.step.form.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multi.step.form.entities.Mother;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface MotherRepository extends JpaRepository<Mother, Integer> {
	public Mother findMotherByUserId(String id);
	public void deleteMotherByUserId(String userId);
}
