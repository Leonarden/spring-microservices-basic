package com.dev.spring.verify;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Set;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Bank_has_Customer {

	@EmbeddedId
	private BankCustomerID id;
/*	
	@ManyToOne(optional=true,targetEntity=Customer.class)
	private Customer customer;
	@ManyToOne(optional=true,targetEntity=Bank.class)
	private Bank bank;
	*/
	private Date start; 
	
	private Integer fiability;

    @OneToMany(mappedBy="bank_has_customer")
	Set<BankCustomer_has_Account> accounts;
	
	
	
	public BankCustomerID getId() {
		return id;
	}

	public void setId(BankCustomerID id) {
		this.id = id;
	}



	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Integer getFiability() {
		return fiability;
	}

	public void setFiability(Integer fiability) {
		this.fiability = fiability;
	}

	public Set<BankCustomer_has_Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<BankCustomer_has_Account> accounts) {
		this.accounts = accounts;
	}
	
	
	
	
}
