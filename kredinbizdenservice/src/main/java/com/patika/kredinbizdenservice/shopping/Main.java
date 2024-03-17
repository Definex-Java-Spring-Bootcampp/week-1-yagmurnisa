package com.patika.kredinbizdenservice.shopping;
import java.util.*;

public class Main {
	
	static List<Customer> customers = new ArrayList();
	static List<Order> orders = new ArrayList();
	static List<Product> products = new ArrayList();
	
	public static void main(String[] args) {
			
		Customer user1 = new Customer("Cem",30);
		Customer user2 = new Customer("Cem",27);
		Customer user3 = new Customer("Cem",24);
		Customer user4 = new Customer("Yağmur",24);
		
		customers.addAll(Arrays.asList(user1, user2, user3, user4));
		
		Product product1 = new Product("television", 15000, "technology", 20);
		Product product2 = new Product("telephone", 20000, "technology", 80);
		Product product3 = new Product("picture", 80, "decoration", 20);
		Product product4 = new Product("vase", 50, "decoration", 30);
		Product product5 = new Product("shoes", 500, "clothing", 50);
		
		products.addAll(Arrays.asList(product1, product2, product3, product4, product5));
			
		List<Product> list1 = new ArrayList<>();
		list1.add(product1);
		list1.add(product3);
		
		List<Product> list2 = new ArrayList<>();
		list2.add(product3);
		list2.add(product4);
		list2.add(product5);
		
		List<Product> list3 = new ArrayList<>();
		list3.add(product2);
		list3.add(product4);
	
		Order order1 = createOrder(user1, list1);
		Order order2 = createOrder(user2, list2);
		Order order3 = createOrder(user3, list3);
		
		System.out.println("Customers in the system: "+ customerAmount());
		System.out.println("Total products of customers who are named Cem: "+ productsByCustomer("Cem"));
		billsOverPrice(1500);
		System.out.println("Shopping cost for customers who are named Cem and between 25 and 30: " + priceByCustomer("gg", 25, 30));
	}

	public static int customerAmount() {
		return customers.size();
	}
	
	public static int productsByCustomer(String name) {
		int products=0;
		products = orders.stream().filter(o -> o.getCustomer().getName().equals(name)).mapToInt(o -> o.getProducts().size()).sum();
		/*for (Order o: orders) {
			if (o.getCustomer().getName().equals(name)) {
					products+=o.getProducts().size();
				}		
			}
		}*/
		return products;
	}
	
	public static double priceByCustomer(String name, int fromAge, int toAge) {
		double price = 0;
		price = orders.stream().filter(o -> o.getCustomer().getName().equals(name) && o.getCustomer().getAge() < toAge && o.getCustomer().getAge() > fromAge).mapToDouble(o -> o.getBill().getPrice()).sum();
		/*for (Order o: orders) {
			if (o.getCustomer().getName().equals(name) && o.getCustomer().getAge() < toAge && o.getCustomer().getAge() > fromAge) {
				price+=o.getBill().getPrice();
			}
		}*/
		return price;
	}
	
	public static Order createOrder(Customer customer, List<Product> list) {
		Order order = new Order(customer, list);
		double price = list.stream().mapToDouble(Product::getPrice).sum();
		Bill bill = new Bill(price);
		order.setBill(bill);
		customer.getOrders().add(order);
		orders.add(order);
		return order;
	}
	
	public static void billsOverPrice(double price) {
		System.out.println("Bills over 1500 Tl: ");
		orders.stream().filter(o -> o.getBill().getPrice() > price).forEach(o -> System.out.println(o.getBill().price));
		/*for (Bill bill: bills) {
			if (b.getPrice() > price) {
				System.out.println(b);
			}
		}*/
	}
}
