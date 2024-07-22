package com.taksi.service;

import com.taksi.vo.EstimateRequest;
import com.taksi.vo.EstimateResponse;

public interface EstimateService {

	public EstimateResponse getEstimates(EstimateRequest estimateRequest);
}
