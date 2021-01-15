package ru.fireshine.laba2.utils;
 
import javax.persistence.*;
import javax.servlet.*;
import javax.servlet.annotation.WebListener;
 
@WebListener
public class ContextListener implements ServletContextListener {

	@PersistenceContext
	private EntityManager em;
	
	@Override
    public void contextInitialized(ServletContextEvent e) {
		em.getTransaction().begin();
        em.createNativeQuery(Utils.createDishesTable()).executeUpdate();
        em.createNativeQuery(Utils.createRestaurantsTable()).executeUpdate();
        em.createNativeQuery(Utils.createRestaurantsDishes()).executeUpdate();
        em.getTransaction().commit();
    }

    public void contextDestroyed(ServletContextEvent e) {}
    
}