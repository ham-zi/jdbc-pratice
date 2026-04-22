package com.kh.delivery.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.delivery.dto.RestaurantDto;

public class RestaurantDao {
	public List<RestaurantDto>selectAvgStar(SqlSession session) {
		return session.selectList("restaurantMapper.selectAvgStar");
	}
	
	public List<RestaurantDto>selectRestaurants(SqlSession session) {
		return session.selectList("restaurantMapper.selectRestaurants");
	}
}
