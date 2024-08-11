package com.taksi.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.taksi.vo.EstimateRequest.Coordinates;

@Component
public class EstimateCalculator {

	public Map<ServiceTypeEnum,Double> fareCalculator(Coordinates coordinates) {
		try {
			double distance = getDistance(coordinates.getDesLat(),coordinates.getDesLon(),coordinates.getCurrLat(),coordinates.getCurrLon());
			Map<ServiceTypeEnum,Double> fareMap = new HashMap<>();
			for(ServiceTypeEnum serviceType: ServiceTypeEnum.values()) {
				fareMap.put(serviceType, Math.floor(serviceType.getCharges()*distance * 100) / 100);
			}
			return fareMap;
		} catch(Exception e) {
			return new HashMap<>();
		}
	}

	public double getDistance(double desLat, double desLon, double currLat, double currLon) {
		return Math.sqrt(Math.pow(desLat-currLat, 2) + Math.pow(desLon-currLon, 2));
	}
	
}
