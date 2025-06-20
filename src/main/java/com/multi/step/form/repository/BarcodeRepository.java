package com.multi.step.form.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multi.step.form.entities.BarcodeUser;

@Repository
public interface BarcodeRepository extends JpaRepository<BarcodeUser, Integer> {
	public BarcodeUser findByEmail(String email);
}
