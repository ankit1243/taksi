package com.taksi.service;

import com.taksi.vo.Order;


public interface OrderService {

	public Order createOrder(Order order);

	public void startRide(String orderId);

	public void completeRide(String orderId);
}
