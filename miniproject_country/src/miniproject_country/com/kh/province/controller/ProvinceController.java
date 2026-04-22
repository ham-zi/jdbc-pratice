package miniproject_country.com.kh.province.controller;

import java.util.List;

import miniproject_country.com.kh.province.model.dto.ProvinceDto;
import miniproject_country.com.kh.province.model.service.ProvinceService;

public class ProvinceController {
	ProvinceService ps = new ProvinceService();
	
	public List<ProvinceDto> selectProvinces(){
		return ps.selectProvinces();
	}
	
	public int insertProvince(ProvinceDto province) {
		return ps.insertProvince(province);
	}
	
	public int updateProvince(ProvinceDto province) {
		return ps.updateProvince(province);
	}
	
	public int deleteProvince(int provinceNo) {
		return ps.deleteProvince(provinceNo);
	}
	
}
