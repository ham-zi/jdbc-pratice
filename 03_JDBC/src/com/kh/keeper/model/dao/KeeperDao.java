package com.kh.keeper.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.kh.keeper.common.JdbcTemplate;
import com.kh.keeper.model.dto.KeeperDto;
import com.kh.keeper.model.vo.Keeper;

public class KeeperDao {
	
	/*
	 * DAO (Data Access Obejct)
	 * 
	 * Database관련된 작업을 전문적으로 담당하는 객체
	 * 
	 * 하나의 메소드는 하나의 SQL문만 실행
	 * DB에 직접 접근해서 SQL문을 실행 후 결과를 받아온다
	 */
	
	/*
	 * JDBC 
	 *  - Connection : DB와 연결정보를 담는 객체
	 *  - Statement : SQL문 실행하고 응답받아오는 객체 
	 *  - ResultSet : SELECT응답결과 담겨있는 객체
	 * 
	 * 
	 *  - PreparedStatement : SQL문을 미리 준비하는 개념
	 *	-> 미완성된 SQL문을 미리 전달하고, 실행하기 전 값을 Binding해서 실행함
	 *	   미완성된 SQL문에 사용자가 입력한 값이 들어갈 수 있도록 공간확보 해놓음
	 *     => ?(위치홀더,placeholder) Statement의 자식클래스 (확장됐다)
	 *    
	 *     Statement와 PreparedStatement는 부모자식 관계
	 *     
	 *     -차이점
	 *     1) Statement는 완성된 SQL문, PreparedStatement는 미완성된 SQL
	 *     2) 객체 생성
	 *     Statement = stmt.createStatement()
	 *     PreparedStatement = stmt.preparedStatement(sql); << 만들때 sql을 보내는게 핵심
	 *     3) SQL문 실행
	 *     Statement == stmt.executeXXX(sql);
	 *     PreparedStatement == pstmt.executeXXX();
	 *     
	 *     ? == placeholder에 실제 값을 binding해준 뒤 실행한다
	 *     pstmt.setString()
	 *     pstmt.setInt()
	 *     
	 */ 
	
	
	
	static {
		JdbcTemplate.registDriver();
	}
	
	public int insertKeeper(Connection conn,KeeperDto kd) {
		
		int result = 0;
		
		String sql = """
						 INSERT 
						   INTO 
						        KEEPER 
						 VALUES 
						        (
						        'K' || SQL_KEEPER.NEXTVAL
						      , ?
						      , SYSDATE
						      , ?
						        )
					 """;

		try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
			//pstmt.setXXX(?의 위치, 실제값)
			pstmt.setString(1, kd.getKeeperName());
			pstmt.setString(2, kd.getZoneId());
			// pstmt.setString(홀더순번, 값)
			// => '값' (양옆에 홑따움표를 감싼 상태로 알아서 bind)
			// pstmt.setInt(홀더순버느, 값)
			// => 값 알아서 (잘 들어감)
			result = pstmt.executeUpdate();
	
		} catch (SQLException e) {
			e.printStackTrace();
		} 

		return result;
		/*
		 * PreparedStatment가 Statement보다 좋음
		 * 1. 구문분석 및 컴파일 최적화
		 * 
		 *  Statement는 매 번 SQL문을 파싱하고 실행하지만
		 *  PreparedStatement는 SQL쿼리를 최초 1회만 파싱하고 실행 계획을 캐싱(메모리에 올림)
		 *  -> 재사용적인 측면에서 매우 효율적
		 * 
		 * 2. DB서버에 대한 트래픽 감소
		 * 쿼리자체는 한 번만 전송하고 이후에는 바인딩할 값만 전송하기 때문에
		 * 동일쿼리를 반복 실행할 때, 높은 트래픽이 몰리는 애플리케이션일 때 더욱 효율적임
		 * DB작업 -> 계획 세울 때 리소스를 많이 잡아 먹음
		 * 
		 * 버그악용 : SQL injection을 피할 수 있음
		 * 
		 */
	}
	
	public List<Keeper> selectKeeperList(Connection conn) {
		List<Keeper> keepers = new ArrayList<>();
		String sql = """
						SELECT 
						       KEEPER_ID
						     , KEEPER_NAME 
						     , HIRE_DATE
						     , NVL(ZONE_ID, '미정') AS ZONE_ID
						  FROM 
						       KEEPER
						 ORDER 
						    BY 
						       KEEPER_ID DESC
					 """;
		
		
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rset = pstmt.executeQuery()) {
			// ResultSet이 왔는데 조회 결과가 있을수도 있고
			// 없을수도 있음
			
			while(rset.next()) {
				Keeper keeper = new Keeper(rset.getString("KEEPER_ID"), rset.getString("KEEPER_NAME"), rset.getDate("HIRE_DATE"),rset.getString("ZONE_ID"));
				keepers.add(keeper);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return keepers;
	}
	

	public int updateKeeper(Connection conn, Map<String,String>Keeper) {
		int result = 0;
		String sql = """
						UPDATE
						       KEEPER
						   SET
						       KEEPER_NAME = ?
						     , HIRE_DATE = ?
						     , ZONE_ID = ?
						WHERE
						       KEEPER_ID = ?
					 """;
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, Keeper.get("keeperName"));
			pstmt.setString(2, Keeper.get("hireDate"));
			pstmt.setString(3, Keeper.get("zoneId"));
			pstmt.setString(4, Keeper.get("keeperId"));
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();			
		}
		return result;
		
	}
	
	public int deleteKeeper(Connection conn, String keeperId) {
		int result = 0;
		
		String sql = """
						DELETE
						  FROM
						       KEEPER
						 WHERE
						       KEEPER_ID = ?
					 """;
		
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql);){
			pstmt.setString(1, keeperId);
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	
}
