package com.multi.step.form.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multi.step.form.entities.Declaration;

@Repository
public interface DeclarationRepository extends JpaRepository<Declaration, Integer> {

	public Declaration findDeclarationByUserId(String id);
}
