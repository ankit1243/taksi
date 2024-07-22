package com.taksi.vo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddDriverRequest {

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
	private String serviceType;
	
}
