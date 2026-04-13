package com.kh.view;

import java.util.Scanner;

import com.kh.controller.OrderInsertController;
import com.kh.controller.OrderSelectController;
import com.kh.model.dto.OracleDto;
import com.kh.model.dto.ProductDto;

public class View {
	Scanner sc = new Scanner(System.in);
	OrderInsertController oic;
	OrderSelectController osc;
	public View (OracleDto oracleDto) {
		this.oic = new OrderInsertController(oracleDto);
		this.osc = new OrderSelectController(oracleDto);
	}
	

	
	public void menu() {


		while(true) {
			System.out.println("===============");
			System.out.println("1 : INSERT");
			System.out.println("2 : SELECT");
			System.out.println("3 : UPDATE");
			System.out.println("4 : DELETE");
			System.out.println("5 : EXIT");
			
			System.out.println("===============");
			System.out.println();
			System.out.print("메뉴 입력 >");
			String menuNum = sc.nextLine();
			
			switch(menuNum) {
			case "1" : insert();break;
			case "2" : ;break;
			case "3" : ;break;
			case "4" : ;break;
			case "5" : return;
			default : System.out.println("잘못입력");break;
			}
		
		}
	}

	
	private void insert() {
		while(true) {
			System.out.println("추가기능 선택");
			System.out.println("1 : 상품");
			System.out.println("2 : 구매자");
			System.out.println("3 : 체크카드");
			System.out.println("4 : 주문서");
			System.out.println("5 : 상품주문");
			System.out.println("6 : 프로그램 종료");
			
			System.out.print("선택>");
			String num = sc.nextLine();
			
			switch(num) {
			case "1" : insertProduct();break;
			case "2" : break;
			case "3" : break;
			case "4" : break;
			case "5" : break;
			case "6" : break;
			default : return;
			}
		}
	}
	
	private void insertProduct() {
		System.out.println("상품에 대한 정보 입력");
		System.out.print("과일이름>");
		String pname = sc.nextLine();
		System.out.print("과일개수>");
		int stock = sc.nextInt();
		System.out.print("상품가격>");
		int price = sc.nextInt();
		sc.nextLine();
		
		ProductDto pdto = new ProductDto(pname,stock,price);
		int result = oic.insertProduct(pdto);
		
		if(result>0) {
			System.out.println("등록 성공");
		} else {
			System.out.println("등록 실패");
		}
		
	}
	
	

}
