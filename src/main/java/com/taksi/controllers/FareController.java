package com.taksi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taksi.service.EstimateService;
import com.taksi.vo.EstimateRequest;
import com.taksi.vo.EstimateResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/transport")
@Validated
public class FareController {
	
	@Autowired
	private EstimateService estimateService;

	@PostMapping("/estimate")
	public ResponseEntity<EstimateResponse> getEstimates(@Valid @RequestBody EstimateRequest estimateRequest){
		EstimateResponse resp = estimateService.getEstimates(estimateRequest);
		if(resp!=null) {
			return new ResponseEntity<>(resp,HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
}
