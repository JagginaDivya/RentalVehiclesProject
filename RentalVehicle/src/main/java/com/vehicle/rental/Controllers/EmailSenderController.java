package com.vehicle.rental.Controllers;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;

import com.vehicle.rental.Services.EmailSenderService;

@Controller
public class EmailSenderController {

		
		@Autowired
		private EmailSenderService senderService;
		
		public String generatRandomOtp()
		{
			String otp="";
			for(int i=0;i<6;i++)
			{
				int num=(int) ((Math.random() * (9 - 0)) + 0);
				otp+=String.valueOf(num);
			}
			return otp;
		}
		
		@EventListener(ApplicationReadyEvent.class)
		public void triggerMail() throws MessagingException {
			String body="Hi, your otp is "+(generatRandomOtp());
			senderService.sendEmail("sharukahmed321@gmail.com",
					"Good night2",body						
				);
		}
		
		
	}

	
	

