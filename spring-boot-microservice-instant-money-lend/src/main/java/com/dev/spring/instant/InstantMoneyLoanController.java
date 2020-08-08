package com.dev.spring.instant;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class InstantMoneyLoanController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private InstantMoneyLoanServiceProxy proxy;

	@GetMapping("/instant-money-loan/customer/{customerId}/amount/{amount}")
	public InstantMoneyLoanBean computeLend(@PathVariable String customerId,
			@PathVariable String amount) {

		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("customerId", customerId);
		uriVariables.put("amount", amount);

		ResponseEntity<InstantMoneyLoanBean> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8005/verify-customer-funds/customer/{customerId}/amount/{amount}", InstantMoneyLoanBean.class,
				uriVariables);

		InstantMoneyLoanBean response = responseEntity.getBody();
        //Taxes an periods
		if(response.getAcceptedOperation().equals(Boolean.TRUE)) {
		 response.setInterestRate(1.2d);
		 response.setTotalMonthsToPayBack(16);
		}
		else {
			response.setMessage("Credit not ACCEPTED");
		}
		return response;
	}

	@GetMapping("/instant-money-loan-feing/customer/{customerId}/amount/{amount}")
	public InstantMoneyLoanBean computeLendFeing(@PathVariable String customerId,
			@PathVariable String amount) {

		InstantMoneyLoanBean response = proxy.retrieveLendConditions(customerId, amount);

	    //Taxes an periods
			if(response.getAcceptedOperation().equals(Boolean.TRUE)) {
			 response.setInterestRate(1.2d);
			 response.setTotalMonthsToPayBack(16);
			}
			else {
				response.setMessage("Credit NOT ACCEPTED");
			}
		
		logger.info("{}", response);

		return response;
	}

}