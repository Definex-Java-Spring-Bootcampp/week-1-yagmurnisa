package com.patika.kredinbizdenservice;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.patika.kredinbizdenservice.model.*;
import com.patika.kredinbizdenservice.enums.*;

//@SpringBootApplication
public class KredinbizdenServiceApplication {
	// added new constructors to some models
	static List<User> users = new ArrayList<>();
	static List<Application> apps = new ArrayList<>();
	static List<CreditCard> cards = new ArrayList<>();
	static List<Bank> banks = new ArrayList<>();
	static List<Loan> loans = new ArrayList<>();
	static List<Campaign> campaigns = new ArrayList<>();
	
	public static void main(String[] args) {
		//SpringApplication.run(KredinbizdenServiceApplication.class, args);

	}
	
	public static void mostAppliedUser() {// find the user with most applications (only one user)
		int max=0;
		User mostApplied = null;
		for (User u: users) {
			int n = u.getApplicationList().size();
			if (n > max) {
				mostApplied = u;
				max = n;
			}
		}
		System.out.println("User with most applications:");
		if (mostApplied != null) {
			System.out.println(mostApplied.toString());
		}			
	}
	
	
	public static void listApplicationsByUser(String email) {
		for (User u: users) {
			if (u.getEmail().equals(email)) {
				for(Application a: u.getApplicationList()) {
					System.out.println(a.toString());
				}
				break;
			}
		}
		//users.stream().filter(user -> user.getEmail().equals(email)).map(user -> user.getApplicationList()).forEach(a -> System.out.println(a.toString()));
	}
	

}
