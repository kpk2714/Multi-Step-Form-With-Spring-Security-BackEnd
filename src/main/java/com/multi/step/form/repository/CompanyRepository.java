package com.multi.step.form.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multi.step.form.entities.Company;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface CompanyRepository extends JpaRepository<Company,Integer> {

	public List<Company> findAllCompanyByUserId(String id);
	public void deleteCompanyByCompanyId(String companyId);
}
