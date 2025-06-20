package com.multi.step.form.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.multi.step.form.entities.Child;
import com.multi.step.form.repository.ChildRepository;

@Service
public class ChildService {

	@Autowired
	private ChildRepository childRepository;
	
	@PreAuthorize("hasRole('ROLE_STUDENT') and #child.getUserId()==authentication.name")
	public Child save(Child child) {
		return childRepository.save(child);
	}
	
	@PreAuthorize("hasRole('ROLE_STUDENT') and #id==authentication.name")
	public Child getChildByUserId(String id) {
		return childRepository.findChildByUserId(id);
	}
	
	@PreAuthorize("hasRole('ROLE_STUDENT') and #userId==authentication.name")
	public void deleteChild(String userId) {
		childRepository.deleteChildByUserId(userId);
	}
}
