package com.patika.kredinbizdenservice.shopping;

import java.util.*;


public class Customer {
	
	String name;
	int age;
	List<Order> orders;

	public Customer() {
		orders = new ArrayList<>();
	}
	
	public Customer(String name, int age) {
		super();
		this.name = name;
		this.age = age;
		orders = new ArrayList<>();
	}

	public Customer(String name, int age, List<Order> orders) {
		super();
		this.name = name;
		this.age = age;
		this.orders = orders;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	public void addOrder(Order order) {
		orders.add(order);
	}
	
}

