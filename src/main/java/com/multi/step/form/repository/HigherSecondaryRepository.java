package com.multi.step.form.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multi.step.form.entities.HigherSecondary;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface HigherSecondaryRepository extends JpaRepository<HigherSecondary, Integer> {

	public HigherSecondary findHigherSecondaryByUserId(String id);
	public void deleteHigherSecondaryByUserId(String userId);
}