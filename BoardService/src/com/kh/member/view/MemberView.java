package com.kh.member.view;

import java.util.Scanner;

import com.kh.exception.LengthOutOfBoundsIdException;
import com.kh.exception.LengthOutOfBoundsPwException;
import com.kh.member.controller.MemberController;
import com.kh.member.model.dto.MemberDto;
import com.kh.member.model.vo.Member;

public class MemberView {
	
	private Scanner sc;
	private MemberController mc = new MemberController();
	public MemberView(Scanner sc) {
		this.sc = sc;
	}

	public MemberDto loginMenu() {
		while(true) {
			System.out.println("==================");
			System.out.println("로그인 서비스입니다.");
			System.out.println("1 : 로그인");
			System.out.println("2 : 회원가입");
			System.out.println("3 : 프로그램 종료");
			System.out.println("==================");
			
			System.out.println();
			System.out.print("메뉴 선택 >");
			String menuNum = sc.nextLine();
		
			switch(menuNum) {
			case "1" : 
				MemberDto login = login();
				if(login!=null) {
					return login;
				} else {
					break;
				}
			case "2" :
				createMember();
				break;
			case "3" :
				return null;
			default  :
				break;
			}
		}
		
	}
	
	private MemberDto login() {
		System.out.println("로그인 진행");
		System.out.print("ID 입력 >");
		String id = sc.nextLine();
		System.out.print("PW 입력>");
		String pw = sc.nextLine();
		MemberDto result = mc.login(new MemberDto(id,pw));
		if(result!=null) {
			System.out.println("로그인 성공");
		} else {
			System.out.println("아이디나 비밀번호가 틀렸습니다.");
		}
		return result;
		
	}
	
	private void createMember() {
		System.out.println("회원가입 진행");
		System.out.print("ID 입력 >");
		String id = sc.nextLine();
		boolean result = mc.isMemberId(id);
		if(result) {
			System.out.println("이미 존재하는 아이디입니다.");
			return;
		}
		System.out.print("PW 입력 >");
		String pw = sc.nextLine();
		try {
			int create = mc.createMember(new MemberDto(id,pw));
			if(create >0) {
				System.out.println("계정 생성 성공");
			} else {
				System.out.println("계정 생성 실패");
			}
		} catch (LengthOutOfBoundsIdException e) {
			System.out.println("아이디는 5글자 이상, 20글자 미만이어야 합니다.");
		} catch (LengthOutOfBoundsPwException e) {
			System.out.println("비밀번호는 20글자 미만 이어야 합니다.");
		}
		
	}

	
}
