package miniproject_country.com.kh.province.controller;

import miniproject_country.com.kh.province.model.dto.ProvinceDto;
import miniproject_country.com.kh.province.model.service.ProvinceService;

public class ProvinceController {
	ProvinceService ps = new ProvinceService();
	
	public int createProvince(ProvinceDto province) {
		return ps.createProvince(province);
	}
	
	
}
