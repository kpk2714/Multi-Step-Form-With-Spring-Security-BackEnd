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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.multi.step.form.entities.Image;
import com.multi.step.form.service.ImageService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ImageController {

	@Autowired
	private ImageService imageService;
	
	@PostMapping("/upload/userId={id}")
	public ResponseEntity<?> uplaodImage(@PathVariable String id,@RequestParam("file") MultipartFile file) {
		
		Map<String, Object> responseBody = new HashMap<>();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getPrincipal())) {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
        }
			
		String username = authentication.getName();
		
		if(username.equals(id)) {
			Image image = imageService.getImage(id);
			try {
				if(image==null) {
					image = imageService.saveImage(file,id);
					
					if(image==null) {
						responseBody.put("message", "Internal Server Error!");
						return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
					}
					
					responseBody.put("image", image);
					return ResponseEntity.ok(responseBody);
				}
				else {
					image.setName(file.getOriginalFilename());
					image.setData(file.getBytes());
					image.setUserId(id);
					
					image = imageService.updateImage(image);
					
					if(image==null) {
						responseBody.put("message", "Internal Server Error!");
						return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
					}
					
					responseBody.put("image", image);
					return ResponseEntity.ok(responseBody);
				}
			}
			catch(IOException e) {
				responseBody.put("message", "Server Error");
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
			}
		} else {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
		}
	}
	
	@GetMapping("/get/image/userId={id}")
	public ResponseEntity<?> getImage(@PathVariable String id){
		
		Map<String, String> responseBody = new HashMap<>();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getPrincipal())) {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
        }
			
		String username = authentication.getName();
		Image image = null;
		if(username.equals(id)) {
			image = imageService.getImage(id);
		} else {
			responseBody.put("message", "Unauthorized User");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
		}
		
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).contentType(MediaType.IMAGE_PNG).contentType(MediaType.IMAGE_GIF).body(image==null ? null : image.getData());
	}
}
