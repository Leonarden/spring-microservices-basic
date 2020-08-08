package com.dev.spring.verify;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Pattern;

@Entity
public class BankCustomer_has_Account {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	

	private String account;
	
	@ManyToOne(optional=true,targetEntity=Bank_has_Customer.class)
	private Bank_has_Customer bank_has_customer;
	
	private BigDecimal amount;
	
	private Boolean isActive;

	
	
	
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Bank_has_Customer getBank_has_customer() {
		return bank_has_customer;
	}

	public void setBank_has_customer(Bank_has_Customer bank_has_customer) {
		this.bank_has_customer = bank_has_customer;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
	
	
}
