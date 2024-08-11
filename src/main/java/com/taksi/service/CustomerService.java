package com.taksi.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.taksi.vo.Customer;

public interface CustomerService {

	public ResponseEntity<Map<String, String>> createCustomer(Customer addCustomerRequest);
}
