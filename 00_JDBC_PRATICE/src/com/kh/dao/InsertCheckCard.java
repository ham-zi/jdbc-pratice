package com.kh.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertCheckCard {
	
	private Scanner sc;
	public InsertCheckCard(Scanner sc) {
		this.sc = sc;
	}

	
	public void insertCheckCard(String url, String user, String password) {
		
		System.out.println("체크카드 등록");
		System.out.print("은행 >");
		String bank = sc.nextLine();
		System.out.print("잔고 > ");
		long account = sc.nextLong();
		sc.nextLine();
		System.out.println("카드번호");
		String cardNo = sc.nextLine();
		System.out.println("소비자번호");
		int csmNo = sc.nextInt();
		sc.nextLine();
		

		String sql ="";
		int updateRows;
		
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO CHECKCARD (BANK, ACCOUNT, CARD_NO, CONSUMER_NO) VALUES (");
		sb.append("'"+bank+"'");
		sb.append(","+account);
		sb.append(",'"+cardNo+"'");
		sb.append(","+csmNo+")");

		sql = sb.toString();

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
			if(updateRows > 0) {
				conn.commit();
				System.out.println("카드등록 성공");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
