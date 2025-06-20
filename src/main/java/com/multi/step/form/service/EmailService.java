package com.multi.step.form.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.multi.step.form.entities.EmailOTP;
import com.multi.step.form.repository.EmailRepository;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender mailsender;
	
	@Autowired
	private EmailRepository emailRepository;
	
	public void sendEmail(String toEmail , String subject , String body) throws MessagingException {
			
		MimeMessage mimeMessage =  mailsender.createMimeMessage();
		MimeMessageHelper message = new MimeMessageHelper(mimeMessage , true);
		message.setFrom("onlineexamportalboot@gmail.com");
		message.setTo(toEmail);
		message.setSubject(subject);
		message.setText(body);

		mailsender.send(mimeMessage);
	}
	
	public String generateOtp() {
		Random random = new Random();
		int otp = 100000 + random.nextInt(900000);
		return String.valueOf(otp);
	}
	
	public void sendOtp(String toEmail, String otp) throws MessagingException {
		MimeMessage mimeMessage = mailsender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		
		helper.setFrom("onlineexamportalboot@gmail.com");
		helper.setTo(toEmail);
		helper.setSubject("OTP for SYN Portal Email Verification");
		
		String htmlContent = "<html>" + 
				"<body>" +
				"<h1> Your OTP Code </h1>" +
				"<p>Your One-Time Password (OTP) is : <strong>" + otp + "</strong></p>" +
				"<p>This OTP is valid for <strong> 5 minutes </strong>.</p>" +
				"<p>If you didn't request this, please ignore this email.</p>" +
				"</body>" +
				"</html>" ;
		
		helper.setText(htmlContent, true);
		mailsender.send(mimeMessage);
	}
	
	public void saveEmailOtp(EmailOTP emailOTP) {
		this.emailRepository.save(emailOTP);
	}
	
	public EmailOTP getOtp(String username) {
		EmailOTP emailOTP = this.emailRepository.findByUsername(username);
		return emailOTP;
	}
}
