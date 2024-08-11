package com.taksi.data;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.taksi.exception.BusinessException;
import com.taksi.utils.OrderStatusEnum;
import com.taksi.vo.Order;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class OrderDataBean {
	
	private Map<String,Order> orderMap;

	public boolean addOrder(Order order) {
		if(orderMap.putIfAbsent(order.getOrderId(), order) == null) return true;
		return false;
	}
	
	public Order updateOrderDetails(String orderId, boolean isPickUp) {
		if(orderMap.containsKey(orderId)) {
			Order order = orderMap.get(orderId);
			Timestamp currTimestamp = Timestamp.from(Instant.now());
			if(isPickUp) {
				order.setStatus(OrderStatusEnum.ONGOING);
				order.setPickUpTime(currTimestamp);
			} else {
				order.setStatus(OrderStatusEnum.COMPLETED);
				order.setDropOffTime(currTimestamp);
			}
			return order;
		} else {
			throw new BusinessException("No Order Found");
		}
	}
	
	public Order getOrderById(String orderId) {
		return orderMap.get(orderId);
	}
}
