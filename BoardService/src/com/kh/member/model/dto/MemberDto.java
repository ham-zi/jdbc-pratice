package com.kh.member.model.dto;

import java.sql.Date;

public class MemberDto {

	
	private int memberNo;
	private String memberId;
	private String memberPw;
	private Date hireDate;


	public MemberDto(String memberId, String memberPw) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
	}

	public MemberDto(int memberNo, String memberId, String memberPw, Date hireDate) {
		super();
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.hireDate = hireDate;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}


	
}
