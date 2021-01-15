package ru.fireshine.laba4.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.fireshine.laba4.dao.EventDao;
import ru.fireshine.laba4.model.Event;

@Service
@Transactional
public class EventService {
	
	@Autowired
	private EventDao eventDao;
	
	public Iterable<Event> findAll() {
		return eventDao.findAll();
	}

	public Optional<Event> findById(Long id) {
		return eventDao.findById(id);
	}

	public void insert(Event e) {
		eventDao.save(e);
	}

	public void delete(Long id) {
		eventDao.deleteById(id);
	}
	
}