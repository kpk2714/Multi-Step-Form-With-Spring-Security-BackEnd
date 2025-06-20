package com.multi.step.form.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.multi.step.form.entities.Company;
import com.multi.step.form.repository.CompanyRepository;

@Service
public class CompanyService {

	@Autowired
	private CompanyRepository companyRepository;
	
	@PreAuthorize("hasRole('ROLE_STUDENT') and #company.getUserId()==authentication.name")
	public Company saveCompany(Company company) {
		return companyRepository.save(company);
	}
	
	@PreAuthorize("hasRole('ROLE_STUDENT') and #id==authentication.name")
	public List<Company> getAllCompanyByUserId(String id) {
		return companyRepository.findAllCompanyByUserId(id);
	}
	
	@PreAuthorize("hasRole('ROLE_STUDENT') and #userId==authentication.name")
	public void deleteCompany(String companyId, String userId) {
		companyRepository.deleteCompanyByCompanyId(companyId);
	}
}
