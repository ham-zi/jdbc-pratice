package com.kh.template;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcTemplate {
	
	public static void resisterDriver() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		
		try {
			
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "C##DS", "DS");
			conn.setAutoCommit(false);
			return conn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void close(Connection conn) {
		
		try {
			if(conn!=null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
	
	

}
