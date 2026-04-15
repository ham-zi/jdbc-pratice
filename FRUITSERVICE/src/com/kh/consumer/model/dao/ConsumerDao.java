package com.kh.consumer.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.consumer.model.dto.ConsumerDto;
import com.kh.template.JdbcTemplate;

public class ConsumerDao {

	{
		JdbcTemplate.resisterDriver();
	}
	
	private Properties prop = new Properties();
	
	public ConsumerDao() {
		try {
			prop.loadFromXML(new FileInputStream("resources/consumer-mapper.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean isConsumerId(Connection conn,String id) {
		ResultSet rset = null;

		String sql = prop.getProperty("isConsumerId");
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, id);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				return true;
			} else {
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return false;
	}
	
	public int createConsumer(Connection conn, ConsumerDto dto) {
		int result=0;
		String sql = prop.getProperty("createConsumer");
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, dto.getConsumerId());
			pstmt.setString(2, dto.getConsumerPw());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public ConsumerDto login(Connection conn, ConsumerDto dto) {
		ResultSet rset = null;
		ConsumerDto consumer = null;
		String sql = prop.getProperty("login");
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, dto.getConsumerId());
			pstmt.setString(2, dto.getConsumerPw());
			rset = pstmt.executeQuery();
			if(rset.next()) {
				consumer = new ConsumerDto(rset.getInt("Consumer_NO"),rset.getString("Consumer_ID"),rset.getString("Consumer_PW"),rset.getDate("HIREDATE"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return consumer;
	}
}
