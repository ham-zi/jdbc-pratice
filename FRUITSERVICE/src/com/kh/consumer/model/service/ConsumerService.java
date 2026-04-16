package com.kh.consumer.model.service;

import com.kh.consumer.model.dao.ConsumerDao;
import com.kh.consumer.model.dto.ConsumerDto;
import com.kh.exception.LengthOutOfBoundsIdException;
import com.kh.exception.LengthOutOfBoundsPwException;
import com.kh.template.JdbcTemplate;
import com.kh.template.Template;

import static com.kh.template.JdbcTemplate.*;

import java.sql.Connection;

import org.apache.ibatis.session.SqlSession;

public class ConsumerService {
	
	ConsumerDao cd = new ConsumerDao();
	
	public boolean isConsumerId(String id) {
		// DB에서 아이디 있는지 확인
		// 연결은 여기서 관리
		SqlSession session = Template.getSession(); 
		boolean result = cd.isConsumerId(session, id);
		session.close();
		return result;
		
	}

	public int createConsumer(ConsumerDto dto) {
		//계정 생성
		SqlSession session = Template.getSession();
		int result = cd.createConsumer(session, dto);
		if(result > 0) {
			session.commit();
		}
		session.close();
		return result; 
		
	}

	public ConsumerDto login(ConsumerDto dto) {
		SqlSession session = Template.getSession();
		ConsumerDto consumer = cd.login(session, dto);
		session.close();
		return consumer;
	}

}
