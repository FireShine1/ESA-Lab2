package ru.fireshine.laba3.controller;

import java.util.ArrayList;
import java.util.Collections;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ru.fireshine.laba3.model.Restaurant;
import ru.fireshine.laba3.service.RestaurantService;

@RestController
public class RestaurantsRestController {
	
	@Autowired
	private RestaurantService restaurantService;
	
	@GetMapping(value="/rest/restaurants", 
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<Restaurant>> viewRestaurants() {
		List<Restaurant> restaurants = restaurantService.findAll();
		return ResponseEntity.ok(restaurants);
	}
	
	@PostMapping(value = "/rest/restaurants/add", 
			consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, 
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant restaurant) {
		restaurantService.insert(restaurant);
		return ResponseEntity.ok(restaurant);
	}
	
	@PutMapping(value = "/rest/restaurants/update/{id}", 
			consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, 
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Restaurant> saveRestaurant(@RequestBody Restaurant restaurant, @PathVariable Long id) {
		if (restaurantService.findById(id) == null) {
			return ResponseEntity.notFound().build();
		} else {
			restaurantService.update(restaurant);
			return ResponseEntity.ok(restaurant);
		}
	}
	
	@DeleteMapping(value = "/rest/restaurants/delete/{id}")
	public ResponseEntity<Void> delRestaurant(@PathVariable Long id) {
		if (restaurantService.findById(id) == null) {
			return ResponseEntity.badRequest().build();
		} else {
			restaurantService.delete(id);;
			return ResponseEntity.ok().build();
		}
	}
	
	@GetMapping(value = "/rest/restaurants/search")
	public ResponseEntity<List<Restaurant>> search(@RequestParam(required = false) String cookery, 
			@RequestParam(required = false) String dishesToFind) {
		String dishes[] = dishesToFind.split(",");
		List<String> dishesList = new ArrayList<>();
		Collections.addAll(dishesList, dishes);
		return ResponseEntity.ok(restaurantService.findAll(cookery, dishesList));
	}
	
}