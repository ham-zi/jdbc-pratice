package com.kh.view;

import java.util.List;
import java.util.Scanner;

import com.kh.controller.BoardController;
import com.kh.model.dto.BoardDto;

public class BoardView {

	Scanner sc = new Scanner(System.in);
	BoardController bc = new BoardController();
	
	public void boardView() {
		while(true) {
			System.out.println("===================");
			System.out.println("게시판 서비스입니다.");
			System.out.println("1 : 게시판 전체 목록");
			System.out.println("2 : 게시판 목록 검색");
			System.out.println("3 : 게시판 작성");
			System.out.println("4 : 게시판 수정");
			System.out.println("5 : 게시판 삭제");
			System.out.println("6 : 프로그램 종료");
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
				deleteBoard();
				break;
			case "6" :
				System.out.println("프로그램을 종료합니다.");
				sc.close();
				return;
			default  :
				break;
				
			}
		}
	}
	
	private void selectAll() {
		System.out.println("=============");
		List<BoardDto> list = bc.selectAll();
		if(list.isEmpty()) {
			System.out.println("존재하는 게시글이 없습니다.");
		}
		for(BoardDto board : list) {
			System.out.println(board);
		}
	}
	private void findBoard() {
		
	}
	private void createBoard() {
		System.out.println("게시물 작성하겠습니다.");
		System.out.print("제목 >");
		String title = sc.nextLine();
		System.out.print("내용 >");
		String content = sc.nextLine();
		System.out.print("게시물비밀번호 >");
		String password = sc.nextLine();
		
		int result = bc.createBoard(new BoardDto(title,content,password));
		if(result > 0) {
			System.out.println("게시글 작성 성공");
		} else {
			System.out.println("게시글 작성 실패");
		}
	}
	private void updateBoard() {
		
	}
	private void deleteBoard() {
		
	}
	
}
