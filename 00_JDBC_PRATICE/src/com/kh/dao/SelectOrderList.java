package com.kh.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectOrderList {
	
	
	public void selectOrderList(String url, String user, String password) {
		
		ResultSet rset = null;
		String sql = """
						 SELECT
						        ORDER_NO
						      , PRODUCT_NO
						   FROM
						        ORDER_LIST
						  ORDER
						     BY
						        ORDER_NO
			 		 """;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try(Connection conn = DriverManager.getConnection(url, user, password);){
			Statement stmt = conn.createStatement();
			
			rset = stmt.executeQuery(sql);
			
			while(rset.next()) {
				String ono = rset.getString("ORDER_NO");
				String pno = rset.getString("PRODUCT_NO");
				
				System.out.println("[주문서번호 :"+ ono + ", 상품번호:"+pno+"]");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
