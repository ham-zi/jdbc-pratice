package com.kh.delivery.dao;

import org.apache.ibatis.session.SqlSession;

import com.kh.delivery.dto.DeliMemberDto;
import com.kh.delivery.dto.ReviewDto;

public class MemberDao {
	
	public DeliMemberDto selectMemberById(SqlSession session, String memberId) {
		return session.selectOne("memberMapper.selectMemberById", memberId);
	}

	public DeliMemberDto loginMember(SqlSession session, DeliMemberDto member) {
		return session.selectOne("memberMapper.loginMember", member);
		}
	
	public int insertMember(SqlSession session, DeliMemberDto member) {
		return session.insert("memberMapper.insertMember", member);
	}
	
	public int insertReview(SqlSession session, ReviewDto review) {
		return session.insert("memberMapper.insertReview", review);
	}
	

}
