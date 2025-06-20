package com.multi.step.form.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.multi.step.form.entities.Personal;
import com.multi.step.form.repository.PersonalRepository;


@Service
public class PersonalService {

	@Autowired
	private PersonalRepository personalRepository;
	
	@PreAuthorize("hasRole('ROLE_STUDENT') and #personal.getUserId()==authentication.name")
	public Personal savePersonal(Personal personal) {
		return personalRepository.save(personal);
	}
	
	@PreAuthorize("hasRole('ROLE_STUDENT') and #userId==authentication.name")
	public Personal getPersonalByUserId(String userId) {
		return personalRepository.findPersonalByUserId(userId);
	}
}
