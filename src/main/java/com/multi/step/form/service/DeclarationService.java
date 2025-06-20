package com.multi.step.form.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.multi.step.form.entities.Declaration;
import com.multi.step.form.repository.DeclarationRepository;

@Service
public class DeclarationService {

	@Autowired
	private DeclarationRepository declarationRepository;
	
	@PreAuthorize("hasRole('ROLE_STUDENT') and #id==authentication.name")
	public Declaration getDeclarationByUserId(String id) {
		return declarationRepository.findDeclarationByUserId(id);
	}
	
	@PreAuthorize("hasRole('ROLE_STUDENT') and #declaration.getUserId()==authentication.name")
	public Declaration saveDeclaration(Declaration declaration) {
		return declarationRepository.save(declaration);
	}
}
