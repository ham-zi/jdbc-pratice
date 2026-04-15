package com.kh.keeper.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
public class JdbcTemplate {

	/*
	 * JDBC과정에 사용되는 반복적으로 작성해야 하는 코드를
	 * => 메소드로 정의해둘 클래스
	 * 
	 */
	
	//Driver 등록
	public static void registDriver() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static Connection getConnection() {
		
		try{
			Properties prop = new Properties();
			prop.load(new FileInputStream("resources/connection.properties"));

			Connection conn = DriverManager.getConnection(prop.getProperty("URL"),
														  prop.getProperty("USERNAME"),
														  prop.getProperty("PASSWORD"));
			conn.setAutoCommit(false);
			return conn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static void commit(Connection conn) {
		
		try {
			if(conn!=null) {
				conn.commit();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void rollback(Connection conn) {
		
		try {
			if(conn!=null) {
				conn.rollback();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void close(Connection conn) {
		
		try {
			if(conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
}
