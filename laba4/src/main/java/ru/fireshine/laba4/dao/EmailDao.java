package ru.fireshine.laba4.dao;

import org.springframework.data.repository.CrudRepository;

import ru.fireshine.laba4.model.Email;

public interface EmailDao extends CrudRepository<Email, Long> {

}