package com.multi.step.form.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.multi.step.form.entities.Technical;
import com.multi.step.form.repository.TechnicalRepository;

@Service
public class TechnicalService {

	@Autowired
	private TechnicalRepository technicalRepository;
	
	@PreAuthorize("hasRole('ROLE_STUDENT') and #technical.getUserId()==authentication.name")
	public Technical save(Technical technical) {
		return technicalRepository.save(technical);
	}
	
	@PreAuthorize("hasRole('ROLE_STUDENT') and #id==authentication.name")
	public List<Technical> getAllTechnical(String id){
		return technicalRepository.findAllTechnicalByUserId(id);
	}
	
	@PreAuthorize("hasRole('ROLE_STUDENT') and #userId==authentication.name")
	public void deleteTechnical(String skillId, String userId) {
		technicalRepository.deleteTechnicalBySkillId(skillId);
	}
}
