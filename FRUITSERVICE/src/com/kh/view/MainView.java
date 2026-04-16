package com.kh.view;

import java.util.Scanner;
import com.kh.consumer.view.ConsumerView;

public class MainView {
	Scanner sc = new Scanner(System.in);

	
	public void mainMenu() {
		
		while(true) {
			System.out.println("과일상품 관리 프로그램");
			System.out.println("1 : 과일 상품 추가하기");
			System.out.println("2 : 과일 상품 전체조회");
			System.out.println("3 : 과일 상품 수정하기");
			System.out.println("4 : 과일 상품 삭제하기");
			System.out.println("5 : 회원 서비스 이동");
			System.out.println("9 : 프로그램 종료");
			System.out.print("메뉴 선택 >");
			String menu = sc.nextLine();
			
			
			switch(menu) {
			case "1" : break;
			case "2" : break;
			case "3" : break;
			case "4" : break;
			case "5" : new ConsumerView(sc).loginMenu(); break;
			case "9" : sc.close();return;
			default : System.out.println("존재하지 않는 메뉴입니다.");
			}
			
			
		}
	}
	
	
	
	
	
}
