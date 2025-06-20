package com.multi.step.form.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.multi.step.form.entities.WifeHus;
import com.multi.step.form.repository.WifeHusRepository;

@Service
public class WifeHusService {

	@Autowired
	private WifeHusRepository wifeHusRepository;
	
	@PreAuthorize("hasRole('ROLE_STUDENT') and #wifeHus.getUserId()==authentication.name")
	public WifeHus save(WifeHus wifeHus) {
		return wifeHusRepository.save(wifeHus);
	}
	
	@PreAuthorize("hasRole('ROLE_STUDENT') and #id==authentication.name")
	public WifeHus getWifeHusByUserId(String id) {
		return wifeHusRepository.findWifeHusByUserId(id);
	}
	
	@PreAuthorize("hasRole('ROLE_STUDENT') and #userId==authentication.name")
	public void deleteWifeHus(String userId) {
		wifeHusRepository.deleteWifeHusByUserId(userId);
	}
}
