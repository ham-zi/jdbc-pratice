package com.kh.member.model.service;

import com.kh.exception.LengthOutOfBoundsIdException;
import com.kh.exception.LengthOutOfBoundsPwException;
import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.dto.MemberDto;
import com.kh.template.JdbcTemplate;

import static com.kh.template.JdbcTemplate.*;

import java.sql.Connection;

public class MemberService {
	
	MemberDao md = new MemberDao();
	
	public boolean isMemberId(String id) {
		// DB에서 아이디 있는지 확인
		// 연결은 여기서 관리
		Connection conn = JdbcTemplate.getConnection();
		boolean result = md.isMemberId(conn, id);
		commit(conn);
		close(conn);
		return result;
		
	}

	public int createMember(MemberDto dto) {
		//계정 생성
		if(5>dto.getMemberId().length() ||dto.getMemberId().length()>20) {
			throw new LengthOutOfBoundsIdException();
		}
		if(dto.getMemberPw().length()>20) {
			throw new LengthOutOfBoundsPwException();
		}
		
		int result = 0;
		Connection conn = getConnection();
		result = md.createMember(conn, dto);
		if(result > 0) {
			commit(conn);
		}
		close(conn);
		return result; 
		
	}

	public MemberDto login(MemberDto dto) {
		Connection conn = getConnection();
		MemberDto member = md.login(conn, dto);
		if(member!=null) {
			commit(conn);
		}
		close(conn);
		return member;
	}

}
