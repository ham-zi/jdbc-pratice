package com.kh.delivery.dto;

import java.sql.Date;

public class ReviewDto {

	private int reviewNo;
	private int restNo;
	private int memberNo;
	private int reviewStar;
	
	
	public ReviewDto() {
		super();
	}


	public ReviewDto(int restNo, int memberNo, int reviewStar) {
		super();
		this.restNo = restNo;
		this.memberNo = memberNo;
		this.reviewStar = reviewStar;
	}
	


	public ReviewDto(int reviewNo, int restNo, int memberNo, int reviewStar, Date reviewDate) {
		super();
		this.reviewNo = reviewNo;
		this.restNo = restNo;
		this.memberNo = memberNo;
		this.reviewStar = reviewStar;
	}


	public int getReviewNo() {
		return reviewNo;
	}


	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}


	public int getRestNo() {
		return restNo;
	}


	public void setRestNo(int restNo) {
		this.restNo = restNo;
	}


	public int getMemberNo() {
		return memberNo;
	}


	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}


	public int getReviewStar() {
		return reviewStar;
	}


	public void setReviewStar(int reviewStar) {
		this.reviewStar = reviewStar;
	}



	@Override
	public String toString() {
		return "ReviewDto [reviewNo=" + reviewNo + ", restNo=" + restNo + ", memberNo=" + memberNo + ", reviewStar="
				+ reviewStar + ", reviewDate=" +  "]";
	}


	

	
	
	
}
