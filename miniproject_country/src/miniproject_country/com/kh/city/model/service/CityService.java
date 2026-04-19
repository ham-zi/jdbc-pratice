package miniproject_country.com.kh.city.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import miniproject_country.com.kh.city.model.dao.CityDao;
import miniproject_country.com.kh.city.model.dto.CityDto;
import miniproject_country.com.kh.common.Template;

public class CityService {
	
	CityDao cd = new CityDao();
	
	public List<CityDto> selectCities() {
		SqlSession session = Template.getSqlSession();
		List<CityDto>cities = cd.selectCities(session);
		session.close();
		return cities;
	}

	public int insertCity(CityDto city) {
		SqlSession session = Template.getSqlSession();
		int result = cd.insertCity(session, city);
		if(result > 0) {
			session.commit();
		}
		session.close();
		return result;
	}
	
	public int updateCity(CityDto city) {
		SqlSession session = Template.getSqlSession();
		int result = cd.updateCity(session, city);
		if(result > 0) {
			session.commit();
		}
		session.close();
		return result;
	}
	
	public int deleteCity(int cityNo) {
		SqlSession session = Template.getSqlSession();
		int result = cd.deleteCity(session, cityNo);
		if(result > 0) {
			session.commit();
		}
		session.close();
		return result;
	}
	
}
