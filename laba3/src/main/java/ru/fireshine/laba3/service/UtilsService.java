package ru.fireshine.laba3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.fireshine.laba3.dao.UtilsBean;

@Service
@Transactional
public class UtilsService {
	
	@Autowired
	private UtilsBean utils;
	
	public void fillTables() {
		utils.fillTables();
	}
	
}