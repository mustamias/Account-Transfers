package com.ac.model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class Mailsender {

	@Autowired	
JavaMailSender javaMailSender;
	
	
	
	public void  send(String from, String to, String subject, String body) {
		
		SimpleMailMessage mail = new SimpleMailMessage();
 
		mail.setFrom(from);
		mail.setTo(to);
		mail.setSubject(subject);
		mail.setText(body);
		
		
		
		javaMailSender.send(mail);
		
		
	}

}
