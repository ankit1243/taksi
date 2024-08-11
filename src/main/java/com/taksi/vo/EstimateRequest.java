package com.taksi.vo;

import lombok.Getter;

@Getter
public class EstimateRequest {

	private Coordinates coordinates;
	
	@Getter
	public class Coordinates{
		private double currLat;
		private double currLon;
		private double desLat;
		private double desLon;		
	}
}
