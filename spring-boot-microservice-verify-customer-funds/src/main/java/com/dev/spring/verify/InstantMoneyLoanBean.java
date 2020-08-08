package com.dev.spring.verify;

import java.io.Serializable;
import java.math.BigDecimal;

public class InstantMoneyLoanBean implements Serializable {

      private Long customerId;
      private Long servicedByBankId;
      private BigDecimal amountRequested;
      private String reimboursementAccId;
      private Double interestRate;
      private Integer totalMonthsToPayBack;
      private Boolean acceptedOperation;
      private Integer port;
      private String message;
      
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public Long getServicedByBankId() {
		return servicedByBankId;
	}
	public void setServicedByBankId(Long servicedByBankId) {
		this.servicedByBankId = servicedByBankId;
	}
	public BigDecimal getAmountRequested() {
		return amountRequested;
	}
	public void setAmountRequested(BigDecimal amountRequested) {
		this.amountRequested = amountRequested;
	}
	public String getReimboursementAccId() {
		return reimboursementAccId;
	}
	public void setReimboursementAccId(String reimboursementAccId) {
		this.reimboursementAccId = reimboursementAccId;
	}
	public Double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}
	public Integer getTotalMonthsToPayBack() {
		return totalMonthsToPayBack;
	}
	public void setTotalMonthsToPayBack(Integer totalMonthsToPayBack) {
		this.totalMonthsToPayBack = totalMonthsToPayBack;
	}
	public Boolean getAcceptedOperation() {
		return acceptedOperation;
	}
	public void setAcceptedOperation(Boolean acceptedOperation) {
		this.acceptedOperation = acceptedOperation;
	}
	public Integer getPort() {
		return port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
      
      
      
      
      
}
