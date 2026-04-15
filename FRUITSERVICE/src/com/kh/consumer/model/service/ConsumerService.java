package com.kh.consumer.model.service;

import com.kh.consumer.model.dao.ConsumerDao;
import com.kh.consumer.model.dto.ConsumerDto;
import com.kh.exception.LengthOutOfBoundsIdException;
import com.kh.exception.LengthOutOfBoundsPwException;
import com.kh.template.JdbcTemplate;

import static com.kh.template.JdbcTemplate.*;

import java.sql.Connection;

public class ConsumerService {
	
	ConsumerDao cd = new ConsumerDao();
	
	public boolean isConsumerId(String id) {
		// DB에서 아이디 있는지 확인
		// 연결은 여기서 관리
		Connection conn = JdbcTemplate.getConnection();
		boolean result = cd.isConsumerId(conn, id);
		commit(conn);
		close(conn);
		return result;
		
	}

	public int createConsumer(ConsumerDto dto) {
		//계정 생성
		if(5>dto.getConsumerId().length() ||dto.getConsumerId().length()>20) {
			throw new LengthOutOfBoundsIdException();
		}
		if(dto.getConsumerPw().length()>20) {
			throw new LengthOutOfBoundsPwException();
		}
		
		int result = 0;
		Connection conn = getConnection();
		result = cd.createConsumer(conn, dto);
		if(result > 0) {
			commit(conn);
		}
		close(conn);
		return result; 
		
	}

	public ConsumerDto login(ConsumerDto dto) {
		Connection conn = getConnection();
		ConsumerDto consumer = cd.login(conn, dto);
		if(consumer!=null) {
			commit(conn);
		}
		close(conn);
		return consumer;
	}

}
