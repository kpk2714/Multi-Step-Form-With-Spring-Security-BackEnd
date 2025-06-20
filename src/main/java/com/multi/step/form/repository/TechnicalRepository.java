package com.multi.step.form.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multi.step.form.entities.Technical;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface TechnicalRepository extends JpaRepository<Technical, Integer> {

	public List<Technical> findAllTechnicalByUserId(String id);
	public void deleteTechnicalBySkillId(String skillId);
}