package com.carts;

import java.util.ArrayList;
import java.util.List;

import com.items.Item;
import com.users.User;

public class Cart {
	private int id;
	private User user;
	private List<Item> items=new ArrayList<>();
	private double totalPrice;

	public Cart(User user) {
		this.user = user;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(Item item) {
		items.add(item);
	}

	public Cart(int id, User user, List<Item> items, double totalPrice) {
		super();
		this.id = id;
		this.user = user;
		this.items = items;
		this.totalPrice = totalPrice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id ;
	}
	

}
