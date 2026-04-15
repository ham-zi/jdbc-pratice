package com.kh.keeper.model.service;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.kh.keeper.common.JdbcTemplate;
import com.kh.keeper.model.dao.KeeperDao;
import com.kh.keeper.model.dto.KeeperDto;
import com.kh.keeper.model.vo.Keeper;

public class KeeperService {
	/*
	 * 비지니스 로직 작성 (의사결정코드) : 중복체크, 데이터 가공, 연산처리, 암호화 등등
	 * 트랜잭션관리
	 * 여러 DAO 조합
	 * 예외 처리 및 예외 발생
	 * 보안 및 권한 검사
	 * 
	 * 
	 */
	
	/*
	 * Service : Connection을 생성해서 DAO로 전달 + SQL문을 수행하는데 필요한 값이 있따면,
	 * 			 Controller로 부터 전달받아서 Connection과 함께 넘길 것
	 * 			+DAO에서 DB작업이 끝나면 Service단에서 결과에 따른 트랜잭션 처리도 진행
	 * 
	 * 			=> DAO에는 순수하게 SQL문을 처리하는 부분만 남겨놓을 것
	 * 
	 * 
	 * 
	 */
	
	
	public int insertKeeper(KeeperDto kd) {
		Connection conn = JdbcTemplate.getConnection();

		int result = new KeeperDao().insertKeeper(conn,kd);
		
		if(result > 0) {
			JdbcTemplate.commit(conn);
		}
		
		JdbcTemplate.close(conn);
		return result;
	}
	
	public List<Keeper> selectKeeperList() {
		// 1. 커넥션 객체 받아오기
		Connection conn = JdbcTemplate.getConnection();
		
		// 2. 적절한 DAO단의 메서드 호출하기
		List<Keeper> keepers = new KeeperDao().selectKeeperList(conn);
		
		//3. 자원반납
		JdbcTemplate.close(conn);
		//4. 결과반환
		return keepers;
	}
	
	public int updateKeeper(Map<String,String>keeper) {
		
		Connection conn = JdbcTemplate.getConnection();
		int result = new KeeperDao().updateKeeper(conn, keeper);
		
		if(result > 0) {
			JdbcTemplate.commit(conn);
		}
		JdbcTemplate.close(conn);
		
		return result;
	}
	
	public int deleteKeeper(String keeperId) {
		
		Connection conn = JdbcTemplate.getConnection();
		int result = new KeeperDao().deleteKeeper(conn, keeperId);
		
		if(result > 0) {
			JdbcTemplate.commit(conn);
		}
		
		JdbcTemplate.close(conn);
		
		return result;
	}
	// 회원 C회원가입 R로그인 로그아웃
	// 게시글 작성 조건 : 로그인 5회 이상
	// 게시판 C게시글작성 R목록조회 U상세조회 D
	
}
