package com.kh.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.kh.model.dto.OracleDto;
import com.kh.model.dto.ProductDto;

public class OrderInsertDao {

	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public OrderInsertDao(OracleDto oracleDto) {
		this.oracleDto = oracleDto;
	}

	private OracleDto oracleDto;
	
	
	public void insertCheckCard() {
		
		Scanner sc = new Scanner(System.in);
		
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

		
		try(Connection conn = DriverManager.getConnection(oracleDto.getUrl(), oracleDto.getUser(),oracleDto.getPassword());
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
		} finally {
			sc.close();
		}
		
	}
	
	
	public void insertConsumer() {
		
		Scanner sc = new Scanner(System.in);
		
		int updateLows;
		//1단계 오라클 드라이버 연결
		System.out.println("Consumber 계정생성");
		System.out.print("가입할 아이디를 입력 >");
		String csmId = sc.nextLine();
		System.out.print("가입할 비밀번호 입력 >");
		String csmPw = sc.nextLine();
		
		String sql = "";
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO CONSUMER (CONSUMER_ID, CONSUMER_PW) VALUES (");
		sb.append("'"+ csmId + "'");
		sb.append(",'" +csmPw +"')");
		sql = sb.toString();
		
		
		try( Connection conn = DriverManager.getConnection(oracleDto.getUrl(), oracleDto.getUser(),oracleDto.getPassword());
			 Statement stmt = conn.createStatement()){
			conn.setAutoCommit(false);
			updateLows = stmt.executeUpdate(sql);
			
			if(updateLows >0) {
				conn.commit();
				System.out.println("커밋성공");
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			sc.close();
		}
		
	}
	
	
	
	public void insertOrderList() {
		Scanner sc = new Scanner(System.in);
		int updateRows;
		
		System.out.println("상품주문생성");
		System.out.print("주문서번호 >");
		String ono = sc.nextLine();
		System.out.print("상품번호 >");
		String pno = sc.nextLine();

		
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO ORDER_LIST VALUES(");
		sb.append("'"+pno +"'");
		sb.append(",'"+ono+"')");
		String sql = sb.toString();
		

		
		try(Connection conn = DriverManager.getConnection(oracleDto.getUrl(), oracleDto.getUser(),oracleDto.getPassword());
			Statement stmt = conn.createStatement()	){
			conn.setAutoCommit(false);
			updateRows = stmt.executeUpdate(sql);
			if(updateRows > 0) {
				conn.commit();
				System.out.println("생성 성공");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			sc.close();
		}
		
	}
	
	
	public void insertOrders() {
		Scanner sc = new Scanner(System.in);
		System.out.println("주문서 입력");
		System.out.print("체크카드ID >");
		String ccid = sc.nextLine();
		
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO ORDERS (CHECKCARD_ID) VALUES (");
		sb.append("'" + ccid + "')");
		
		String sql = sb.toString();
		int updateRows;
		
		
		try(Connection conn = DriverManager.getConnection(oracleDto.getUrl(), oracleDto.getUser(),oracleDto.getPassword());
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
		} finally {
			sc.close();
		}
		
	}
	
	
	public int insertProduct(ProductDto pdto) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;
		int rset = 0;
		

		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO PRODUCT (FRUIT_NAME,FRUIT_STOCK,PRODUCT_PRICE) VALUES(");
		sb.append("'"+pdto.getFruitName()+"'");
		sb.append(","+pdto.getFruitStock());
		sb.append(","+pdto.getProductPrice()+")");
		String sql = sb.toString();
		
		//1. 오라클 DB 켜기 driver
		try {
			System.out.println("드라이버 연결 성공");


			conn = DriverManager.getConnection(oracleDto.getUrl(), oracleDto.getUser(), oracleDto.getPassword());
			System.out.println("로그인성공");
			stmt = conn.createStatement();
			System.out.println("새편집기 생성 완료");
			conn.setAutoCommit(false);
			rset = stmt.executeUpdate(sql);
			System.out.println("생성성공");
			if(rset > 0 ) {
				conn.commit();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			sc.close();
			try {
				if(stmt != null && !stmt.isClosed()) {
					stmt.close();
				} else {System.out.println("stmt반납실패");}
				if(conn != null && !conn.isClosed()) {
					conn.close();
				} else {System.out.println("conn반납실패");}
				System.out.println("반납완료");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


		return rset;
	}
	
	
	
	
}
