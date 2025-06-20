package com.multi.step.form.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.multi.step.form.entities.BarcodeUser;
import com.multi.step.form.repository.BarcodeRepository;

@Service
public class BarcodeService {
	
	@Autowired
	private BarcodeRepository barcodeRepository;
	
	@PreAuthorize("hasRole('ROLE_STUDENT') and #username==authentication.name")
	public void generateQRCodeImage(String barcodeURL, int width, int height, String filePath, String username) 
            throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(barcodeURL, BarcodeFormat.QR_CODE, width, height);

        Path path = FileSystems.getDefault().getPath(filePath);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
    }
	
	@PreAuthorize("hasRole('ROLE_STUDENT') and #username==authentication.name")
	public BarcodeUser storeImageFromFile(String path, String username, String barcodeUrl, String email) throws IOException {
		
	    File file = new File(path);
	    
	    BarcodeUser image = new BarcodeUser();
	    image.setBarcodeUrl(barcodeUrl);
	    image.setData(Files.readAllBytes(file.toPath()));
	    image.setEmail(email);
	    image.setName(file.getName());
	    image.setUsername(username);
	    
	    return this.barcodeRepository.save(image);
	}
	
	@PreAuthorize("hasRole('ROLE_STUDENT') and #username==authentication.name")
	public BarcodeUser saveBarcodeUser(BarcodeUser barcodeUser, String username) {
		return this.barcodeRepository.save(barcodeUser);
	}
	
	@PreAuthorize("hasRole('ROLE_STUDENT') and #username==authentication.name")
	public BarcodeUser getBarcodeUserByEmail(String email, String username) {
		return this.barcodeRepository.findByEmail(email);
	}

}
