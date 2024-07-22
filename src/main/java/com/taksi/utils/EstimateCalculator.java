package com.taksi.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.taksi.vo.EstimateRequest.Coordinates;

@Component
public class EstimateCalculator {

	public Map<ServiceTypeEnum,Double> fareCalculator(Coordinates coordinates) {
		try {
			double distance = getDistance(coordinates);
			Map<ServiceTypeEnum,Double> fareMap = new HashMap<>();
			for(ServiceTypeEnum serviceType: ServiceTypeEnum.values()) {
				fareMap.put(serviceType, Math.floor(serviceType.getCharges()*distance * 100) / 100);
			}
			return fareMap;
		} catch(Exception e) {
			return new HashMap<>();
		}
	}

	private double getDistance(Coordinates coordinates) {
		return Math.sqrt(Math.pow(coordinates.getDesLat()-coordinates.getCurrLat(), 2) + Math.pow(coordinates.getDesLon()-coordinates.getCurrLon(), 2));
	}
	
}
