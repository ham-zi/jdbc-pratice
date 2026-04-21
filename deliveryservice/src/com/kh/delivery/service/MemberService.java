package com.kh.delivery.service;

import org.apache.ibatis.session.SqlSession;

import com.kh.delivery.common.Template;
import com.kh.delivery.dao.MemberDao;
import com.kh.delivery.dto.DeliMemberDto;
import com.kh.delivery.dto.ReviewDto;
import com.kh.delivery.exception.ExistIdException;

public class MemberService {

	MemberDao md = new MemberDao();
	
	public DeliMemberDto selectMemberById(String deliMemberId) {
		SqlSession session = Template.getSqlSession();
		DeliMemberDto member = md.selectMemberById(session, deliMemberId);
		session.close();
		return member;
	}

	public DeliMemberDto loginMember(DeliMemberDto member) {
		SqlSession session = Template.getSqlSession();
		DeliMemberDto result = md.loginMember(session, member);
		session.close();
		return result;
	}
	
	public int insertMember(DeliMemberDto member) {
		SqlSession session = Template.getSqlSession();
		int result = 0;
		DeliMemberDto selectMember = null;
		selectMember = selectMemberById(member.getMemberId());
		if(selectMember != null) {
			session.close();
			throw new ExistIdException();	
		} else{
			result = md.insertMember(session, member);
			if(result > 0) {
				session.commit();
			}
		}
		session.close();
		return result;
	}
	
	public int insertReview(ReviewDto review) {
		SqlSession session = Template.getSqlSession();
		int result = md.insertReview(session, review);
		if(result > 0) {
			session.commit();
		}
		session.close();
		return result;
	}
	
	
}
