package com.taksi.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.taksi.vo.Driver;

public interface DriverService {

	public ResponseEntity<Map<String,String>> addDriver(Driver addDriverRequest);
}
