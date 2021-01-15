package ru.fireshine.laba4.dao;

import org.springframework.data.repository.CrudRepository;

import ru.fireshine.laba4.model.Event;

public interface EventDao extends CrudRepository<Event, Long> {

}