package com.kh.animal.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.animal.common.Template;
import com.kh.animal.model.dao.AnimalDao;
import com.kh.animal.model.dto.AnimalDto;

public class AnimalService {

	
	public int save(AnimalDto animal) {
		SqlSession session = Template.getSqlSession();
		
		int result = new AnimalDao().save(session, animal);
		
		if(result >0 ) {
			session.commit();
		}
		session.close();
		
		return result;
	}
	
	public List<AnimalDto> findAll(){
		//session을 생성하는 메서드를 호출해서 DAO에 전달
		SqlSession session = Template.getSqlSession();
		
		List<AnimalDto> animals = new AnimalDao().findAll(session);
		session.close();
		return animals;
		
		//필드에 있냐 애니멀로하냐
		//이번에는 필드에 있는게 낫다 Dao가
	}
	
	public AnimalDto findById(String id) {
		SqlSession session = Template.getSqlSession();
		
		AnimalDto animal = new AnimalDao().findById(session,id);
		
		session.close();
		
		return animal;
		
	}
	
	public List<AnimalDto> findByKeyword(String name) {
		SqlSession session = Template.getSqlSession();
		
		List<AnimalDto> animals = new AnimalDao().findByKeyword(session,name);
		
		session.close();
		
		return animals;
		
		
	}
	

}
