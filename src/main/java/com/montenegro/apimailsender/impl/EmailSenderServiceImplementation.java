package com.montenegro.apimailsender.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.montenegro.apimailsender.service.EmailSenderService;

@Service
public class EmailSenderServiceImplementation implements EmailSenderService {

	private final JavaMailSender mailSender;
	
	@Value("${EMAIL}") private String emailFrom;
		
	public EmailSenderServiceImplementation(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	@Override
	public void SendEmail(String to, String subject, String message) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom(emailFrom);
		simpleMailMessage.setTo(to);
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(message);

		this.mailSender.send(simpleMailMessage);
	}

}
