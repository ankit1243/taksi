package com.taksi.service;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.taksi.data.DriverDataBean;
import com.taksi.vo.Driver;

@Service
public class DriverServiceImpl implements DriverService{
	
	@Autowired
	private DriverDataBean driverDataBean;

	@Override
	public ResponseEntity<Map<String, String>> addDriver(Driver addDriverRequest) {
		String phoneNo = addDriverRequest.getPhoneNo();
		addDriverRequest.setDriverId(phoneNo);
		if(driverDataBean.addDriver(phoneNo, addDriverRequest)) {
			return new ResponseEntity<>(Collections.singletonMap("driverId", addDriverRequest.getDriverId()),HttpStatus.CREATED);
		}
		return new ResponseEntity<>(Collections.singletonMap("error","Driver already exists"), HttpStatus.CONFLICT);
	}

}
