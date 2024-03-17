package com.patika.kredinbizdenservice.shopping;

public class Bill {
	
	double price;
	
	public Bill() {
		price=0;
	}

	public Bill(double price) {
		super();
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
