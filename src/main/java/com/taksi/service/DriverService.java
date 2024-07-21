package com.taksi.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.taksi.vo.AddDriverRequest;

public interface DriverService {

	public ResponseEntity<Map<String,String>> addDriver(AddDriverRequest addDriverRequest);
}
