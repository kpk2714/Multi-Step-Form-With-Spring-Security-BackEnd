package com.multi.step.form.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.multi.step.form.entities.Pdf;
import com.multi.step.form.repository.PdfRepository;

@Service
public class PdfService {

	@Autowired
	private PdfRepository pdfRepository;
	
	@PreAuthorize("hasRole('ROLE_STUDENT') and #id==authentication.name")
	public Pdf savePdf(MultipartFile file , String id , String name , String status) throws IOException {
		Pdf pdf = new Pdf();
		pdf.setFilename(file.getOriginalFilename());
		pdf.setUserId(id);
		pdf.setData(file.getBytes());
		pdf.setDocumentName(name);
		pdf.setStatus(status);
		
		return pdfRepository.save(pdf);
	}
	
	@PreAuthorize("hasRole('ROLE_STUDENT') and #pdf.getUserId()==authentication.name")
	public Pdf updatePdf(Pdf pdf) {
		return pdfRepository.save(pdf);
	}
	
	@PreAuthorize("hasRole('ROLE_STUDENT') and #id==authentication.name")
	public Pdf getPdf(String id,String name) {
		return pdfRepository.findPdfByUserIdAndDocumentName(id,name);
	}
	
	@PreAuthorize("hasRole('ROLE_STUDENT') and #userId==authentication.name")
	public Pdf getPdfByDocumentName(String name, String userId) {
		return pdfRepository.findPdfByDocumentName(name);
	}
	
	@PreAuthorize("hasRole('ROLE_STUDENT') and #userId==authentication.name")
	public String compressFilename(String name, String userId) {
		String filename = "";
		System.out.println("Filename Length : "+name.length());
		if(name.length()>15) {
			filename = name.substring(0, 6) + ".." + ".pdf";
			return filename;
		}
		return name;
	}
}
