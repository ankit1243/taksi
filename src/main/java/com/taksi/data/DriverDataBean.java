package com.taksi.data;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.taksi.vo.Driver;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class DriverDataBean {
	
	private Map<String,Driver> driverMap;
	
	private List<String> availableDriversList;

	public boolean addDriver(String phoneNo, Driver driver) {
		if(null == driverMap.putIfAbsent(phoneNo, driver)) {
			availableDriversList.add(driver.getDriverId());
			return true;
		}
		return false;
	}

	public List<String> getAvailableDriversList() {
		return availableDriversList;
	}
	
	public void removeAvailableDriver(String driverIdToBeRemoved) {
		availableDriversList.remove(driverIdToBeRemoved);
	}
	
	public void addAvailableDriver(String driverIdToBeAdd) {
		availableDriversList.add(driverIdToBeAdd);
	}
	
	public Driver getDriverById(String driverId) {
		return driverMap.get(driverId);
	}
	
	public Map<String,Driver> getAllDrivers(){
		return driverMap;
	}
}
