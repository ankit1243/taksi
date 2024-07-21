package com.taksi.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.taksi.service.DriverService;
import com.taksi.vo.AddDriverRequest;

import jakarta.validation.Valid;

@Validated
@RestController
public class DriverController {
	
	@Autowired
	private DriverService driverService;

	@PostMapping(value = "/driver/signup" , produces = "application/json")
	public ResponseEntity<Map<String,String>> addDriver(@Valid @RequestBody AddDriverRequest addDriverRequest) {

		return driverService.addDriver(addDriverRequest);
	}
}
