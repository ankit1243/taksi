package com.taksi.vo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Driver {

	@NotBlank
	private String firstName;
	private String lastName;
	@NotBlank
	private String phoneNo;
	
	@NotBlank
	@Email
	private String emailId;
	@NotBlank
	private String password;
	
	private String driverId;
	
	@NotBlank
	private String licenseNo;
	
	@NotBlank
	private String vehicleNo;
	
	private double lat=0;
	private double lon=0;
	
	@NotBlank
	private String serviceType;
	
}
