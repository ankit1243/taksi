package com.taksi.service;

import java.util.Collections;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.taksi.data.CustomerDataBean;
import com.taksi.vo.AddCustomerRequest;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDataBean customerDB;

	@Override
	public ResponseEntity<Map<String,String>> createCustomer(AddCustomerRequest addCustomerRequest) {
		 //need to add validations for phone number
		addCustomerRequest.setCustomerId(addCustomerRequest.getPhoneNo()+UUID.randomUUID().toString());
		if(customerDB.addCustomer(addCustomerRequest.getPhoneNo(), addCustomerRequest)) {
			return new ResponseEntity<>(Collections.singletonMap("customerId", addCustomerRequest.getCustomerId()),HttpStatus.CREATED);
		}
		return new ResponseEntity<>(Collections.singletonMap("error","Customer already exists"), HttpStatus.CONFLICT);
	}

}
