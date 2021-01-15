package ru.fireshine.laba2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ru.fireshine.laba2.model.Dish;
import ru.fireshine.laba2.service.DishService;
import ru.fireshine.laba2.service.UtilsService;

@Controller
public class DishesController {
	
	@Autowired
	private DishService dishService;
	@Autowired
	private UtilsService utils;
	
	@RequestMapping("/")
	public String startRedirect() {
		return "redirect:/dishes";
	}
	
	@RequestMapping("/dishes")
	public String viewDishes(Model m) {
		List<Dish> dishes = dishService.findAll();
		m.addAttribute("dishes", dishes);
		return "dishes";
	}
	
	@RequestMapping(value = "/addDish", method = RequestMethod.GET)
	public String dishForm(Model m, @RequestParam(required = false) Long edit) {
		if (edit == null) {
			m.addAttribute("dish", new Dish());
		} else {
			m.addAttribute("dish", dishService.findById(edit));
		}
		return "addDish";
	}
	
	@RequestMapping(value = "/addDish", method = RequestMethod.POST)
	public String saveDish(@ModelAttribute("dish") Dish dish) {
		if (dish.getId() == 0) {
			dishService.insert(dish);
		} else {
			dishService.update(dish);
		}
		return "redirect:/dishes";
	}
	
	@RequestMapping(value = "/delDish", method = RequestMethod.GET)
	public String delDish(Model m, @RequestParam Long id) {
		dishService.delete(id);
		return "redirect:/dishes";
	}
	
	@RequestMapping(value = "/fillTables", method = RequestMethod.GET)
	public String fillTables() {
		utils.fillTables();
		return "redirect:/dishes";
	}
	
}