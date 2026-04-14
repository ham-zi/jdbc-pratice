package com.kh.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kh.model.dto.OracleDto;
import com.kh.model.dto.ProductDto;

public class OrderSelectDao {

	private OracleDto oracleDto;
	
	public OrderSelectDao(OracleDto oracleDto) {
		this.oracleDto = oracleDto;
	}
	
	static {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	public void selectCheckCard() {
		

		String sql = """
						 SELECT
						        CHECKCARD_ID
						      , BANK
						      , ACCOUNT
						      , CARD_NO
						      , CONSUMER_NO
						   FROM
						        CHECKCARD
						  ORDER
						     BY
						        CHECKCARD_ID
					 """;
		
		
		try (Connection conn = DriverManager.getConnection(oracleDto.getUrl(), oracleDto.getUser(),oracleDto.getPassword());
			 Statement stmt = conn.createStatement();
			 ResultSet rset = stmt.executeQuery(sql);	 ) {
	
			while(rset.next()) {
				String cardId = rset.getString("CHECKCARD_ID");
				String bank = rset.getString("BANK");
				String account = rset.getString("ACCOUNT");
				String cardNo = rset.getString("CARD_NO");
				String csmNo = rset.getString("CONSUMER_NO");
				
				System.out.println("[체크카드ID:"+cardId+", 은행:"+bank+", 잔고:"+account+", 카드번호:"+cardNo +", 소비자번호:"+ csmNo +"]");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	public void selectConsumer() {
		
		
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
		
		
		try( Connection conn = DriverManager.getConnection(oracleDto.getUrl(), oracleDto.getUser(),oracleDto.getPassword());
			 Statement stmt = conn.createStatement();
			 ResultSet rset = stmt.executeQuery(sql)	){

			
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
	
	
	
	public void selectOrderList() {
		
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
		
		
		try(Connection conn = DriverManager.getConnection(oracleDto.getUrl(), oracleDto.getUser(),oracleDto.getPassword());
			Statement stmt = conn.createStatement();
				ResultSet rset = stmt.executeQuery(sql)){
			
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
	
	
	
	public void selectOrders() {
		
		String sql = """
						SELECT
						       ORDER_NO
						     , CHECKCARD_ID
						     , TO_CHAR(ORDER_DATE,'YYYY/MM/DD')
					  	  FROM
					  	       ORDERS
					  	 ORDER
					  	    BY
					  	       ORDER_NO
					 """;

		
		try(Connection conn = DriverManager.getConnection(oracleDto.getUrl(), oracleDto.getUser(),oracleDto.getPassword());
			Statement stmt = conn.createStatement()	;
			ResultSet rset = stmt.executeQuery(sql)	){

			while(rset.next()) {
				String ono = rset.getString("ORDER_NO");
				String ccid = rset.getString("CHECKCARD_ID");
				String date = rset.getString("TO_CHAR(ORDER_DATE,'YYYY/MM/DD')");
				
				System.out.println("[주문번호:"+ono+", 체크카드ID:"+ccid+", 주문날짜:"+date+"]");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public List<ProductDto> selectProduct() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		List<ProductDto> list = new ArrayList<>();
		//오라클 DB 연결
		
		System.out.println("Product를 검색합니다.");
		
		String sql = """
				 		SELECT
				 		       PRODUCT_NO
				 		     , FRUIT_NAME
				 		     , FRUIT_STOCK
				 		     , PRODUCT_PRICE  
				 		  FROM
				 		       PRODUCT
					 """;
		try {
			conn = DriverManager.getConnection(oracleDto.getUrl(), oracleDto.getUser(),oracleDto.getPassword());
			System.out.println("계정연걸 성공");
			stmt = conn.createStatement();
			System.out.println("새편집기 생성");
			rset = stmt.executeQuery(sql);
			while(rset.next()) {
				String pno = rset.getString("PRODUCT_NO");
				String pname = rset.getString("FRUIT_NAME");
				String stock = rset.getString("FRUIT_STOCK");
				String price = rset.getString("PRODUCT_PRICE");
				ProductDto product = new ProductDto(pno,pname,stock,price);
				list.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rset!=null && !rset.isClosed()) {
					try {
						rset.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(stmt!=null && !stmt.isClosed()) {
					try {
						stmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(conn!=null && !conn.isClosed()) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("반납성공");
		}
		
		//자원반납이 필요해지는 객체생성을 try()구문에서 하면 되지 않나?
	
	return list;	
	}
	

	
	
}
