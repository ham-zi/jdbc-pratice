package com.kh.member.view;

import java.util.Scanner;

import com.kh.member.controller.MemberController;
import com.kh.member.exception.DuplicateMemberIdException;
import com.kh.member.exception.MemberIdToLargeException;
import com.kh.member.exception.MemberPwdToLargeException;
import com.kh.member.model.dto.MemberDto;

public class MemberView {
	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();
	
	public void mainMenu() {
		while(true) {
			System.out.println();
			System.out.println("회원 서비스오신 것을 환영합니다.");
			System.out.println("1 : 회원가입");
			System.out.println("9 : 프로그램 종료");
			
			System.out.print("원하시는 메뉴를 선택");
			String menu = sc.nextLine();
			
			switch(menu) {
			case "1" : signUp(); break;
			case "9" : sc.close(); return;
			}
		}
	}
	
	private void signUp() {
	
		//사용자에게 무슨 값을 받아야하지?
		//아이디, 비밀번호, 이름
		System.out.println("회원가입 서비스입니다.");
		String memberId;
		while(true) {
			System.out.print("사용하실 아이디를 입력 >");
			memberId = sc.nextLine();
			
			if(!mc.idCheck(memberId)) {
				break;
			}
			System.out.println("이미 존재하는 아이디 입니다.");
		}
		System.out.print("사용하실 비밀번호를 입력해주세요>");
		String memberPwd = sc.nextLine();
		System.out.print("사용하실 이름을 입력해주세요?");
		String memberName = sc.nextLine();
		int result;
		try {
			result = mc.signUp(new MemberDto(memberId, memberPwd, memberName));
			
			if(result>0) {
				System.out.println("회원가입 성공");
			} else {
				System.out.println("회원가입 실패");
			}
			
		} catch (MemberIdToLargeException e) {
			System.out.println("아이디를 30자 미만으로 작성해주세요.");
			return;
		} catch (MemberPwdToLargeException e) {
			System.out.println("비밀번호를 30자 미만으로 작성해주세요.");
			return;
		} catch (DuplicateMemberIdException e) {
			System.out.println("이미 존재하는 아이디 입니다.");
			return;
		}
	}
	
	

}
