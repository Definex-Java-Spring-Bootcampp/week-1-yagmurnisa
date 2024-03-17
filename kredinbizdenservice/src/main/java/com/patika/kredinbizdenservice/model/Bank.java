package com.patika.kredinbizdenservice.model;

import java.util.*;
//added constructors
public class Bank {

    private String name;
    private List<Loan> loanList;
    private List<CreditCard> creditCards;

    public Bank() { 
    	loanList = new ArrayList();
    	creditCards = new ArrayList();
    }
    public Bank(String name) {
    	this.name = name;
    	loanList = new ArrayList();
    	creditCards = new ArrayList();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Loan> getLoanList() {
        return loanList;
    }

    public void setLoanList(List<Loan> loanList) {
        this.loanList = loanList;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", loanList=" + loanList +
                '}';
    }
}
