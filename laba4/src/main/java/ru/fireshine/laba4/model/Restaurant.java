package ru.fireshine.laba4.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Restaurants")
public class Restaurant implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String address;
	private String cookery;
	@ManyToMany(targetEntity = Dish.class,
			fetch = FetchType.EAGER)
	@JoinTable(name="RestaurantsDishes",
		joinColumns=@JoinColumn(name="restaurantId"),
		inverseJoinColumns=@JoinColumn(name="dishId")
	)
	private Set<Dish> dishes = new HashSet<Dish>();
	@Transient
	private List<Long> dishesId = new ArrayList<Long>();
	
	public List<Long> getDishesId() {
		return this.dishesId;
	}
	public void setDishesId(List<Long> dishesId) {
		this.dishesId = dishesId;
	}
	
	public Restaurant() {}
	
	public Restaurant(String name, String cookery, String address, Set<Dish> dishes) {
		this.name = name;
		this.address = address;
		this.cookery = cookery;
		setDishes(dishes);
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCookery() {
		return cookery;
	}
	public void setCookery(String cookery) {
		this.cookery = cookery;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public Set<Dish> getDishes() {
		return dishes;
	}

	public void setDishes(Set<Dish> dishes) {
		HashSet<Dish> temp = new HashSet<Dish>();
		this.dishes.forEach(d -> {
			if (!dishes.contains(d)) {
				temp.add(d);
				d.getRestaurants().remove(this);
			}
		});
		this.dishes.removeAll(temp);
		dishes.forEach(d -> {
			if (!this.dishes.contains(d)) {
				this.dishes.add(d);
				d.getRestaurants().add(this);
			}
		});
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Restaurant{").append("\n\t")
				.append("id=").append(id).append(",\n\t")
				.append("cookery='").append(cookery).append("',\n\t")
				.append("name='").append(name).append("',\n\t")
				.append("address='").append(address).append("',\n\t")
				.append("dishes=").append(dishes).append("\n")
				.append("}");
		return builder.toString();
	}

}