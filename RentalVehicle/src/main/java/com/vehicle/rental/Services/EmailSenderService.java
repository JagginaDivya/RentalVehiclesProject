package com.vehicle.rental.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

	
	@Autowired
	JavaMailSender mailsender;
	
	public void sendEmail(String to,String subject,String body)
	{
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setFrom("jagginaonline@gmail.com");
		msg.setTo(to);
		msg.setSubject(subject);
		msg.setText(body);
		mailsender.send(msg);
		System.out.print("mail sent successfully");
	}
	
}
