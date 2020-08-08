package com.dev.spring.verify;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class BankCustomerID implements Serializable {

	private Long bankId;
	private Long customerId;

	public BankCustomerID() {}
	
	public BankCustomerID(Long custId,Long bankId) {
		this.customerId = custId;
		this.bankId = bankId;
	}

	public Long getBankId() {
		return bankId;
	}

	public void setBankId(Long bankId) {
		this.bankId = bankId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	

	
}
