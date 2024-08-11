package com.taksi.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Comparator;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taksi.data.DriverDataBean;
import com.taksi.data.OrderDataBean;
import com.taksi.exception.BusinessException;
import com.taksi.utils.EstimateCalculator;
import com.taksi.utils.OrderStatusEnum;
import com.taksi.vo.Driver;
import com.taksi.vo.Order;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private DriverDataBean driverDataBean;
	
	@Autowired
	private OrderDataBean orderDataBean;
	
	@Autowired
	private EstimateCalculator estimateCalculator;

	@Override
	public Order createOrder(Order order) {
		Driver driver = getNearByAvailableDriver(order.getCurrLat(),order.getCurrLon(),order.getVehicleDetails().getServiceType());
		order.setDriverId(driver.getDriverId());
		order.getVehicleDetails().setVehicleNo(driver.getVehicleNo());

		String orderId = UUID.randomUUID().toString();
		order.setCreatedAt(Timestamp.from(Instant.now()));
		order.setStatus(OrderStatusEnum.DRIVER_ASSIGNED);
		order.setOrderId(orderId);
		if(!orderDataBean.addOrder(order)) {
			throw new BusinessException("Error creating order, please retry!!");
		}
		return order;
	}

	private Driver getNearByAvailableDriver(double currLat, double currLon, String serviceType) {
		Optional<Driver> driverResult = driverDataBean.getAvailableDriversList().stream().map(driverDataBean::getDriverById)
				.filter(driver -> driver!=null && driver.getServiceType().equalsIgnoreCase(serviceType)).min(Comparator.comparingDouble(
						driver -> estimateCalculator.getDistance(driver.getLat(), driver.getLon(), currLat, currLon)));
		if(driverResult.isPresent()) {
			driverDataBean.removeAvailableDriver(driverResult.get().getDriverId());
			return driverResult.get();
		} else {
			throw new BusinessException("Sorry, No driver is available at the moment.");
		}
	}

	@Override
	public void startRide(String orderId) {
		Order order = orderDataBean.getOrderById(orderId);
		if(!order.getStatus().equals(OrderStatusEnum.DRIVER_ASSIGNED))
			throw new BusinessException("Illegal order state, please refresh the app and try again");
		orderDataBean.updateOrderDetails(orderId, true);
	}

	@Override
	public void completeRide(String orderId) {
		Order order = orderDataBean.getOrderById(orderId);
		if(!order.getStatus().equals(OrderStatusEnum.ONGOING))
			throw new BusinessException("Illegal order state, please refresh the app and try again");
		orderDataBean.updateOrderDetails(orderId, false);
		driverDataBean.addAvailableDriver(order.getDriverId());
		Driver driver = driverDataBean.getDriverById(order.getDriverId());
		driver.setLat(order.getDeslat());
		driver.setLon(order.getDesLon());
	}

}
