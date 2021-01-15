package ru.fireshine.laba4.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import ru.fireshine.laba4.model.Email;
import ru.fireshine.laba4.model.Event;
import ru.fireshine.laba4.service.EmailService;
import ru.fireshine.laba4.service.EventService;

@Component
public class JmsSubscriber {
	
	@Autowired
	private EmailSenderService emailSenderService;
	@Autowired
    private EventService eventService;
    @Autowired
    private EmailService emailService;

    @JmsListener(destination = "event", containerFactory = "jmsContainerFactory")
    public void receiveEvent(Event event) {
    	eventService.insert(event);
    }

    @JmsListener(destination = "email", containerFactory = "jmsContainerFactory")
    public void receiveMessage(Email email) {
        emailSenderService.send(email);
        emailService.insert(email);
    }
	
}