package com.kh.delivery.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.delivery.common.Template;
import com.kh.delivery.dao.RestaurantDao;
import com.kh.delivery.dto.MenuDto;
import com.kh.delivery.dto.RestaurantDto;

public class RestaurantService {
	RestaurantDao rd = new RestaurantDao();
	
	public List<RestaurantDto> selectRestaurants() {
		SqlSession session = Template.getSqlSession();
		List<RestaurantDto>avg = rd.selectAvgStar(session);
		List<RestaurantDto>all = rd.selectRestaurants(session);
		if(all.isEmpty()) {
			return null;
		}
		if(avg.isEmpty()) {
			return all;
		}
		for(RestaurantDto rset : all) {
			for(RestaurantDto avgStar : avg) {
				if(rset.getRestNo() == avgStar.getRestNo() ) {
					rset.setAvgStar( avgStar.getAvgStar() );
				}
			}
		}
		return all;
	}
	public List<MenuDto> selectRestaurant(int restNo) {
		SqlSession session = Template.getSqlSession();
		List<MenuDto>menus = rd.selectRestaurant(session, restNo);
		session.close();
		return menus;
	}
	
	public List<RestaurantDto> selectByCategory(String category) {
		SqlSession session = Template.getSqlSession();
		List<RestaurantDto> restaurants = rd.selectByCategory(session, category);
		session.close();
		return restaurants;
	}
}
