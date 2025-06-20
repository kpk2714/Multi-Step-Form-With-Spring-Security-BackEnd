package com.multi.step.form.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multi.step.form.entities.Language;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface LanguageRepository extends JpaRepository<Language, Integer> {

	public List<Language> findAllLanguageByUserId(String userId);
	public void deleteLanguageByLanguageId(String id);
}
