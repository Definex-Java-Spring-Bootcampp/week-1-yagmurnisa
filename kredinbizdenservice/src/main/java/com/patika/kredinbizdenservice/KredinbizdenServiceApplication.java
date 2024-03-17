package com.patika.kredinbizdenservice;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

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
		Factory factory = Factory.getFactory();
		
		User user1 = factory.createUser("John", "Doe", LocalDate.of(1970, 1, 8), "johndoe@gmail.com", "john123", "533 333 333", true);
		User user2 = factory.createUser("Yağmur", "Şekerci", LocalDate.of(1995, 2, 10), "yagmur@gmail.com", "yagmur123", "533 555 555", true);
		User user3 = factory.createUser("Cem", "Dırman",  LocalDate.of(1990, 5, 15), "cemdrman@gmail.com", "cemdrman123", "533 444 444", true);
	
		users.addAll(Arrays.asList(user1, user2, user3));
		
		Bank qnbBank = factory.createBank("QNB Finansbank");
		Bank akBank = factory.createBank("Akbank");
		Bank ingBank = factory.createBank("ING");
		
		banks.addAll(Arrays.asList(qnbBank, akBank, ingBank));
	
		Loan consumerQnb = factory.createLoan(LoanType.IHTIYAC_KREDISI, qnbBank, new BigDecimal(50000), 3250 , 4.3);
		Loan consumerIng = factory.createLoan(LoanType.IHTIYAC_KREDISI, ingBank, new BigDecimal(20000), 1280, 4.2);
		Loan house = factory.createLoan(LoanType.KONUT_KREDISI, akBank, new BigDecimal(500000), 15000, 2.9);
		
		loans.addAll(Arrays.asList(consumerQnb, consumerIng, house));
		
		Application app1 = factory.createApplication(consumerQnb, user1, LocalDateTime.now());
		Application app2 = factory.createApplication(consumerIng, user1, LocalDateTime.now().minusMonths(2));
		Application app3 = factory.createApplication(consumerIng, user2, LocalDateTime.now());
		Application app4 = factory.createApplication(house, user3, LocalDateTime.now());
	
		apps.addAll(Arrays.asList(app1, app2, app3, app4));
		
		Campaign market = factory.createCampaign("1000 tl market alışverişinde 50 tl chip para ", 
				"1000 tl market alışverişinde 50 tl chip para",LocalDate.of(2024,4,1), LocalDate.of(2024,3,17), LocalDate.of(2024,3,17), SectorType.MARKET);
				
		Campaign travel = factory.createCampaign("10000 tl seyehat harcamalarına 300 tl puan ", 
		"10000 tl seyehat harcamalarına 300 tl puan ",LocalDate.of(2024,4,15), LocalDate.of(2024,3,17), LocalDate.of(2024,3,17), SectorType.TRAVELS);
				
		Campaign other = factory.createCampaign("5000 tl elektronik eşya alışverişinde 2 taksit ", 
		"5000 tl elektronik eşya alışverişinde 2 taksit",LocalDate.of(2024,3,31), LocalDate.of(2024,3,17), LocalDate.of(2024,3,17), SectorType.OTHERS);
				
		campaigns.addAll(Arrays.asList(market,travel,other));
		
		CreditCard akbankCard = factory.createCreditCard(new BigDecimal(1000), akBank, Arrays.asList(market,other));
		CreditCard qnbCard = factory.createCreditCard(new BigDecimal(700), qnbBank, Arrays.asList(market,travel,other));
		CreditCard ingCard = factory.createCreditCard(new BigDecimal(300), ingBank, Arrays.asList(other));
		
		cards.addAll(Arrays.asList(akbankCard, qnbCard, ingCard));
		
		mostAppliedUser();
		highestLoan();
		listLastApplications();
		creditCards();
		listApplicationsByUser("cemdrman@gmail.com");
	
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
	
	public static void highestLoan() { // find the user with highest loan (only one user)
		BigDecimal max=  new BigDecimal(0);
		User highestLoan = null;
		for (Application a: apps) {
			BigDecimal n = a.getLoan().getAmount();
			if (n.compareTo(max)==1) {
				highestLoan = a.getUser();
				max = n;
			}
		}
		System.out.println("User with highest loan: ");
		if (highestLoan != null) {
			System.out.println(highestLoan.toString()+ max);
		}
	}
	
	public static void listLastApplications() { // list the applications of last month
		LocalDateTime time =  LocalDateTime.now().minusMonths(1);
		time = time.minusMonths(1);
		System.out.println("Applications of last month: ");
		for (Application app: apps) {
			if (app.getLocalDateTime().isAfter(time)) {
				System.out.println(app.toString());
			}
		}	
	}
	
	public static void creditCards() {// sort credit cards by their campaign amount
		List<CreditCard> sortedCards = 
		cards.stream().sorted(Comparator.comparingInt(c-> c.getCampaignList().size())).collect(Collectors.toList());	
		for (CreditCard c : sortedCards) {
			System.out.println(c.toString());
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
	}
	

}
