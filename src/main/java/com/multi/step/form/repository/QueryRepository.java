package com.multi.step.form.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multi.step.form.entities.Query;

@Repository
public interface QueryRepository extends JpaRepository<Query, String> {
	
	public Query findQueryByAction(String action);
	public Query findQueryById(String id);
	public List<Query> findAllQueryByUserId(String userId);
}

