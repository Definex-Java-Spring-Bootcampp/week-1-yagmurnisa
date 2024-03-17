package com.patika.kredinbizdenservice.shopping;

public class Product {
	
	String name;
	double price;
	String category;
	int stock;
	
	public Product() {
		
	}
	
	public Product(String name, double price, String category, int stock) {
		super();
		this.name = name;
		this.price = price;
		this.category = category;
		this.stock = stock;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
}
