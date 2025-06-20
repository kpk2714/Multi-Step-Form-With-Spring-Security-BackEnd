package com.multi.step.form.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.multi.step.form.entities.Graduation;
import com.multi.step.form.repository.GraduationRepository;

@Service
public class GraduationService {

	@Autowired
	private GraduationRepository graduationRepository;
	
	@PreAuthorize("hasRole('ROLE_STUDENT') and #graduation.getUserId()==authentication.name")
	public Graduation save(Graduation graduation) {
		return graduationRepository.save(graduation);
	}
	
	@PreAuthorize("hasRole('ROLE_STUDENT') and #id==authentication.name")
	public Graduation getGraduation(String id) {
		return graduationRepository.findGraduationByUserId(id);
	}
	
	@PreAuthorize("hasRole('ROLE_STUDENT') and #userId==authentication.name")
	public void deleteGraduation(String userId) {
		graduationRepository.deleteGraduationByUserId(userId);
	}
}
