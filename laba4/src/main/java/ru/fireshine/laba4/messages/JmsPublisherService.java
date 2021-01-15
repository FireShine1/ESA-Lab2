package ru.fireshine.laba4.messages;

import javax.jms.JMSException;
import javax.jms.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import ru.fireshine.laba4.model.Email;
import ru.fireshine.laba4.model.Event;
import ru.fireshine.laba4.model.EventType;
import ru.fireshine.laba4.model.Restaurant;

@Service
public class JmsPublisherService {
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	public void sendRestaurantDeleted(Restaurant restaurant, EventType eventType) throws JMSException{
        Email email = new Email();
        email.setReceiver("m.pomeshchikov@mail.ru");
        email.setSubject("Ресторан с id=" + restaurant.getId() + " удален");
        String bodyPattern = "Здравствуйте, Администратор!\n\n" +
                "Из сети общественного питания был удален ресторан.\n" +
                "Ресторан: %s";
        String body = String.format(bodyPattern, restaurant.toString());
        email.setBody(body);
        Topic topic = jmsTemplate.getConnectionFactory().createConnection()
				.createSession().createTopic("email");
        jmsTemplate.convertAndSend(topic, email);
    }

    public <T> void sendEvent(Class<T> entityClass, T entity, EventType eventType) throws JMSException{
        Event event = new Event();
        event.setEventType(eventType);
        event.setEntity(entity.toString());
        event.setEntityClass(entityClass.getSimpleName());
        Topic topic = jmsTemplate.getConnectionFactory().createConnection()
				.createSession().createTopic("event");
        jmsTemplate.convertAndSend(topic, event);
    }
	
}