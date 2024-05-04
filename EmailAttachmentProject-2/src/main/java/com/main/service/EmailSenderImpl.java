package com.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.main.model.EmailSender;
import com.main.util.EmailSenderUtility;

import jakarta.mail.MessagingException;

@Service
public class EmailSenderImpl implements EmailSenderInterface{

	@Autowired
	EmailSenderUtility esu;
	@Override
	public void sendEmail(EmailSender e) throws MessagingException 
	{
	esu.sendEmailAttachment(e);
	
		
	}

	@Override
	public void sendDocument(MultipartFile file1, MultipartFile file2, EmailSender email) {
		// TODO Auto-generated method stub
		try {
			esu.uploadDocument(file1,file2,email);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
