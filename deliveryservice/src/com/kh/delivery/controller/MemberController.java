package com.kh.delivery.controller;

import com.kh.delivery.dto.DeliMemberDto;
import com.kh.delivery.dto.ReviewDto;
import com.kh.delivery.service.MemberService;

public class MemberController {

	MemberService ms = new MemberService();
	
	public int insertMember(DeliMemberDto member) {
		return ms.insertMember(member);
	}
	
	public DeliMemberDto loginMember(DeliMemberDto member) {
		return ms.loginMember(member);
	}
	
	public int insertReview(ReviewDto review) {
		System.out.println(review.getMemberNo());
		System.out.println(review.getOrderNo());
		System.out.println(review.getReviewStar());
		return ms.insertReview(review);
	}
	
}
