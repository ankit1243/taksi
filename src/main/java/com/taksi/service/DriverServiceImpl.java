package com.taksi.service;

import java.util.Collections;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.taksi.data.DriverDataBean;
import com.taksi.vo.AddDriverRequest;

@Service
public class DriverServiceImpl implements DriverService{
	
	@Autowired
	private DriverDataBean driverDataBean;

	@Override
	public ResponseEntity<Map<String, String>> addDriver(AddDriverRequest addDriverRequest) {
		String phoneNo = addDriverRequest.getPhoneNo();
		addDriverRequest.setDriverId(phoneNo + UUID.randomUUID().toString());
		if(driverDataBean.addDriver(phoneNo, addDriverRequest)) {
			return new ResponseEntity<>(Collections.singletonMap("driverId", addDriverRequest.getDriverId()),HttpStatus.CREATED);
		}
		return new ResponseEntity<>(Collections.singletonMap("error","Driver already exists with phone no:"+ addDriverRequest.getPhoneNo()), HttpStatus.CONFLICT);
	}

}
