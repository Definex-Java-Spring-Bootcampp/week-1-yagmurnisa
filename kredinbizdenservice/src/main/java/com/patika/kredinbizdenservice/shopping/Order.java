package com.patika.kredinbizdenservice.shopping;

import java.util.*;

public class Order {
	
	Customer customer;
	List<Product> products;
	Bill bill;
	
	public Order() {
		products = new ArrayList<>();
	}
	
	public Order(Customer customer) {
		this.customer = customer;
		products = new ArrayList<>();
	}
	
	public Order(Customer customer, List<Product> products) {
		super();
		this.customer = customer;
		this.products = products;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}	

	public void addProduct(Product p) {
		products.add(p);
	}
}
