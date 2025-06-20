package com.multi.step.form.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.multi.step.form.entities.Pdf;
import com.multi.step.form.service.PdfService;

@RestController
@CrossOrigin("http://localhost:4200")
public class PdfController {

	@Autowired
	private PdfService pdfService;
	
	@PostMapping("/savePdf")
	public ResponseEntity<?> savePdf(@RequestParam("file") MultipartFile file,@RequestParam("userId") String userId, @RequestParam("documentName") String documentName,@RequestParam("status") String status) throws IOException{
		
		Map<String, Object> responseBody = new HashMap<>();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getPrincipal())) {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
        }
			
		String username = authentication.getName();
		
		Pdf pdf = pdfService.getPdf(userId,documentName);
	
		if(username.equals(userId)) {
			if(pdf==null) {
				pdf = pdfService.savePdf(file, userId , documentName , status);
				responseBody.put("pdf", pdf);
				return ResponseEntity.ok(responseBody);
			}
			else {
				pdf.setUserId(userId);
				pdf.setFilename(pdfService.compressFilename(file.getOriginalFilename(), userId));
				pdf.setData(file.getBytes());
				pdf.setDocumentName(documentName);
				pdf.setStatus(status);
						
				pdf = pdfService.updatePdf(pdf);
				responseBody.put("pdf", pdf);
				return ResponseEntity.ok(responseBody);
			}
		}
		else {
				responseBody.put("message", "Unauthorized User");
		        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
		}
	}
	
	@GetMapping("/getPdf")
	public ResponseEntity<?> getPdf(@RequestParam("userId") String userId , @RequestParam("documentName") String documentName) throws Exception{
		
		Map<String, Object> responseBody = new HashMap<>();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getPrincipal())) {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
        }
			
		String username = authentication.getName();
		
		Pdf pdf = null;
		
		if(username.equals(userId)) {
			pdf = pdfService.getPdf(userId,documentName);
			System.out.println(pdf);
			responseBody.put("pdf", pdf);
			return ResponseEntity.ok().contentType(MediaType.APPLICATION_PDF).body(pdf.getData());
		}
		else {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
		}
		
		//return ResponseEntity.ok().contentType(MediaType.APPLICATION_PDF).body(pdf.getData());
	}
	
	@GetMapping("/getPdfByDocumentName")
	public ResponseEntity<?> getDocument(@RequestParam("documentName") String name , @RequestParam("userId") String userId) throws Exception {
		
		Map<String, Object> responseBody = new HashMap<>();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getPrincipal())) {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
        }
			
		String username = authentication.getName();
		
		Pdf pdf = null;
		
		if(username.equals(userId)) {
			pdf = pdfService.getPdfByDocumentName(name, userId);
			
			responseBody.put("pdf", pdf);
	        return ResponseEntity.ok(responseBody);
		}
		else {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
		}
	}
}

