package miniproject_country.com.kh.view;

import java.util.Scanner;

import miniproject_country.com.kh.province.controller.ProvinceController;
import miniproject_country.com.kh.province.model.dto.ProvinceDto;

public class CountryView {
		
	private Scanner sc = new Scanner(System.in);
	private ProvinceController pc = new ProvinceController();
	public void mainMenu() {
		while(true) {
	    System.out.println();
		System.out.println("==========================");
		System.out.println("도시 정보공유 서비스 입니다.");
		System.out.println("1 : 도시(city) 전체 조회");
		System.out.println("2 : 도시(city) 상세 조회");
		System.out.println("3 : 키워드 명소 조회");
		System.out.println("4 : 특정 특산물 조회");
		System.out.println("5 : 행정구역'도' 단위 명소 조회");
		System.out.println("6 : 행정구역'도' 단위 특산물 조회");
		System.out.println("7 : 행정구역'도' 정보 관리");
		System.out.println("8 : 행정구역'시' 정보 관리");
		System.out.println("9 : 프로그램 종료");
		System.out.println("==========================");
		System.out.print("메뉴를 선택해주세요 >");
		String menuNum = sc.nextLine();
		
		
		switch(menuNum) {
		case "7": provinceMenu(); break;
		case "8": cityMenu(); break;
		case "9": sc.close(); return;
		default : System.out.println("없는 메뉴입니다.");
		
		}
		
		
		}
	}

	
	private void cityMenu() {
		System.out.println();
		System.out.println("==========================");
		System.out.println("행정구역'시' 정보 관리 시스템");
		System.out.println("1 : 행정구역'시' 추가하기");
		System.out.println("2 : 행정구역'시' 수정하기");
		System.out.println("3 : 행정구역'시' 삭제하기");
		System.out.println("4 : 관리 시스템 종료");
		System.out.println("==========================");
		System.out.print("메뉴를 선택해주세요 >");
		String menuNum = sc.nextLine();
		switch(menuNum) {
		case "1": break;
		case "2": break;
		case "3": break;
		case "4": return;
		default : System.out.println("없는 메뉴입니다.");
		}
	}
	
	
	
	
	
	private void provinceMenu() {
		System.out.println();
		System.out.println("==========================");
		System.out.println("행정구역'도' 정보 관리 시스템");
		System.out.println("1 : 행정구역'도' 추가하기");
		System.out.println("2 : 행정구역'도' 수정하기");
		System.out.println("3 : 행정구역'도' 삭제하기");
		System.out.println("4 : 관리 시스템 종료");
		System.out.println("==========================");
		System.out.print("메뉴를 선택해주세요 >");
		String menuNum = sc.nextLine();
		switch(menuNum) {
		case "1": createProvince(); break;
		case "2": break;
		case "3": break;
		case "4": return;
		default : System.out.println("없는 메뉴입니다.");
		}
		
	}
	
	private void createProvince() {
		System.out.println(" 행정구역'도' 추가");
		System.out.print("행정 구역의 이름 입력 >");
		String provinceName = sc.nextLine();
		System.out.print("행정 구역의 지역번호 입력 >");
		String localNo = sc.nextLine();
		
		int result = pc.createProvince(new ProvinceDto(provinceName, localNo));
		if(result > 0) {
			System.out.println(provinceName + " 추가 성공");
		} else {
			System.out.println("추가 실패");
		}
	}
	
	
	
}
