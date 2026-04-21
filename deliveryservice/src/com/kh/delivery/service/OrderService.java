package com.kh.delivery.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.delivery.common.Template;
import com.kh.delivery.dao.OrderDao;
import com.kh.delivery.dto.MenuDto;
import com.kh.delivery.dto.OrdersDto;
import com.kh.delivery.exception.SoldOutException;

public class OrderService {

	OrderDao od = new OrderDao();
	
	public List<OrdersDto> selectMyOrders(int memberNo){
		SqlSession session = Template.getSqlSession();
		List<OrdersDto> orders = od.selectMyOrders(session, memberNo);
		session.close();
		return orders;
	}
	
	public int insertOrder(OrdersDto order) {
		SqlSession session = Template.getSqlSession();
		int result = 0;
		if(availableMenu(order.getMenuNo())) {
			result = od.insertOrder(session, order);
			if(result > 0) {
				session.commit();
			}
		}
		session.close();
		return result;
	}
	
	private boolean availableMenu(int menuNo) {
		SqlSession session = Template.getSqlSession();
		MenuDto menu = od.availableMenu(session, menuNo);
		if(menu.getSoldOut().equals("N")) {
			session.close();
			throw new SoldOutException();
		} else {
			return true;
		}
	}
	
	public int deleteOrder(int orderNo) {
		SqlSession session = Template.getSqlSession();
		int result=0;
		if(availableDeleteOrder(orderNo)) {
			result = od.deleteOrder(session, orderNo);
			if(result > 0) {
				session.commit();
			}			
		}
		session.close();
		return result;
	}
	
	private boolean availableDeleteOrder(int orderNo) {
		SqlSession session = Template.getSqlSession();
		OrdersDto order = od.availableDeleteOrder(session, orderNo);
		if(order.getStatus().equals("주문접수")) {
			return true;
		}
		return false;
	}
	
}
