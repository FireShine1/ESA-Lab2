package ru.fireshine.laba4.controller;

import java.io.StringReader;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import ru.fireshine.laba4.model.Dish;
import ru.fireshine.laba4.model.Restaurant;
import ru.fireshine.laba4.service.DishService;
import ru.fireshine.laba4.service.RestaurantService;

@Controller
@RequestMapping("/xml")
public class XmlController {
	
	@Autowired
	private RestaurantService restaurantService;
	@Autowired
	private DishService dishService;
	
	@ResponseBody
    @GetMapping(path = "/dishes", produces = MediaType.APPLICATION_XML_VALUE)
    private ModelAndView viewDishes() throws JsonProcessingException {
        Iterable<Dish> dishes =  dishService.findAll();
        return getModelAndView(dishes, "dishes_xsl");
    }
	
	@ResponseBody
    @GetMapping(path = "/restaurants", produces = MediaType.APPLICATION_XML_VALUE)
    private ModelAndView viewRestaurants() throws JsonProcessingException {
        Iterable<Restaurant> restaurants =  restaurantService.findAll();
        return getModelAndView(restaurants, "restaurants_xsl");
    }
	
	private ModelAndView getModelAndView(Iterable<?> list, String viewName) throws JsonProcessingException {
		String str = new XmlMapper().writeValueAsString(list);
		ModelAndView mod = new ModelAndView(viewName);
		Source src = new StreamSource(new StringReader(str));
    	mod.addObject("ArrayList", src);
    	return mod;
	}
	
}