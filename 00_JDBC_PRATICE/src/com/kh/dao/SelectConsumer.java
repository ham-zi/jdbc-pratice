package com.kh.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectConsumer {
	
	public void selectConsumer(String url, String user, String password) {
		
		ResultSet rset = null;
		
		String sql = """
				 		SELECT
				 		       CONSUMER_NO
				 		     , CONSUMER_ID
				 		     , CONSUMER_PW
				 		  FROM
				 		       CONSUMER
				 		 ORDER
				 		    BY
				 		       CONSUMER_NO
				 	 """;
		
		try {
			// 리플렉션 -> 실행 도중 클래스를 임포트하는것?
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 연결 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try( Connection conn = DriverManager.getConnection(url, user, password);
			 Statement stmt = conn.createStatement()){
			rset = stmt.executeQuery(sql);
			
			while(rset.next()) {
				String csmNo = rset.getString("CONSUMER_NO");
				String csmId = rset.getString("CONSUMER_ID");
				String csmPw = rset.getString("CONSUMER_PW");
				System.out.println("[소비자번호:"+csmNo+", 소비자ID:"+csmId+", 소비자PW:"+csmPw+"]");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
