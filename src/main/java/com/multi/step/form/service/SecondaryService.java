package com.multi.step.form.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.multi.step.form.entities.Secondary;
import com.multi.step.form.repository.SecondaryRepository;

@Service
public class SecondaryService {


	@Autowired
	private SecondaryRepository secondaryRepository;
	
	@PreAuthorize("hasRole('ROLE_STUDENT') and #secondary.getUserId()==authentication.name")
	public Secondary save(Secondary secondary) {
		return secondaryRepository.save(secondary);
	}
	
	@PreAuthorize("hasRole('ROLE_STUDENT') and #id==authentication.name")
	public Secondary getSecondary(String id) {
		return secondaryRepository.findSecondaryByUserId(id);
	}
	
	@PreAuthorize("hasRole('ROLE_STUDENT') and #userId==authentication.name")
	public void deleteSecondary(String userId) {
		secondaryRepository.deleteSecondaryByUserId(userId);
	}
}
