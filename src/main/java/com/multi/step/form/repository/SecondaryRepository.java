package com.multi.step.form.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multi.step.form.entities.Secondary;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface SecondaryRepository extends JpaRepository<Secondary, Integer> {

	public Secondary findSecondaryByUserId(String id);
	public void deleteSecondaryByUserId(String userId);
}
