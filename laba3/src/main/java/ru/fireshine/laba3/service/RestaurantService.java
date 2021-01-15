package ru.fireshine.laba3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.fireshine.laba3.dao.RestaurantDAO;
import ru.fireshine.laba3.model.Restaurant;

@Service
@Transactional
public class RestaurantService {
	
	@Autowired
	private RestaurantDAO restaurantDao;

	public List<Restaurant> findAll() {
		return restaurantDao.findAll();
	}
	
	public List<Restaurant> findAll(String cookery, List<String> dishes) {
		return restaurantDao.findAll(cookery, dishes);
	}

	public Restaurant findById(Long id) {
		return restaurantDao.findById(id);
	}

	public void insert(Restaurant r) {
		restaurantDao.insert(r);
	}

	public void update(Restaurant r) {
		restaurantDao.update(r);
	}

	public void delete(Long id) {
		restaurantDao.delete(id);
	}
	
}