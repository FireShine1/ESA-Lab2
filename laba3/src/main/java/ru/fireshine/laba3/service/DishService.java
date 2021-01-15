package ru.fireshine.laba3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.fireshine.laba3.dao.DishDAO;
import ru.fireshine.laba3.model.Dish;

@Service
@Transactional
public class DishService {
	
	@Autowired
	private DishDAO dishDao;

	public List<Dish> findAll() {
		return dishDao.findAll();
	}

	public Dish findById(Long id) {
		return dishDao.findById(id);
	}

	public void insert(Dish d) {
		dishDao.insert(d);
	}

	public void update(Dish d) {
		dishDao.update(d);
	}

	public void delete(Long id) {
		dishDao.delete(id);
	}
	
}
