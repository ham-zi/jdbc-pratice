package com.kh.consumer.view;

import java.util.Scanner;

import com.kh.board.view.BoardView;
import com.kh.consumer.controller.ConsumerController;
import com.kh.consumer.model.dto.ConsumerDto;
import com.kh.consumer.model.vo.Member;
import com.kh.exception.LengthOutOfBoundsIdException;
import com.kh.exception.LengthOutOfBoundsPwException;

public class ConsumerView {
	
	private Scanner sc;
	private ConsumerController mc = new ConsumerController();
	private ConsumerDto login = null;
	public ConsumerView(Scanner sc) {
		this.sc = sc;
	}

	public void loginMenu() {
		while(true) {
			System.out.println("==================");
			System.out.println("로그인 서비스입니다.");
			if(login != null) {
				System.out.println("1 : 로그아웃");
				System.out.println("2 : 게시판 이동");
			} else {
				System.out.println("1 : 로그인");
				System.out.println("2 : 회원가입");
				System.out.println("3 : 프로그램 종료");
				System.out.println("==================");
			}
				System.out.println();
				System.out.print("메뉴 선택 >");
				String menuNum = sc.nextLine();
			
			if(login != null) {
				switch(menuNum) {
				case "1" : return;
				case "2" : new BoardView(sc, login).boardView();
				default :
					System.out.println("없는 메뉴 번호");
					break;
				}
			}else {
			
				switch(menuNum) {
				case "1" : 
					login();
					break;
				case "2" :
					createConsumer();
					break;
				case "3" :
					return;
				default  :
					break;
				}
			}			
		}
		
	}
	
	private void login() {
		System.out.println("로그인 진행");
		System.out.print("ID 입력 >");
		String id = sc.nextLine();
		System.out.print("PW 입력>");
		String pw = sc.nextLine();
		ConsumerDto result = mc.login(new ConsumerDto(id,pw));
		if(result!=null) {
			System.out.println("로그인 성공");
		} else {
			System.out.println("아이디나 비밀번호가 틀렸습니다.");
		}
		login = result;
		
	}
	
	private void createConsumer() {
		System.out.println("회원가입 진행");
		System.out.print("ID 입력 >");
		String id = sc.nextLine();
		boolean result = mc.isConsumerId(id);
		if(result) {
			System.out.println("이미 존재하는 아이디입니다.");
			return;
		}
		System.out.print("PW 입력 >");
		String pw = sc.nextLine();
		try {
			int create = mc.createConsumer(new ConsumerDto(id,pw));
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
