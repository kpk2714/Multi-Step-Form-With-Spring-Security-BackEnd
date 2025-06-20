package com.multi.step.form.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.multi.step.form.entities.Width;
import com.multi.step.form.repository.WidthRepository;


@Service
public class WidthService {

	@Autowired
	private WidthRepository widthRepository;
	
	@PreAuthorize("hasRole('ROLE_STUDENT') and #width.getUserId()==authentication.name")
	public Width saveWidth(Width width) {
		return widthRepository.save(width);
	}
	
	@PreAuthorize("hasRole('ROLE_STUDENT') and #userId==authentication.name")
	public Width getWidth(String userId , String formname) {
		return widthRepository.findWidthByUserIdAndFormname(userId, formname);
	}
	
	@PreAuthorize("hasRole('ROLE_STUDENT') and #userId==authentication.name")
	public List<Width> getAllWidthById(String userId){
		return widthRepository.findAllWidthByUserId(userId);
	}
	
	@PreAuthorize("hasRole('ROLE_STUDENT') and #userId==authentication.name")
	public void deleteWidth(String name,String userId) {
		widthRepository.deleteWidthByFormnameAndUserId(name,userId);
	}
}
