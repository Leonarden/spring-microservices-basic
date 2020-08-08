package com.dev.spring.verify;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Transactional
public class VerifyLendController {
  
  @Autowired
  private Environment environment;
  
  @Autowired
  private CustomerRepository custRepository;
  @Autowired
  private BankRepository bankRepository;
  @Autowired
  private Bank_has_CustomerRepository bank_has_CustomerRepository;
  
  @Autowired
  private BankCustomer_has_AccountRepository bankCust_has_AccountRepository;
  
  @Autowired
  DBInitializer dbInitializer;
  
  @GetMapping("/verify-customer-funds/customer/{customerId}/amount/{amount}")
  public InstantMoneyLoanBean verifyCustomerFunds
    (@PathVariable String customerId, @PathVariable String amount){
	  InstantMoneyLoanBean imoneyLendBean =null;
	  Customer customer = null;
	  BankCustomerID bankCustomerId = null;
	  try {
		  imoneyLendBean = new InstantMoneyLoanBean();
	  
		  customer = custRepository.getOne(Long.parseLong(customerId));
		  imoneyLendBean.setCustomerId(customer.getId());
		  imoneyLendBean = this.checkCustomerFunds(customer,new BigDecimal(amount),imoneyLendBean);
		  
		  
	  imoneyLendBean.setPort(
        Integer.parseInt(environment.getProperty("local.server.port")));
    }catch(Exception ex) {
    	ex.printStackTrace();
    }
    return imoneyLendBean;
  }

  InstantMoneyLoanBean checkCustomerFunds(Customer c, BigDecimal amount, InstantMoneyLoanBean imoneyLendBean) throws Exception {
	  
	  BankCustomerID bankCustomerId = null;
	 Bank_has_Customer bank_has_customer = null;
	  Long custId = c.getId();
	  Long bankId = null;
	  bankCustomerId = new BankCustomerID(custId, bankId);
	  List<Bank> banks = bankRepository.findAll();
	  BigDecimal totalAmount = new BigDecimal(0);
	  boolean reached = false;
	  for(Bank b:banks) {
		  
		  bankId = b.getId();
		  bankCustomerId.setBankId(bankId);
		  bank_has_customer = bank_has_CustomerRepository.getOne(bankCustomerId);
		  if(bank_has_customer!=null) {
			  //We verify customer's banks accounts for that bank
			  Set<BankCustomer_has_Account> bchasAccount = bank_has_customer.getAccounts();
			  for(BankCustomer_has_Account bca: bchasAccount) {
				  if(bca.getAmount()!=null && !bca.getAmount().equals(BigDecimal.ZERO)) {
					  totalAmount = totalAmount.add(bca.getAmount());				  
					  if(totalAmount.compareTo(amount)>=0) {
						  //We consider criteria satisfied
						  imoneyLendBean.setAcceptedOperation(Boolean.TRUE);
						  imoneyLendBean.setAmountRequested(amount);
						  imoneyLendBean.setServicedByBankId(bankId);
						  imoneyLendBean.setReimboursementAccId(bca.getAccount());
						  	
						  reached = true;
						  break;
					  }
				  }
			  }
		  
		  }
		  
		  if(reached)
			  break;
		  
		  
		  
		  
	  }
	  
	  return imoneyLendBean;
	  
  }





}