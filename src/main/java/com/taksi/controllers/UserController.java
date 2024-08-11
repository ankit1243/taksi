package com.taksi.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.taksi.service.CustomerService;

import com.taksi.vo.Customer;

import jakarta.validation.Valid;

@RestController
@Validated
public class UserController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/customer/signup")
	public ResponseEntity<Map<String,String>> addCustomer(@Valid @RequestBody Customer addCustomerRequest) {
		return customerService.createCustomer(addCustomerRequest);
	}
}
