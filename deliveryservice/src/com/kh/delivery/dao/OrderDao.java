package com.kh.delivery.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.delivery.dto.MenuDto;
import com.kh.delivery.dto.OrdersDto;

public class OrderDao {
	
	public int insertOrder(SqlSession session, OrdersDto order) {
		return session.insert("ordersMapper.insertOrder", order);
	}
	
	public MenuDto availableMenu(SqlSession session, int menuNo) {
		return session.selectOne("ordersMapper.availableMenus",menuNo);
	}

	public List<OrdersDto> selectMyOrders(SqlSession session, int memberNo){
		return session.selectList("ordersMapper.selectMyOrders", memberNo);
	}
	
	public int deleteOrder(SqlSession session, int orderNo) {
		return session.delete("ordersMapper.deleteOrder", orderNo);
	}
	
	public OrdersDto availableDeleteOrder(SqlSession session, int orderNo) {
		return session.selectOne("ordersMapper.availableDeleteOrder", orderNo);
	}
}
