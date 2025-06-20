package com.multi.step.form.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.multi.step.form.entities.HigherSecondary;
import com.multi.step.form.repository.HigherSecondaryRepository;

@Service
public class HigherSecondaryService {

	@Autowired
	private HigherSecondaryRepository highersecondaryRepository;
	
	@PreAuthorize("hasRole('ROLE_STUDENT') and #hs.getUserId()==authentication.name")
	public HigherSecondary save(HigherSecondary hs) {
		return highersecondaryRepository.save(hs);
	}
	
	@PreAuthorize("hasRole('ROLE_STUDENT') and #id==authentication.name")
	public HigherSecondary getHigherSecondary(String id) {
		return highersecondaryRepository.findHigherSecondaryByUserId(id);
	}
	
	@PreAuthorize("hasRole('ROLE_STUDENT') and #userId==authentication.name")
	public void deleteHigherSecondary(String userId) {
		highersecondaryRepository.deleteHigherSecondaryByUserId(userId);
	}
}
