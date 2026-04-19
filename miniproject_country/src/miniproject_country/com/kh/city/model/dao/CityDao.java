package miniproject_country.com.kh.city.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import miniproject_country.com.kh.city.model.dto.CityDto;

public class CityDao {
	
	public List<CityDto> selectCities(SqlSession session) {
		return session.selectList("cityMapper.selectCities");
	}
	
	public int insertCity(SqlSession session, CityDto city) {
		return session.insert("cityMapper.insertCity", city);
	}
	
	public int updateCity(SqlSession session, CityDto city) {
		return session.update("cityMapper.updateCity", city);
	}
	
	public int deleteCity(SqlSession session, int cityNo) {
		return session.delete("cityMapper.deleteCity", cityNo);
	}
	

}
