package com.kh.member.controller;

import com.kh.member.model.dto.MemberDto;
import com.kh.member.model.service.MemberService;

public class MemberController {

	MemberService ms = new MemberService();
	
	
	public boolean isMemberId(String id) {
		return ms.isMemberId(id);
	}
	
	public int createMember(MemberDto dto) {
		return ms.createMember(dto);
	}
	
	public MemberDto login(MemberDto dto) {
		return ms.login(dto);
	}


}
