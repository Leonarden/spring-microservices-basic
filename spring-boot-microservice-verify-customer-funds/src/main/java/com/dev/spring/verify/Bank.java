package com.dev.spring.verify;
import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Bank {
  
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  
  private String name;
  
  private String address;
  
  private String iban;
  
  private String nis;
  
  
  @OneToMany
  Set<Bank_has_Customer> customers;
  
  private int port;
  
    public int getPort() {
    return port;
  }

  public void setPort(int port) {
    this.port = port;
  }

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getIban() {
	return iban;
}

public void setIban(String iban) {
	this.iban = iban;
}


public String getNis() {
	return nis;
}

public void setNis(String nis) {
	this.nis = nis;
}

public Set<Bank_has_Customer> getCustomers() {
	return customers;
}

public void setCustomers(Set<Bank_has_Customer> customers) {
	this.customers = customers;
}
  
  
  
  
  
}