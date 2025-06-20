package com.multi.step.form.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.step.form.entities.Domain;
import com.multi.step.form.repository.DomainRepository;

@Service
public class DomainService {

	@Autowired
	private DomainRepository domainRepository;
	
	public Domain getCompanyDomain(String domain) {
		return this.domainRepository.findDomainByCompanyDomain(domain.toLowerCase());
	}
}
