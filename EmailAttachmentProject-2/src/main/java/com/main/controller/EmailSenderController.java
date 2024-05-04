package com.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.main.model.EmailSender;
import com.main.service.EmailSenderInterface;
import com.main.util.EmailSenderUtility;

import jakarta.mail.MessagingException;


@CrossOrigin


@RestController
public class EmailSenderController {
	@Autowired
	EmailSenderInterface esi;
	
	@Autowired
	EmailSenderUtility eu;

	@Value("${spring.mail.username}")
	private String fromEmail;

//	@PostMapping("/SendEmail ") // Send Email From Hardcore Through
//	public ResponseEntity<String> sendEmailData(@RequestBody EmailSender e) {
//
//		try {
//			e.setFromEmail(fromEmail);
//			esi.sendEmail(e);
//		} catch (Exception ex) {
//			return new ResponseEntity<String>("Email Not Sent", HttpStatus.NOT_FOUND);
//		}
//		return new ResponseEntity<String>("Email Not Sent", HttpStatus.OK);
//
//	}

	 
	// MediaType.MULTIPART_FORM_DATA_VALUE)

//	@PostMapping("/uploadEmail")
	@PostMapping(value = "/uploadEmail", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public ResponseEntity<String> sendDocument(@RequestPart("p") MultipartFile file1,
			@RequestPart("ac") MultipartFile file2, @RequestPart("email") String email) throws MessagingException, JsonMappingException, JsonProcessingException {

		
		ObjectMapper op=new ObjectMapper();
		EmailSender s=op.readValue(email, EmailSender.class);
			s.setFromEmail(fromEmail);
			 
			
			eu.uploadDocument(file1, file2, s);
			System.out.println("fuss");
			
//			return new ResponseEntity<String>("File not Uploaded", HttpStatus.INTERNAL_SERVER_ERROR);
	

		return new ResponseEntity<>("File Uploaded", HttpStatus.OK);
}
}

//		return ResponseEntity<String>("Email Uploaded",HttpStatus.OK);
