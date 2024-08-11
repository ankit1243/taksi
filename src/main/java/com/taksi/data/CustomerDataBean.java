package com.taksi.data;
import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.taksi.vo.Customer;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class CustomerDataBean {

	private HashMap<String,Customer> customerMap;
	
	public boolean addCustomer(String phoneNo, Customer addCustomerRequest) {
		if(customerMap.putIfAbsent(phoneNo,addCustomerRequest) == null) return true;
		return false;
	}
}
