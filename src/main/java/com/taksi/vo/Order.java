package com.taksi.vo;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.taksi.utils.OrderStatusEnum;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class Order {

	private String orderId;
	private String driverId;
	private String customerId;
	private double currLat;
	private double currLon;
	private double deslat;
	private double desLon;
	private String price;
	private String paymentId;
	private OrderStatusEnum status;
	private Timestamp pickUpTime;
	private Timestamp dropOffTime;
	private Timestamp createdAt;
	private VehicleDetails vehicleDetails;
	
	@Data
	public class VehicleDetails{
		@NotBlank
		private String serviceType;
		private String vehicleNo;
	}
}
