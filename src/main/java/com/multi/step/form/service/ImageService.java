package com.multi.step.form.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.multi.step.form.entities.Image;
import com.multi.step.form.repository.ImageRepository;


@Service
public class ImageService {

	@Autowired
	private ImageRepository imageRepository;
	
	@PreAuthorize("hasRole('ROLE_STUDENT') and #id==authentication.name")
	public Image saveImage(MultipartFile file,String id) throws IOException {
		
		Image image = new Image();
		image.setName(file.getOriginalFilename());
		image.setData(file.getBytes());
		image.setUserId(id);
		
		return imageRepository.save(image);
	}
	
	@PreAuthorize("hasRole('ROLE_STUDENT') and #image.getUserId()==authentication.name")
	public Image updateImage(Image image) {
		return imageRepository.save(image);
	}
	
	@PreAuthorize("hasRole('ROLE_STUDENT') and #id==authentication.name")
	public Image getImage(String id) {
		Image image = imageRepository.findImageByUserId(id);
		return image;
	}
}
