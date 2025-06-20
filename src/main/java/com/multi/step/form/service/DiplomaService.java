package com.multi.step.form.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.multi.step.form.entities.Diploma;
import com.multi.step.form.repository.DiplomaRepository;

@Service
public class DiplomaService {

	@Autowired
	private DiplomaRepository diplomaRepository;
	
	@PreAuthorize("hasRole('ROLE_STUDENT') and #diploma.getUserId()==authentication.name")
	public Diploma save(Diploma diploma) {
		return diplomaRepository.save(diploma);
	}
	
	@PreAuthorize("hasRole('ROLE_STUDENT') and #id==authentication.name")
	public Diploma getDiploma(String id) {
		return diplomaRepository.findDiplomaByUserId(id);
	}
	
	@PreAuthorize("hasRole('ROLE_STUDENT') and #userId==authentication.name")
	public void deleteDiploma(String userId) {
		diplomaRepository.deleteDiplomaByUserId(userId);
	}
}
