package com.dev.spring.verify;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class DBInitializer {
	@Autowired
	CustomerRepository custRepo;
	@Autowired 
	BankRepository bankRepo;
	@Autowired
	Bank_has_CustomerRepository bankCustRepo;
	@Autowired 
	BankCustomer_has_AccountRepository bankCustHasAccRepo;

	private String status;
	
	public DBInitializer() {
	
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public void initialize() {

		try {
			JpaCustomerBankBank_has_Customer();
			this.status = "DBInitialize:OK";
			
		}catch(Exception ex) {
			this.status = "DBInitialize:FAIL";
			ex.printStackTrace();
		}
		
	}
	
	
	


 
   public void JpaCustomerBankBank_has_Customer() throws Exception {
	   
	Customer cust1 = new Customer();
	cust1.setEmail("joe@elgoog.com");
	
	cust1 = custRepo.save(cust1);
	
	Customer cust2 = new Customer();
	cust2.setEmail("daisy@elgoog.com");
   
	cust2 = custRepo.save(cust2);
		
	Bank bank1 = new Bank();
	bank1.setName("BHNC");
	
	bank1 = bankRepo.save(bank1);
	
	Bank bank2 = new Bank();
	bank2.setName("AMEX");
	
	bank2 = bankRepo.save(bank2);
	
	BankCustomerID bc11 = new BankCustomerID(cust1.getId(),bank1.getId());
	
	Bank_has_Customer bhc11 = new Bank_has_Customer();
	bhc11.setId(bc11);
	bhc11.setFiability(5);
	
	bhc11 = bankCustRepo.save(bhc11);
	
	
	BankCustomerID bc21 = new BankCustomerID(cust1.getId(),bank2.getId());

	Bank_has_Customer bhc21 = new Bank_has_Customer();
	bhc21.setId(bc21);
	bhc21.setFiability(10);
	
	bhc21 = bankCustRepo.save(bhc21);

	
	
	BankCustomerID bc12 = new BankCustomerID(cust2.getId(),bank1.getId());

	Bank_has_Customer bhc12 = new Bank_has_Customer();
	bhc12.setId(bc12);
	bhc12.setFiability(0);
	
	bhc12 = bankCustRepo.save(bhc12);

	
	BankCustomer_has_Account bcha111 = new BankCustomer_has_Account();
	bcha111.setAccount("111111111111111");
	bcha111.setAmount(new BigDecimal(100000));
	bcha111.setBank_has_customer(bhc11);
	bcha111.setIsActive(true);
	BankCustomer_has_Account bcha112 = new BankCustomer_has_Account();
	bcha112.setAccount("111111111111122");
	bcha112.setAmount(new BigDecimal(200));
	bcha112.setBank_has_customer(bhc11);
	bcha112.setIsActive(false);
	BankCustomer_has_Account bcha121 = new BankCustomer_has_Account();
	bcha121.setAccount("1111112222222222222");
	bcha121.setAmount(new BigDecimal(50000));
	bcha121.setBank_has_customer(bhc12);
	bcha121.setIsActive(true);
	
	BankCustomer_has_Account bcha211 = new BankCustomer_has_Account();
	bcha211.setAccount("222222211111111");
	bcha211.setAmount(new BigDecimal(50000));
	bcha211.setBank_has_customer(bhc21);
	bcha211.setIsActive(true);
	
	bcha111 = bankCustHasAccRepo.save(bcha111);
	bcha112 = bankCustHasAccRepo.save(bcha112);
	bcha121 = bankCustHasAccRepo.save(bcha121);
	bcha211 = bankCustHasAccRepo.save(bcha211);
	
	
	
	
	
   }

}
