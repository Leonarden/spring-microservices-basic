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
public class Customer {
  
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  
  private String name;
  
  private String email;
  
  private String nis;
  
  @OneToMany
  Set<Bank_has_Customer> banks;
  
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

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}


public Set<Bank_has_Customer> getBanks() {
	return banks;
}

public void setBanks(Set<Bank_has_Customer> banks) {
	this.banks = banks;
}

public String getNis() {
	return nis;
}

public void setNis(String nis) {
	this.nis = nis;
}



}