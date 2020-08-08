package com.dev.spring.verify;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends 
    JpaRepository<Customer, Long>{
}