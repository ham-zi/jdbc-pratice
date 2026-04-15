package com.kh.species.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kh.species.model.dto.SpeciesDto;




public class SpeciesDao {

	
	static {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/* JDBC용 인터페이스
	 *  - Connection : 데이터베이스와의 세선(연결)을 나타내는 인터페이스
	 *  -> 데이터베이스와의 통신 채널 연결
	 *  -> Statement SQL문을 실행을 위한 Statement객체 생성
	 *  -> 트랜젝션 관리 ( commit )
	 *  -> 현재는 오토커밋이지만 한번에 2~3개의 INSERT가 생기면 오토커밋을 끄고 관리해야한다. 
	 *  
	 *  주의사항 ))
	 *  1. 외부자원이라, GC의 대상이 아님.
	 *  -> 메모리 누수를 방지하기 위해 자원반납을 해야만 함
	 *  
	 *  2.트랜잭션을 직접 관리한다면, DML수행 이후에 반드시 Commit/Rollback을 해야한다.
	 *  
	 *  
	 *  
	 *  - Statement : SQL문을 실행하고 결과를 받아오기 위한 인터페이스
	 *  1. Statement : 정적 SQL문(완성된 SQL문) 실행
	 *  2. PreparedStatement : 파라미터화된 SQL문(미완성 SQL문) 실행
	 *  3. CallableStatement : 저장 프로시저 호출 (예전 DB에서 함수까지 사용할 때 사용함)
	 *  
	 *  
	 *  
	 *  - ResultSet : Select문 실행결과를 담는 테이블 형태의 데이터셋
	 *  -> 커서(cursor)라는 개념을 이용해서 데이터에 접근
	 *  -> 다양한 데이터타입 변환 메소드를 접근
	 *  
	 *  JDBC 처리 순서
	 *  1. JDBC Driver 등록 : DBMS제조사에서 제공하는 클래스를 리플렉션을 통해 등록  
	 *  
	 *  2. Connection 객체를 생성 : 접속정보를 전달하면서 Connection객체 반환
	 *  
	 *  3. Statement 객체를 생성 : Connection 객체를 이용해서 생성
	 *  
	 *  4. SQL문을 전달하면서 실행 : 
	 *  > SELECT -> executeQuery() 호출
	 *  > DML    -> executeUpdate() 호출
	 *  
	 *  5. 결과받기
	 *  > SELECT -> ResultSet(조회된 데이터들이 테이블모양으로 반환)객체로 받기
	 *  > DML    -> int(처리된 행 수)로 받기
	 *  
	 *  6. 결과가공
	 *  > SELECT -> ResultSet에 담겨있는 데이터를 하나하나뽑아서 가공
	 *  > DML    -> 트랜잭션을 수동으로 처리한다면 Commit/Rollback
	 *  
	 *  7. 자원반납 -> close() -> 생성의 역순으로
	 *  8. 결과값 반환
	 *  > SELECT -> 6에서 만든 결과값 반환
	 *  > DML    -> 처리된 행의 수
	 */

	
	public int save(SpeciesDto dto) {
		// 필요한 변수들을 선언하고 Null값으로 초기화
		Connection conn = null;
		Statement stmt = null;
		int result=0;
		
		//SQL문 정적인형태
		/*
		 *INSERT
		 *  INTO
		 *       SPECIES
		 *VLAUES
		 *       (
		 *       'S' || SEQ_SPECIES.NEXTVAL
		 *       ",'" + dto.getSpeciesName() + "'"
		 *       ",'"+dto.getSpciesClass() + "'")
		 *       ")" 
		 */
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO SPECIES VALUES (");
		sb.append("'S' || SEQ_SPECIES.NEXTVAL");
		sb.append(",'" + dto.getSpeciesName() + "'");
		sb.append(",'"+dto.getSpciesClass() + "')");
		String sql = sb.toString();
		
		// SQL에 문법적인 문제가 존재
		// SQLSyntaxErrorException이 발생
		
		try {
			// 1. 패키지 경로/ 클래스식별자에서 오타가 날 경우
			// 2. 프로젝트에 라이브러리를 추가하지 않아서 클래스가 없는 경우
			// -> ClassNotFoundException이 발생
			// 2) Connection 객체생성( URL, USERNMAE, PASSWORD) << 묶어서 데이터소스라고 함
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "C##DS", "DS");
			conn.setAutoCommit(false);
			// 1. URL을 잘못적었을 경우
			// 2. 서버가 안 열려 있을 경우 (방화벽/서버가 안켜짐 등)
			// 3. 계정명 오기
			// 4. 비밀번호 오기
			// 5. 접속 권한을 부여받지 못했을 경우
			// 6. 비밀번호 비갱신 (반년에 한번씩 갱신해야됨)
			
			// 3) Statement 객체 생성
			stmt = conn.createStatement();
			
			// 4,5) SQL문 실행 요청 및 응답 반환
			result = stmt.executeUpdate(sql);
			// INSERT 시 값에 문제가 있을 수 있음
			// 자료형이 맞지 않음
			// 제약조건에 위배
			// 데이터의 크기가 컬럼의 크기보다 큼
			// SQLException 발생
			if(result > 0) {
				conn.commit();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//사용이 끝난 JDBC객체 자원반납
			// 반납은 항상 생성의 역순으로
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		// DML 수행 결과를 반환
		return result;
	}
	
	
	public List<SpeciesDto> findAll() {
		//0) 필요한 변수 선언
		// Connection, Statement
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		List<SpeciesDto>list = new ArrayList<>();
		
		String sql = """
						 SELECT
						        SPECIES_ID AS id
						      , SPECIES_NAME
						      , SPECIES_CLASS
						   FROM
						        SPECIES
						  ORDER
						     BY
						        SPECIES_ID DESC     
					 """;
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "C##DS", "DS");
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			
			// 6) Mapping 한다
			/*서로 다른 형태의 데이터 모델 간의 연결을 정의하는 과정
			 * 관계형 데이터베이스는 어떤 형태로? 테이블 형태 (표 형태)
 			 * 자바는 객체 형태
 			 * 객체 != 테이블 => 페러다임불일치
 			 * => 구조를 맞춰주는 작업
 			 *  테이블 => VO/DTO객체의 필드에 담기
 			 *  rset.next()
 			 *  -> 커서를 한 줄 아래로 옮긴 뒤 존재한다 -> true // 없다 -> false
 			 *  
			 */
			while(rset.next()) {
				//현재 rset의 커서가 가리키고 있는 행의 데이터를 하나씩 뽑아서 dto객체의 필드에 대입
				SpeciesDto sd = new SpeciesDto();
				//ResultSet객체로부터 어떤 컬럼의 값을 뽑을건지 메소드를 호출하면서 컬럼명을 명시
				// rset.getInt(컬럼명) : 컬럼값이 정수여서 int형으로 매핑할때
				// rset.getString(컬럼명) : 문자열값을 STring으로 매핑할때
				// rset.getDate(컬럼명) : 날짜형 값을 java.sql.date로 매핑
				// 컬럼명 : 대소문자를 가리지 않음
				// 컬럼명말고 컬럼의 순번 / 별칭으로 가능함
				// 권장사항 : 컬럼명으로 작성하고 대문자로 작성
				sd.setSpeciesId(rset.getString("SPECIES_NAME"));
				sd.setSpeciesName(rset.getString("SPECIES_CLASS"));
				sd.setSpciesClass(rset.getString("id"));
				//System.out.println(sd);
				// ResultSet의 컬럼명을 적어야한다.!
				// 와 이틀전에 이거로 고민했는데 시원해
				// 컬럼명이 오타났을 때 SQLException이 발생
				// 테이블에 직접접근해서 컬럼값을 뽑느게 아니라
				// ResultSet에서 조회된 결과값을 뽑아내는 것
				list.add(sd);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			try {
				rset.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		// 8) 매핑된 객체들 반환
		// 조회결과물을 매핑해놓은 dTO객체들의 주소값을 요소로 가지고 있는
		// arrayList의 주소값을 반환
		return list;
		
		
	}
	
	public int update(SpeciesDto sd) {
		int result = 0;
		String sql = "UPDATE "
						   + "SPECIES "
				       +"SET "
						  + "SPECIES_NAME = '" + sd.getSpeciesName() + "'"
						  + ", SPECIES_CLASS = '" + sd.getSpciesClass() +"'"
					+" WHERE "
						  + "SPECIES_ID = '" +sd.getSpeciesId() +"'";
		System.out.println(sql);
	
		
		try(Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "C##DS", "DS");
			Statement stmt = conn.createStatement()) {
			result = stmt.executeUpdate(sql);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return result;
		
	}
	
	public int delete(String speciesId) {
		int result = 0;
		String sql = "DELETE "
					  +"FROM "
					       +"SPECIES "
					 +"WHERE "
					       +"SPECIES_iD = '"+speciesId+"'";
		
		try(Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "C##DS", "DS");
			Statement stmt = conn.createStatement()) {
			result = stmt.executeUpdate(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	public SpeciesDto findById(String speciesId) {
		SpeciesDto sd = null;
		
		String sql = """
						SELECT
						       SPECIES_ID
						     , SPECIES_NAME
						     , SPECIES_CLASS
						  FROM
						       SPECIES
						 WHERE
						       SPECIES_ID ='""";
		sql += speciesId;
		sql += "'";
				
		try(Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "C##DS", "DS");
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(sql)) {
			// 6)Mapping
			if(rset.next()) {
				sd = new SpeciesDto(rset.getString("SPECIES_ID"),rset.getString("SPECIES_NAME"), rset.getString("SPECIES_CLASS"));
				return sd;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sd;
		
	}
	
	public List<SpeciesDto> findByKeyword(String keyword) {
		List<SpeciesDto>list = new ArrayList<>();
		
		String sql = """
						SELECT 
							   SPECIES_ID
							 , SPECIES_NAME
							 , SPECIES_CLASS
					      FROM 
					           SPECIES 
					     WHERE 
					           SPECIES_NAME LIKE '%""";
		sql += keyword;
		sql += "%' ORDER BY SPECIES_ID DESC";

		try(Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "C##DS", "DS");
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(sql)) {
			
			while(rset.next()) {
				String sid = rset.getString("SPECIES_ID");
				String sname = rset.getString("SPECIES_NAME");
				String sclass = rset.getString("SPECIES_CLASS");
				list.add(new SpeciesDto(sid, sname, sclass));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	
}
