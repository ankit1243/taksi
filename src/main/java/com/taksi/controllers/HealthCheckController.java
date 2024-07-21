package com.taksi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {
	
	@GetMapping(value = "/ping")
	public String healthCheck() {
		return "service is up and running";
	}
}
