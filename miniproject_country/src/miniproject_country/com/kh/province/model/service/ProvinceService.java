package miniproject_country.com.kh.province.model.service;

import org.apache.ibatis.session.SqlSession;

import miniproject_country.com.kh.common.Template;
import miniproject_country.com.kh.province.model.dao.ProvinceDao;
import miniproject_country.com.kh.province.model.dto.ProvinceDto;

public class ProvinceService {
	
	ProvinceDao pd = new ProvinceDao();

	
	public int createProvince(ProvinceDto province) {
		SqlSession session = Template.getSqlSession();
		int result = pd.createProvince(session, province);
		if(result > 0) {
			session.commit();
		}
		session.close();
		return result;
	}
}
