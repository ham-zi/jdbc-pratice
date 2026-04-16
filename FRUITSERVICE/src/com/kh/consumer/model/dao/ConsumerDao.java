package com.kh.consumer.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.ibatis.session.SqlSession;

import com.kh.consumer.model.dto.ConsumerDto;
import com.kh.template.JdbcTemplate;

public class ConsumerDao {


	
	public boolean isConsumerId(SqlSession session,String id) {
		boolean result = false;
		ConsumerDto consumer = session.selectOne("consumerMapper.isConsumerId", id);
		if(consumer != null) {
			result = true;
		}
		return result;
	}
	
	public int createConsumer(SqlSession session, ConsumerDto dto) {
		return session.insert("consumerMapper.createConsumer", dto);
	}
	
	public ConsumerDto login(SqlSession session, ConsumerDto dto) {
		return session.selectOne("consumerMapper.login", dto);
	}
}
