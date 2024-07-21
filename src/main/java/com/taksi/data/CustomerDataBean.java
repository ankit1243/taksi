package com.taksi.data;
import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.taksi.vo.AddCustomerRequest;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class CustomerDataBean {

	private HashMap<String,AddCustomerRequest> customerMap;
	
	public boolean addCustomer(String phoneNo, AddCustomerRequest addCustomerRequest) {
		if(customerMap.putIfAbsent(phoneNo,addCustomerRequest) == null) return true;
		return false;
	}
}
