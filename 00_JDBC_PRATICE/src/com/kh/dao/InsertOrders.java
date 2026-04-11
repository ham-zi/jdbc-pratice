package com.kh.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertOrders {

	Scanner sc;
	
	public InsertOrders(Scanner sc) {
		this.sc = sc;
	}
	
	public void insertOrders(String url, String user, String password) {
		
		System.out.println("주문서 입력");
		System.out.print("체크카드ID >");
		String ccid = sc.nextLine();
		
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO ORDERS (CHECKCARD_ID) VALUES (");
		sb.append("'" + ccid + "')");
		
		String sql = sb.toString();
		int updateRows;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try(Connection conn = DriverManager.getConnection(url, user, password);
			Statement stmt = conn.createStatement()	) {
			conn.setAutoCommit(false);
			updateRows = stmt.executeUpdate(sql);
			if(updateRows>0) {
				conn.commit();
				System.out.println("주문서생성완료");
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
