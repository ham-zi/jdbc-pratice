package com.kh.delivery.dto;

import java.sql.Date;

public class ReviewDto {

	private int reviewNo;
	private int orderNo;
	private int memberNo;
	private int reviewStar;
	
	
	public ReviewDto() {
		super();
	}


	public ReviewDto(int orderNo, int memberNo, int reviewStar) {
		super();
		this.orderNo = orderNo;
		this.memberNo = memberNo;
		this.reviewStar = reviewStar;
	}
	


	public ReviewDto(int reviewNo, int orderNo, int memberNo, int reviewStar, Date reviewDate) {
		super();
		this.reviewNo = reviewNo;
		this.orderNo = orderNo;
		this.memberNo = memberNo;
		this.reviewStar = reviewStar;
	}


	public int getReviewNo() {
		return reviewNo;
	}


	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}


	public int getOrderNo() {
		return orderNo;
	}


	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
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
		return "ReviewDto [reviewNo=" + reviewNo + ", orderNo=" + orderNo + ", memberNo=" + memberNo + ", reviewStar="
				+ reviewStar + ", reviewDate=" +  "]";
	}


	

	
	
	
}
