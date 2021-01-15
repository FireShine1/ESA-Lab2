package ru.fireshine.laba4.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import ru.fireshine.laba4.utils.Utils;

@Repository
public class UtilsBean {

	@PersistenceContext
	private EntityManager em;
	
	public void fillTables() {
		Utils.fillDishesTable().forEach(s -> {
			em.createNativeQuery(s).executeUpdate();
		});
		Utils.fillRestaurantsTable().forEach(s -> {
			em.createNativeQuery(s).executeUpdate();
		});
		Utils.fillRestrauntsDishesTable().forEach(s -> {
			em.createNativeQuery(s).executeUpdate();
		});
	}
	
}
