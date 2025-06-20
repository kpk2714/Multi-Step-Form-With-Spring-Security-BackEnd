package com.multi.step.form.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.multi.step.form.entities.Father;
import com.multi.step.form.repository.FatherRepository;

@Service
public class FatherService {

	@Autowired
	private FatherRepository fatherRepository;
	
	@PreAuthorize("hasRole('ROLE_STUDENT') and #father.getUserId()==authentication.name")
	public Father save(Father father) {
		return fatherRepository.save(father);
	}
	
	@PreAuthorize("hasRole('ROLE_STUDENT') and #id==authentication.name")
	public Father getFatherByUserId(String id) {
		return fatherRepository.findFatherByUserId(id);
	}
	
	@PreAuthorize("hasRole('ROLE_STUDENT') and #userId==authentication.name")
	public void deleteFather(String userId) {
		fatherRepository.deleteFatherByUserId(userId);
	}
}
