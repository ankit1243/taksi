package com.taksi.data;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.taksi.vo.AddDriverRequest;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class DriverDataBean {
	
	private Map<String,AddDriverRequest> driverMap;

	public boolean addDriver(String phoneNo, AddDriverRequest addDriverRequest) {
		if(null == driverMap.putIfAbsent(phoneNo, addDriverRequest)) return true;
		return false;
	}
}
