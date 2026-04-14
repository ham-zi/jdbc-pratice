package com.kh.member.model.vo;

import java.sql.Date;
import java.util.Objects;

public class Member {

	private final int memberNo;
	private final String memberId;
	private final String memberPw;
	private final Date hireDate;
	
	public Member(int memberNo, String memberId, String memberPw, Date hireDate) {
		super();
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.hireDate = hireDate;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public Date getHireDate() {
		return hireDate;
	}

	@Override
	public String toString() {
		return "Member [memberNo=" + memberNo + ", memberId=" + memberId + ", memberPw=" + memberPw + ", hireDate="
				+ hireDate + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(hireDate, memberId, memberNo, memberPw);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		return Objects.equals(hireDate, other.hireDate) && Objects.equals(memberId, other.memberId)
				&& memberNo == other.memberNo && Objects.equals(memberPw, other.memberPw);
	}
	
	


}
