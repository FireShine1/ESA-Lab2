package ru.fireshine.laba3.utils;
 
import javax.persistence.EntityManager;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
 
@Component
public class ContextListener implements ServletContextListener {

	@Autowired
	private EntityManager em;
	
	@Override
	@Transactional
    public void contextInitialized(ServletContextEvent e) {
        em.createNativeQuery(Utils.createDishesTable()).executeUpdate();
        em.createNativeQuery(Utils.createRestaurantsTable()).executeUpdate();
        em.createNativeQuery(Utils.createRestaurantsDishes()).executeUpdate();
    }

    public void contextDestroyed(ServletContextEvent e) {}
    
}