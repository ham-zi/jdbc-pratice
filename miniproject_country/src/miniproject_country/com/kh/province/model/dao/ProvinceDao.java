package miniproject_country.com.kh.province.model.dao;

import org.apache.ibatis.session.SqlSession;

import miniproject_country.com.kh.province.model.dto.ProvinceDto;

public class ProvinceDao {

	public int createProvince(SqlSession session, ProvinceDto province) {
		return session.insert("provinceMapper", province);
	}
	
}
