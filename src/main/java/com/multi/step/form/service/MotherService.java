package com.multi.step.form.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.multi.step.form.entities.Mother;
import com.multi.step.form.repository.MotherRepository;

@Service
public class MotherService {

	@Autowired
	private MotherRepository motherRepository;
	
	@PreAuthorize("hasRole('ROLE_STUDENT') and #mother.getUserId()==authentication.name")
	public Mother save(Mother mother) {
		return motherRepository.save(mother);
	}
	
	@PreAuthorize("hasRole('ROLE_STUDENT') and #id==authentication.name")
	public Mother getMotherByUserId(String id) {
		return motherRepository.findMotherByUserId(id);
	}
	
	@PreAuthorize("hasRole('ROLE_STUDENT') and #userId==authentication.name")
	public void deleteMother(String userId) {
		motherRepository.deleteMotherByUserId(userId);
	}
}
