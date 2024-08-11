package com.taksi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.taksi.service.OrderService;
import com.taksi.vo.Order;

import jakarta.validation.Valid;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@PostMapping("/createOrder")
	public ResponseEntity<Order> createOrder(@Valid @RequestBody Order order) {
		Order resp = orderService.createOrder(order);
		if (resp != null)
			return ResponseEntity.status(HttpStatus.CREATED).body(resp);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	}

	@PutMapping("/startRide/{orderId}")
	public ResponseEntity<String> startRide(@PathVariable String orderId){
		orderService.startRide(orderId);
		return ResponseEntity.status(201).body("Enjoy your ride");
	}
	
	@PutMapping("/completeRide/{orderId}")
	public ResponseEntity<String> completeRide(@PathVariable String orderId){
		orderService.completeRide(orderId);
		return ResponseEntity.status(HttpStatus.CREATED).body("Thanks for riding with us");
	}
}
