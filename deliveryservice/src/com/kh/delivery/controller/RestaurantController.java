package com.kh.delivery.controller;

import java.util.List;

import com.kh.delivery.dto.MenuDto;
import com.kh.delivery.dto.RestaurantDto;
import com.kh.delivery.service.RestaurantService;

public class RestaurantController {
	
	RestaurantService rs = new RestaurantService();

	
	public List<RestaurantDto> selectRestaurants() {
		return rs.selectRestaurants();
	}
	
	public List<MenuDto> selectRestaurant(int restNo) {
		return rs.selectRestaurant(restNo);
	}
	public List<RestaurantDto> selectByCategory(String category){
		return rs.selectByCategory(category);
	}
}
