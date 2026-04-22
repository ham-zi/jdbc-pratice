package com.kh.delivery.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.delivery.dto.MenuDto;
import com.kh.delivery.dto.RestaurantDto;

public class RestaurantDao {
	public List<RestaurantDto>selectAvgStar(SqlSession session) {
		return session.selectList("restaurantMapper.selectAvgStar");
	}
	
	public List<RestaurantDto>selectRestaurants(SqlSession session) {
		return session.selectList("restaurantMapper.selectRestaurants");
	}
	
	public List<MenuDto>selectRestaurant(SqlSession session, int restNo) {
		return session.selectList("restaurantMapper.selectRestaurant", restNo);
	}
	
	public List<RestaurantDto>selectByCategory(SqlSession session, String category) {
		return session.selectList("restaurantMapper.selectByCategory", category);
	}
}
