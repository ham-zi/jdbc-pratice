package com.kh.member.model.service;

import java.sql.Connection;

import static com.kh.keeper.common.JdbcTemplate.*;
import com.kh.member.exception.DuplicateMemberIdException;
import com.kh.member.exception.MemberIdToLargeException;
import com.kh.member.exception.MemberPwdToLargeException;
import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.dto.MemberDto;

public class MemberService {

	public boolean idCheck(String memberId) {
		Connection conn = getConnection();
		// JdbcTemplate 쓸 때 마다 귀찮다 그럼?
		// 금단의 비술 ㅋㅋ?
		boolean isCheck = new MemberDao().idCheck(conn, memberId);
		close(conn);
		return isCheck;
	}
	
	public int signUp(MemberDto member) {
		if(member.getMemberId().length()>30) {
			throw new MemberIdToLargeException();
		}
		if(member.getMemberpwd().length()>30) {
			throw new MemberPwdToLargeException();
		}

		
		Connection conn = getConnection();
		MemberDao md = new MemberDao();
		if(md.idCheck(conn, member.getMemberId())) {
			throw new DuplicateMemberIdException("중복아이디입니다.");
		}
		int result = md.signUp(conn, member);
		
		if(result > 0) {
			commit(conn);
		}
		close(conn);
		return result;
	}
}
