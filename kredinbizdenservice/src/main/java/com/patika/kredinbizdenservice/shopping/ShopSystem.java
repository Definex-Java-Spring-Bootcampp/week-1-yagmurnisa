package com.patika.kredinbizdenservice.shopping;

import java.util.ArrayList;
import java.util.List;

public class ShopSystem {

	List<Customer> customers = new ArrayList();
	List<Order> orders = new ArrayList();
	List<Product> products = new ArrayList();
	
	public List<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public int customerNumber() {
		return customers.size();
	}
	public int productsByCustomer(String name) {
		int products=0;
		for (Customer c: customers) {
			if (c.getName().equals(name)) {
				products+=c.getOrders().size();
			}
		}
		return products;
	}
	public float priceByCustomer(String name, int fromAge, int toAge) {
		float price=0;
		for (Customer c: customers) {
			if (c.getName().equals(name) && c.getAge() < toAge && c.getAge() > fromAge) {
				List<Order> orders = c.getOrders();
				for (Order o: orders) {
					price+=o.getBill().getPrice();
				}
			}
		}
		return price;
	}
}
