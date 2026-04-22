package miniproject_country.com.kh.province.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import miniproject_country.com.kh.province.model.dto.ProvinceDto;

public class ProvinceDao {

	public List<ProvinceDto> selectProvinces(SqlSession session) {
		return session.selectList("provinceMapper.selectProvinces");
	}
	
	public int insertProvince(SqlSession session, ProvinceDto province) {
		return session.insert("provinceMapper.insertProvince", province);
	}
	
	public int updateProvince(SqlSession session, ProvinceDto province) {
		return session.update("provinceMapper.updateProvince", province);
	}
	
	public int deleteProvince(SqlSession session, int provinceNo) {
		return session.delete("provinceMapper.deleteProvince", provinceNo);
	}

	
}
