package com.taksi.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.taksi.vo.AddCustomerRequest;

public interface CustomerService {

	public ResponseEntity<Map<String, String>> createCustomer(AddCustomerRequest addCustomerRequest);
}
