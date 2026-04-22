package miniproject_country.com.kh.province.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import miniproject_country.com.kh.common.Template;
import miniproject_country.com.kh.province.model.dao.ProvinceDao;
import miniproject_country.com.kh.province.model.dto.ProvinceDto;

public class ProvinceService {
	
	ProvinceDao pd = new ProvinceDao();

	public List<ProvinceDto> selectProvinces() {
		SqlSession session = Template.getSqlSession();
		List<ProvinceDto> list = pd.selectProvinces(session);
		session.close();
		return list;
	}
	
	public int insertProvince(ProvinceDto province) {
		SqlSession session = Template.getSqlSession();
		int result = pd.insertProvince(session, province);
		if(result > 0) {
			session.commit();
		}
		session.close();
		return result;
	}
	
	public int updateProvince(ProvinceDto province) {
		SqlSession session = Template.getSqlSession();
		int result = pd.updateProvince(session, province);
		if(result > 0) {
			session.commit();
		}
		session.close();
		return result;
	}
	
	public int deleteProvince(int provinceNo) {
		SqlSession session = Template.getSqlSession();
		int result = pd.deleteProvince(session, provinceNo);
		if(result > 0) {
			session.commit();
		}
		session.close();
		return result;
	}
}
