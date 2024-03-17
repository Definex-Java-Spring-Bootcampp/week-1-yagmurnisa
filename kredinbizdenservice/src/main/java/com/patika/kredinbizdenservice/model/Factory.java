package com.patika.kredinbizdenservice.model;

import com.patika.kredinbizdenservice.enums.LoanType;
import com.patika.kredinbizdenservice.enums.SectorType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Factory {
	/// singleton pattern
	private static Factory factory; 
	
	private Factory() {
		
	}
	public static Factory getFactory() {
		if (factory==null) {
			factory = new Factory();
		}
		return factory;
	}
	///
	public User createUser(String name, String surname, LocalDate birthDate, String email, String password, String phoneNumber, Boolean isActive) {
		User user = new User(name, surname, birthDate, email, password, phoneNumber, isActive);
		return user;
	}
	
	public Bank createBank(String name) {
		Bank bank = new Bank(name);
		return bank;
	}
	
	public Loan createLoan(LoanType type, Bank bank, BigDecimal amount, int installment, Double interestRate) {
		Loan newloan= null;
		if (type.equals(LoanType.ARAC_KREDISI)) {
			newloan = new VechileLoan(amount,installment,interestRate);
		}
		else if (type.equals(LoanType.KONUT_KREDISI)) {
			newloan = new HouseLoan(amount,installment,interestRate);
		}
		else if (type.equals(LoanType.IHTIYAC_KREDISI)) {
			newloan = new ConsumerLoan(amount,installment,interestRate);
		}
		bank.getLoanList().add(newloan);
		return newloan;
	}
	
	public CreditCard createCreditCard(BigDecimal fee, Bank bank, List<Campaign> list) {
		CreditCard card = new CreditCard(fee, bank, list);	
		bank.getCardList().add(card);
		return card;
	}
	
	public Application createApplication(Loan loan, User user, LocalDateTime time) {
		Application app = new Application(loan, user, time);
		user.getApplicationList().add(app);
		return app;	
	}
	
	public Campaign createCampaign(String title, String content, LocalDate dueDate, LocalDate createDate, LocalDate updateDate, SectorType sector) {
		Campaign camp = new Campaign(title, content, dueDate, createDate, updateDate, sector);
		return camp;
	}
}

