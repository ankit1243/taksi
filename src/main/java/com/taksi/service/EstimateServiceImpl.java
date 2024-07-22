package com.taksi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taksi.utils.EstimateCalculator;
import com.taksi.vo.EstimateRequest;
import com.taksi.vo.EstimateResponse;

@Service
public class EstimateServiceImpl implements EstimateService{
	
	@Autowired
	private EstimateCalculator estimateCalculatorUtils;

	@Override
	public EstimateResponse getEstimates(EstimateRequest estimateRequest) {
		try {
			EstimateResponse estimateResponse = new EstimateResponse();
			estimateResponse.setEstimatedFares(estimateCalculatorUtils.fareCalculator(estimateRequest.getCoordinates()));
			return estimateResponse;
		} catch( Exception e) {
			return null;
		}
	}

}
