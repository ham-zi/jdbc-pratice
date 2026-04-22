package com.kh.delivery.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.delivery.common.Template;
import com.kh.delivery.dao.RestaurantDao;
import com.kh.delivery.dto.RestaurantDto;

public class RestaurantService {
	RestaurantDao rd = new RestaurantDao();
	
	public void selectRestaurants() {
		SqlSession session = Template.getSqlSession();
		List<RestaurantDto>avg = rd.selectAvgStar(session);
		List<RestaurantDto>all = rd.selectRestaurants(session);
		
		
	}
}
