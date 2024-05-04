package com.main.service;

import org.springframework.web.multipart.MultipartFile;

import com.main.model.EmailSender;

import jakarta.mail.MessagingException;

public interface EmailSenderInterface {



	public void sendEmail(EmailSender e) throws MessagingException;

	public void sendDocument(MultipartFile file1, MultipartFile file2,EmailSender email) throws MessagingException;

}
