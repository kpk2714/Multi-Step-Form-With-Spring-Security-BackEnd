package com.multi.step.form.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multi.step.form.entities.WifeHus;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface WifeHusRepository extends JpaRepository<WifeHus, Integer> {

	public WifeHus findWifeHusByUserId(String id);
	public void deleteWifeHusByUserId(String userId);
}
