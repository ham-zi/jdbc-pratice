package com.kh.animal.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.animal.model.dto.AnimalDto;
import com.kh.animal.model.dto.KeeperDto;

public class KeeperDao {

	public List<KeeperDto> selectKeeperAndAnimals(SqlSession session) {
		return session.selectList("keeperMapper.selectKeeperAndAnimals");
	}
	
	public List<AnimalDto> selectAnimalList(SqlSession session, String keeperId) {
		return session.selectList("keeperMapper.selectAnimalList", keeperId);
	}

	
	public List<KeeperDto> findKeeperAndAnimals(SqlSession session) {
		return session.selectList("keeperMapper.findKeeperAndAnimals");
	}
	
	public List<KeeperDto> selectKeeperByCondition(SqlSession session, Map<String,String>arguments){
		//매개변수를 2개 이상 넘기면, 마이바티스에서 알아서 map<key, valeu>를 생성해서 작업을 한다.
		//우리는 직접 넣음.
		// 2개 이상 넣을때는 파라미터타입을 적지 않는다가 원칙.
		return session.selectList("keeperMapper.selectKeeperByCondition", arguments);
	}
}
