package com.kh.delivery.vo;

import java.sql.Date;
import java.util.Objects;

public class DeliMember {

	private final Long memberNo;
	private final String memberId;
	private final String memberPw;
	private final String memberName;
	private final String address;
	private final Date enrollDate;
	
	public DeliMember(Long memberNo, String memberId, String memberPw, String memberName, String address,
			Date enrollDate) {
		super();
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.address = address;
		this.enrollDate = enrollDate;
	}
	
	public Long getMemberNo() {
		return memberNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public String getMemberName() {
		return memberName;
	}
	public String getAddress() {
		return address;
	}
	public Date getEnrollDate() {
		return enrollDate;
	}
	@Override
	public int hashCode() {
		return Objects.hash(address, enrollDate, memberId, memberName, memberNo, memberPw);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DeliMember other = (DeliMember) obj;
		return Objects.equals(address, other.address) && Objects.equals(enrollDate, other.enrollDate)
				&& Objects.equals(memberId, other.memberId) && Objects.equals(memberName, other.memberName)
				&& Objects.equals(memberNo, other.memberNo) && Objects.equals(memberPw, other.memberPw);
	}
	@Override
	public String toString() {
		return "DeliMember [memberNo=" + memberNo + ", memberId=" + memberId + ", memberPw=" + memberPw
				+ ", memberName=" + memberName + ", address=" + address + ", enrollDate=" + enrollDate + "]";
	}
	
	
}
