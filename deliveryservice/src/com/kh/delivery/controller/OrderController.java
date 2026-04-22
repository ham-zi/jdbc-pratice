package com.kh.delivery.controller;

import java.util.List;

import com.kh.delivery.dto.OrdersDto;
import com.kh.delivery.service.OrderService;

public class OrderController {

	OrderService os = new OrderService();
	
	public List<OrdersDto> selectMyOrders(int memberNo) {
		return os.selectMyOrders(memberNo);
	}
	
	public int insertOrder(OrdersDto order) {
		return os.insertOrder(order);
	}
	
	public int deleteOrder(int orderNo) {
		return os.deleteOrder(orderNo);
	}
	
	public OrdersDto selectRestNoByOrder(int orderNo) {
		return os.selectRestNoByOrder(orderNo);
	}
	
}
