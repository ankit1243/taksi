package com.taksi.vo;

import com.taksi.utils.ServiceTypeEnum;

import lombok.Data;

import java.util.*;

@Data
public class EstimateResponse {

	public Map<ServiceTypeEnum,Double> estimatedFares;
	
}
