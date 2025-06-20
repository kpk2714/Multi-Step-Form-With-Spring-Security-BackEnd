package com.multi.step.form.controller;

import java.io.File;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.multi.step.form.entities.AuthenticatedUser;
import com.multi.step.form.entities.BarcodeUser;
import com.multi.step.form.entities.User;
import com.multi.step.form.service.AuthService;
import com.multi.step.form.service.AuthenticatorService;
import com.multi.step.form.service.BarcodeService;
import com.multi.step.form.service.UserService;

@RestController
@CrossOrigin("http://localhost:4200")
public class AuthenticatorController {
	
	@Autowired
	private AuthenticatorService authenticatorService;
	
	@Autowired
	private AuthService authService;

	@Autowired
	private UserService userService;
	
	@Autowired
	private BarcodeService barcodeService;
	
	@GetMapping("/verifyStudent") 
	public ResponseEntity<?> verifyStudentDetails(@RequestParam("studentId") String studentId, @RequestParam("email") String email) {
		
		Map<String, Object> responseBody = new HashMap<>();
		
		String id = this.userService.getStudentId(email);
		System.out.println("Student -> " + id);
		if(id == null) {
			responseBody.put("message", "Wrong Email !");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
		}
		
		if(studentId.equals(id)) {
			responseBody.put("auth", true);
			return ResponseEntity.status(HttpStatus.OK).body(responseBody);
		} else {
			responseBody.put("message", "Wrong Student Id !");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
		}
	}
	
	@GetMapping("/generate-secret")
	public ResponseEntity<?> generateSecret(@RequestParam String email) throws Exception {
		
		Map<String, Object> responseBody = new HashMap<>();
		
		User user = userService.getUser(email);
		String secretKey = authenticatorService.generateSecrateKey();
		AuthenticatedUser authUser = this.authService.getSecretKey(email);
		
		if(user!=null) {
			
			if(authUser == null) {
				
				authUser = new AuthenticatedUser();
				
				authUser.setUsername(user.getUsername());
				authUser.setEmail(email);
				authUser.setSecretKey(secretKey);
				authUser.setAuthBind(false);
				
			} else {
				authUser.setSecretKey(secretKey);
			}
			
			this.authService.saveAuthUser(authUser);
			
		} else {
			
			responseBody.put("message", "Wrong Email !");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
		}
		
		responseBody.put("secretKey", secretKey);
        return ResponseEntity.ok(responseBody);
	}
	
	@GetMapping("/generate-qrcode")
	public ResponseEntity<?> generateQRCode(@RequestParam String email) throws Exception {
		
		Map<String, Object> responseBody = new HashMap<>();
		
		User user = userService.getUser(email);
		
		AuthenticatedUser authUser = authService.getSecretKey(email);
		String secretKey = authUser == null ? null : authUser.getSecretKey();
		String qrCodeUrl = authenticatorService.getQRBarcodeURL(email, secretKey);
		
		BarcodeUser barcode = this.barcodeService.getBarcodeUserByEmail(email, user.getUsername());

		try {
			
			String filePath = System.getProperty("user.dir")+"/src/main/resources/static/image/QRCode.png"; // Save location for the QR code
            barcodeService.generateQRCodeImage(qrCodeUrl, 200, 200, filePath, authUser.getUsername());
            
            if(user!=null) {
    			
            	if(barcode == null) {
            		
            		barcode = new BarcodeUser();
            		
            		File file = new File(filePath);
            		barcode.setBarcodeUrl(qrCodeUrl);
            		barcode.setData(Files.readAllBytes(file.toPath()));
            		barcode.setName(file.getName());
            		barcode.setEmail(email);
            		barcode.setUsername(user.getUsername());
            		
            		this.barcodeService.saveBarcodeUser(barcode, user.getUsername());
            		
            	} else {
            		
            		File file = new File(filePath);
            		
            		barcode.setBarcodeUrl(qrCodeUrl);
            		barcode.setData(Files.readAllBytes(file.toPath()));
            	    barcode.setName(file.getName());
            	    
            	    this.barcodeService.saveBarcodeUser(barcode, user.getUsername());
            	}
    			
    			
    		} else {
    			responseBody.put("message", "User is not registered !");
    			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
    		}
            
        } catch (Exception e) {
        	
        	responseBody.put("message", "QR Code is not generated !");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
			
        }
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).contentType(MediaType.IMAGE_PNG).contentType(MediaType.IMAGE_GIF).body(barcode==null ? null : barcode.getData());
	}
	
	@GetMapping("/verify-secret")
	public ResponseEntity<?> verifySecret(@RequestParam String email, @RequestParam String otp) {
		
		Map<String, Object> responseBody = new HashMap<>();
		
		User user = userService.getUser(email);
		
		AuthenticatedUser authUser = authService.getSecretKey(email);
		System.out.println("Auth User -> " + authUser);
		String secretKey = authUser == null ? null : authUser.getSecretKey();
		System.out.println("Secret Key -> " + secretKey);
		boolean isAuthenticated =  this.authenticatorService.verifyAuthenticatorOtp(secretKey, Integer.parseInt(otp));
		System.out.println("Authenticated -> " + isAuthenticated);
		responseBody.put("isAuthenticated", isAuthenticated);
		return ResponseEntity.ok(responseBody);
	}
	
	@GetMapping("/verify-authenticator-bind")
	public ResponseEntity<?> verifyAuthBind(@RequestParam String email) {
		
		Map<String, Object> responseBody = new HashMap<>();
		
		User user = userService.getUser(email);
		AuthenticatedUser authUser =  this.authService.isAuthBind(email);
		
		responseBody.put("isAuthBind", authUser == null ? null : authUser.isAuthBind());
		return ResponseEntity.ok(responseBody);
	}
	
	@GetMapping("/update-authenticator-bind")
	public ResponseEntity<?> getAuthenticatorDetails(@RequestParam("email") String email) {
		
		Map<String, Object> responseBody = new HashMap<>();
		
		User user = userService.getUser(email);
		AuthenticatedUser authUser =  this.authService.isAuthBind(email);
		
		if(authUser.isAuthBind() == false) {
			
			authUser.setAuthBind(true);
			this.authService.saveAuthUser(authUser);
			
			responseBody.put("isBind", "Authenticator is bind successfully !");
			return ResponseEntity.ok(responseBody);
			
		} else {
			responseBody.put("message", "Authenticator is already bonded !");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
		}
	}
}
