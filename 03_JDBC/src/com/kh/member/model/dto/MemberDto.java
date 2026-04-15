package com.kh.member.model.dto;

public class MemberDto {
	private String memberId;
	private String memberpwd;
	private String memberName;
	public MemberDto() {
		super();
	}
	public MemberDto(String memberId, String memberpwd, String memberName) {
		super();
		this.memberId = memberId;
		this.memberpwd = memberpwd;
		this.memberName = memberName;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberpwd() {
		return memberpwd;
	}
	public void setMemberpwd(String memberpwd) {
		this.memberpwd = memberpwd;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	@Override
	public String toString() {
		return "MemberDto [memberId=" + memberId + ", memberpwd=" + memberpwd + ", memberName=" + memberName + "]";
	}
	
	
	
}
