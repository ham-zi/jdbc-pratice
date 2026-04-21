package com.kh.delivery.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.kh.delivery.controller.MemberController;
import com.kh.delivery.controller.OrderController;
import com.kh.delivery.dto.DeliMemberDto;
import com.kh.delivery.dto.OrdersDto;
import com.kh.delivery.dto.ReviewDto;
import com.kh.delivery.exception.ExistIdException;
import com.kh.delivery.exception.SoldOutException;

public class DeliveryMenu {
	
	Scanner sc = new Scanner(System.in);
	MemberController mc = new MemberController();
	OrderController oc = new OrderController();
	DeliMemberDto loginMember = null;
	
	public void mainMenu() {
		while(true) {
			System.out.println("=====================");
			System.out.println("KH배달프로그램입니다.");
			System.out.println("1. 전체 가게 목록");
			System.out.println("2. 가게 상세(메뉴보기)");
			System.out.println("3. 카테고리별 검색");
			if(loginMember != null) {
				System.out.println("4. 주문하기"); //
				System.out.println("5. 주문 취소");
				System.out.println("6. 내 주문내역");//
				System.out.println("7. 별점주기");
				System.out.println("8. 로그아웃"); //
			} else {
				System.out.println("4. 로그인"); //
				System.out.println("5. 회원가입"); //
			}
			System.out.println("0. 프로그램 종료"); //
			System.out.println("=====================");
			System.out.print("메뉴번호 선택 >");
			String menuNo = sc.nextLine();
			
			if(loginMember != null) {
				switch(menuNo) {
				case "1" : break;
				case "2" : break;
				case "3" : break;
				case "4" : 
					insertOrder();
					break;
				case "5" :
					deleteOrder();
					break;
				case "6" : 
					selectMyOrders();
					break;
				case "7" : 
					insertReview();
					break;
				case "8" :
					loginMember = null;
					System.out.println("로그아웃하셨습니다.");
					break;
				case "0" : 
					sc.close();
					System.out.println("프로그램 종료");
					return;
				default  : System.out.println("메뉴를 다시 선택해주세요.");
				}
			}
			if(loginMember == null) {
				switch(menuNo) {
				case "1" : break;
				case "2" : break;
				case "3" : break;
				case "4" : 
					login();
					break;
				case "5" : 
					insertMember();
					break;
				case "0" : 
					sc.close();
					System.out.println("프로그램 종료");
					return;
				default  : System.out.println("메뉴를 다시 선택해주세요.");
				}
			}
		}
			
	}
	// 회원
	private void login() {
		System.out.println("KH로그인 서비스입니다.");
		System.out.print("로그인 ID 입력 >");
		String memberId = sc.nextLine();
		System.out.print("로그인 PW 입력 >");
		String memberPw = sc.nextLine();

		DeliMemberDto member = new DeliMemberDto();
		member.setMemberId(memberId);
		member.setMemberPw(memberPw);
		loginMember = mc.loginMember(member);
		if(loginMember != null) {
			System.out.println("로그인 성공");
		} else {
			System.out.println("로그인 실패");
		}
		
	}
	
	private void insertMember() {
		while(true) {
			System.out.println("KH회원가입 서비스입니다.");
			System.out.print("계정 ID 입력 >");
			String memberId = sc.nextLine();
			System.out.print("계정 PW 입력 >");
			String memberPw = sc.nextLine();
			System.out.print("회원 이름 입력 >");
			String memberName = sc.nextLine();
			System.out.print("회원 주소 입력 >");
			String address = sc.nextLine();
			int result = 0;
			try {
			result = mc.insertMember(new DeliMemberDto(memberId,memberPw, memberName,address));
			} catch (ExistIdException e) {
				System.out.println("존재하는 아이디입니다.");
				break;
			}
			if(result > 0) {
				System.out.println("계정 생성 성공");
				return;
			} else {
				System.out.println("계정 생성 실패");
				break;
			}
		}
	}
	// 별점주기
	private void insertReview() {
		int orderNo = 0;
		int reviewStar = 0;
		selectMyOrders();
		System.out.println("별점주기 시스템");
		try {
			System.out.print("별점 평가할 주문 번호 입력 >");
			orderNo = sc.nextInt();
			System.out.print("별점: 1 ~ 5 입력 >");
			reviewStar = sc.nextInt();
			sc.nextLine();
		} catch (InputMismatchException e) {
			System.out.println("숫자를 입력하세요.");
		}
		int result = mc.insertReview(new ReviewDto(orderNo,loginMember.getMemberNo(),reviewStar));
		if(result > 0) {
			System.out.println("리뷰 작성 완료");
		} else {
			System.out.println("리뷰 작성 실패");
		}
	}
	
	
	//주문하기
	private void selectMyOrders() {
		System.out.println("내 주문 내역 확인");
		System.out.println("=====================");
		List<OrdersDto>orders = oc.selectMyOrders(loginMember.getMemberNo());
		if(orders.isEmpty()) {
			System.out.println("주문 내역이 없습니다.");
		} else {
			orders.stream()
			      .map(o -> "[주문번호:" + o.getOrderNo()
			              +", 가게이름:" + o.getRestName()
			              +", 메뉴이름:" + o.getMenuName()
			              +", 주문수량:" + o.getQuantity()
			              +", 주문상태:" + o.getStatus())
			      .forEach(System.out::println);
		}
		System.out.println("=====================");

	}
	
	private void insertOrder() {
		int result = 0;
		System.out.println("주문 시스템");
		try {
			System.out.print("메뉴번호 입력 >");
			int menuNo = sc.nextInt();
			System.out.print("수량 입력 >");
			int quantity = sc.nextInt();
			sc.nextLine();
			result = oc.insertOrder(new OrdersDto(loginMember.getMemberNo(), menuNo, quantity) );
		} catch (InputMismatchException e) {
			System.out.println("숫자를 입력해주세요.");
			return;
		} catch(SoldOutException e) {
			System.out.println("품절 상품입니다.");
			return;
		}
		if(result > 0) {
			System.out.println("주문 성공");
		} else {
			System.out.println("주문 실패");
		}
	}
	
	private void deleteOrder() {
		int result = 0;
		System.out.println("주문 취소 시스템");
		selectMyOrders();
		try {
			System.out.print("취소할 주문 번호 입력 >");
			int orderNo = sc.nextInt();
			sc.nextLine();
			result = oc.deleteOrder(orderNo);
		} catch(InputMismatchException e) {
			System.out.println("숫자를 입력하세요");
			return;
		}
		if(result > 0) {
			System.out.println("주문 취소 성공");
		} else {
			System.out.println("주문 취소 실패");
		}
	}
	
	
	
}


