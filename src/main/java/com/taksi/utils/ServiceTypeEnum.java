package com.taksi.utils;

public enum ServiceTypeEnum {

	BIKE(10), HATCHBACK(15), SEDAN(18), SUV(20);
	
	private final int charges;
	
	private ServiceTypeEnum(int charges) {
		this.charges = charges;
	}

	public int getCharges() {
		return charges;
	}
}
