package ru.fireshine.laba4.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.fireshine.laba4.dao.EmailDao;
import ru.fireshine.laba4.model.Email;

@Service
@Transactional
public class EmailService {
	
	@Autowired
	private EmailDao emailDao;
	
	public Iterable<Email> findAll() {
		return emailDao.findAll();
	}

	public Optional<Email> findById(Long id) {
		return emailDao.findById(id);
	}

	public void insert(Email e) {
		emailDao.save(e);
	}

	public void delete(Long id) {
		emailDao.deleteById(id);
	}
	
}