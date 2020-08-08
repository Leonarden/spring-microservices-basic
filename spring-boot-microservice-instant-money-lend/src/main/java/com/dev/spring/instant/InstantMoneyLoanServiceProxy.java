package com.dev.spring.instant;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="lend-service")
@RibbonClient(name="lend-service")
public interface InstantMoneyLoanServiceProxy {
  @GetMapping("/verify-customer-funds/customer/{customerId}/amount/{amount}")
  public InstantMoneyLoanBean retrieveLendConditions
    (@PathVariable("customerId") String customerId, @PathVariable("amount") String amount);
}