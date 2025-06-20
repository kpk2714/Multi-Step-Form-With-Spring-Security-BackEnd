package com.multi.step.form.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multi.step.form.entities.Width;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface WidthRepository extends JpaRepository<Width, Integer> {
	public Width findWidthByUserIdAndFormname(String userId,String formname);
	public List<Width> findAllWidthByUserId(String userId);
	public void deleteWidthByFormnameAndUserId(String formname,String userId);
}
