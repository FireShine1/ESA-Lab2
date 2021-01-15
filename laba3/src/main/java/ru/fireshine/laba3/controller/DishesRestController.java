package ru.fireshine.laba3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ru.fireshine.laba3.model.Dish;
import ru.fireshine.laba3.service.DishService;

@RestController
public class DishesRestController {
	
	@Autowired
	private DishService dishService;
	
	@GetMapping(path = "/rest/dishes", 
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<Dish>> viewDishes(){
		List<Dish> dishes = dishService.findAll();
		return ResponseEntity.ok(dishes);
	}
	
	@PostMapping(value = "/rest/dishes/add", 
			consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, 
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Dish> addDish(@RequestBody Dish dish) {
		dishService.insert(dish);
		return ResponseEntity.ok(dish);
	}
	
	@PutMapping(value = "/rest/dishes/update/{id}", 
			consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, 
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Dish> updateDish(@RequestBody Dish dish, @PathVariable Long id) {
		if (dishService.findById(id) == null) {
			return ResponseEntity.notFound().build();
		} else {
			dishService.update(dish);
			return ResponseEntity.ok(dish);
		}
	}
	
	@DeleteMapping(value = "/rest/dishes/delete/{id}")
	public ResponseEntity<Void> delDish(@PathVariable Long id) {
		if (dishService.findById(id) == null) {
			return ResponseEntity.badRequest().build();
		} else {
			dishService.delete(id);
			return ResponseEntity.ok().build();
		}
	}
	
}