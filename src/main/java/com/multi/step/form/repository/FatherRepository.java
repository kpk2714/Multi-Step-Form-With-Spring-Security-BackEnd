package com.multi.step.form.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multi.step.form.entities.Father;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface FatherRepository extends JpaRepository<Father, Integer> {
	public Father findFatherByUserId(String id);
	public void deleteFatherByUserId(String userId);
}
