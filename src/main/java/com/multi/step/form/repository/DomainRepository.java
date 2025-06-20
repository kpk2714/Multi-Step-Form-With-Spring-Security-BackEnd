package com.multi.step.form.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multi.step.form.entities.Domain;

@Repository
public interface DomainRepository extends JpaRepository<Domain, Integer> {
	public Domain findDomainByCompanyDomain(String domain);
}
