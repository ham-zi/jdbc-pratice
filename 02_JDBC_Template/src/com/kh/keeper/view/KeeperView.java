package com.kh.keeper.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.kh.keeper.controller.KeeperController;
import com.kh.keeper.model.dto.KeeperDto;
import com.kh.keeper.model.vo.Keeper;
import com.kh.member.view.MemberView;

public class KeeperView {
	private Scanner sc = new Scanner(System.in);
	private KeeperController kc = new KeeperController();
	
	public void mainMenu() {
		while(true) {
			System.out.println("사육사 관리 프로그램");
			System.out.println("1 : 사육사 추가하기");
			System.out.println("2 : 사육사 전체조회");
			System.out.println("3 : 사육사 수정하기");
			System.out.println("4 : 사육사 삭제하기");
			System.out.println("5 : 회원 서비스 이동");
			System.out.println("9 : 프로그램 종료");
			System.out.print("메뉴 선택 >");
			String menu = sc.nextLine();
			
			
			switch(menu) {
			case "1" : insertKeeper(); break;
			case "2" : selectKeeperList();break;
			case "3" : updateKeeper();break;
			case "4" : deleteKeeper();break;
			case "5" : new MemberView().mainMenu(); break;
			case "9" : sc.close();return;
			default : System.out.println("존재하지 않는 메뉴입니다.");
			}
			
			
		}
	}
	
	private void insertKeeper() {
		//KEEPER_NAME, ZONE_ID
		System.out.println("사육사 추가기능");
		System.out.print("사육사 이름입력 >");
		String name = sc.nextLine();
		System.out.print("사육사 담당구역 >");
		String zone = sc.nextLine();
		
		int result = kc.insertKeeper(new KeeperDto(name,zone));
		
		if(result > 0) {
			System.out.println("추가 성공");
		}else {
			System.out.println("추가 실패");
		}
	}
	
	private void selectKeeperList() {
		
		System.out.println("사육사 전체 조회 서비스");
		List <Keeper> list = kc.selectKeeperList();
		if(list.isEmpty()) {
			System.out.println("존재하는 사육사가 없습니다.");
		} else {
			list.stream()
				.map(k -> "[ 사육사ID : "+k.keeperId()
						+ ", 사육사이름: "+k.keeperName()
						+ ", 사육사담당구역 : "+k.zoneId()
						+ ", 사육사입사날짜 : "+k.hireDate() +" ]")
				.forEach(System.out::println);
		}
	}
	
	private void updateKeeper() {
		
		//SQL문
		// Update Keeper set 뭘 바꿀건지 -> where 조건을 ?/
		//키퍼네임, 담당구역, 입사일
		//입사일을 수정하지않고 무언가하려면 보통 날짜 두는 컬럼은 2개이상 둔다.
		// 
		System.out.print("정보 변경 사육사의 ID 입력");
		String keeperId = sc.nextLine();
		System.out.print("새로운 이름");
		String keeperName = sc.nextLine();
		System.out.print("새로운 담당구역");
		String zoneId = sc.nextLine();
		System.out.println("새로운 입사일 입력");
		String hireDate = sc.nextLine();
		
		 Map<String,String>keeper = new HashMap<>();
		 keeper.put("keeperId",keeperId);
		 keeper.put("keeperName", keeperName);
		 keeper.put("zoneId", zoneId);
		 keeper.put("hireDate", hireDate);
		 
		 int result = kc.updateKeeper(keeper);
		 
		 if(result>0) {
			 System.out.println("수정 성공");
		 }else {
			 System.out.println("수정 실패");
		 }
		/*
		 * 
		 *  
		 *  Date 
		 *  String 
		 *  localDate
		 *  상속 -> private String date;
		 *  Map<String,String>keeper = new HashMap();
		 *  keeper.put("keeperId",keeperId);
		 *  
		 */
		
	}
	
	private void deleteKeeper() {
		System.out.println("제거할 사육사의 ID >");
		String keeperId = sc.nextLine();
		
		int result = kc.deleteKeeper(keeperId);
		if(result>0) {
			System.out.println("삭제 성공");
		}else {
			System.out.println("삭제 실패");
		}
		
	}
	
}
