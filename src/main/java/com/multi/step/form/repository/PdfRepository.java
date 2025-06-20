package com.multi.step.form.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multi.step.form.entities.Pdf;

@Repository
public interface PdfRepository extends JpaRepository<Pdf,Integer> {

	public Pdf findPdfByUserIdAndDocumentName(String id,String name);
	public Pdf findPdfByDocumentName(String name);
}
