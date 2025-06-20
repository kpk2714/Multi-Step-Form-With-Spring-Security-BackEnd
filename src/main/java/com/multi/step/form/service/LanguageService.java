package com.multi.step.form.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.multi.step.form.entities.Language;
import com.multi.step.form.repository.LanguageRepository;

@Service
public class LanguageService {

	@Autowired
	private LanguageRepository languageRepository;
	
	@PreAuthorize("hasRole('ROLE_STUDENT') and #language.getUserId()==authentication.name")
	public Language saveLanguage(Language language) {
		return languageRepository.save(language);
	}
	
	@PreAuthorize("hasRole('ROLE_STUDENT') and #id==authentication.name")
	public List<Language> getAllLanguage(String id){
		return languageRepository.findAllLanguageByUserId(id);
	}
	
	@PreAuthorize("hasRole('ROLE_STUDENT') and #userId==authentication.name")
	public void deleteLanguage(String id, String userId) {
		languageRepository.deleteLanguageByLanguageId(id);
	}
}
