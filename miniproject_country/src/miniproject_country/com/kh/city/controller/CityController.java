package miniproject_country.com.kh.city.controller;

import java.util.List;

import miniproject_country.com.kh.city.model.dto.CityDto;
import miniproject_country.com.kh.city.model.service.CityService;

public class CityController {
	
	CityService cs = new CityService();
	
	public List<CityDto> selectCities() {
		return cs.selectCities();
	}
	
	public int insertCity(CityDto city) {
		return cs.insertCity(city);
	}
	
	public int updateCity(CityDto city) {
		return cs.updateCity(city);
	}
	
	public int deleteCity(int cityNo) {
		return cs.deleteCity(cityNo);
	}

}
