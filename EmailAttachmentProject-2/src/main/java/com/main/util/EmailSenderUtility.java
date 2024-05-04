package com.main.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.main.model.EmailSender;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Component
public class EmailSenderUtility {

	@Autowired
	JavaMailSender send;

	public void sendEmailAttachment(EmailSender e) throws MessagingException {

		MimeMessage m = send.createMimeMessage();
		MimeMessageHelper mm = new MimeMessageHelper(m, true);

		mm.setTo(e.getToEmail());
		mm.setFrom(e.getFromEmail());
		mm.setCc(e.getCc());
		mm.setSubject(e.getSubject());

		// FileSystemResource f = FileSystemResource("");
		// mm.addAttachment(f.getFilename(),f);

	}

	public void uploadDocument(MultipartFile file1, MultipartFile file2,  EmailSender email) throws MessagingException {

//		email.setFromEmail("sanketrpawar121@gmail.com");

		MimeMessage m1 = send.createMimeMessage();
		try {
			MimeMessageHelper mm1 = new MimeMessageHelper(m1, true);

			System.out.println("Email" + email.getToEmail());
			mm1.setTo(email.getToEmail());
			mm1.setFrom(email.getFromEmail());
			mm1.setCc(email.getCc());
			mm1.setText("",true);
			mm1.setSubject(email.getSubject());

			mm1.addAttachment(file1.getOriginalFilename(), file1);
			mm1.addAttachment(file2.getOriginalFilename(), file2);
			
		} catch (Exception ex) {
			System.out.println(" " + ex.getMessage());
		}
	
		send.send(m1);
	
		// damn cool object

	}

}
