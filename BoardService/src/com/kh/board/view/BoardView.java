package com.kh.board.view;

import java.util.Scanner;

import com.kh.board.controller.BoardController;
import com.kh.member.model.dto.MemberDto;

public class BoardView {

	private Scanner sc;
	BoardController bc = new BoardController();
	public BoardView(Scanner sc) {
		this.sc = sc;
	}
	
	public void boardView(MemberDto memberDto) {
		while(true) {
			System.out.println("===================");
			System.out.println("게시판 서비스입니다.");
			System.out.println("1 : 게시판 전체 목록");
			System.out.println("2 : 게시판 목록 검색");
			System.out.println("3 : 게시판 작성");
			System.out.println("4 : 게시판 삭제");
			System.out.println("5 : 프로그램 종료");
			System.out.println("===================");
			
			System.out.println();
			System.out.print("메뉴 선택 >");
			String menuNum = sc.nextLine();
			
			switch(menuNum) {
			case "1" : 
				selectAll();
				break;
			case "2" :
				findBoard();
				break;
			case "3" :
				createBoard();
				break;
			case "4" :
				updateBoard();
				break;
			case "5" :
				System.out.println("프로그램을 종료합니다.");
				sc.close();
				return;
			default  :
				break;
				
			}
		}
	}
	
	
	private void selectAll() {
		
	}
	
	private void findBoard() {
		
	}
	
	private void createBoard() {
		System.out.println("게시글을 작성합니다.");
		System.out.print("제목 : ");
		String title = sc.nextLine();
		System.out.print("내용 : ");
		String content = sc.nextLine();
	}

	private void updateBoard() {
		
	}
}
