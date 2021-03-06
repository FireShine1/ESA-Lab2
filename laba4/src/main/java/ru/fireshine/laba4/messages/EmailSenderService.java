package ru.fireshine.laba4.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import ru.fireshine.laba4.model.Email;

@Component
public class EmailSenderService {

	 @Autowired
	 private JavaMailSender mailSender;

	 public void send(Email email){
		 SimpleMailMessage message = new SimpleMailMessage();
		 message.setFrom("example@mail.com");
		 message.setTo(email.getReceiver());
		 message.setSubject(email.getSubject());
		 message.setText(email.getBody());
		 mailSender.send(message);
	 }
	
}