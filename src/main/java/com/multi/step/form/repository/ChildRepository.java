package com.multi.step.form.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multi.step.form.entities.Child;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface ChildRepository extends JpaRepository<Child, Integer> {

	public Child findChildByUserId(String id);
	public void deleteChildByUserId(String userId);
}

