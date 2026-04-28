package com.kh.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.kh.controller.BoardController;
import com.kh.exception.NotFoundBoardException;
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
		selectAll();
		int boardNo=0;
		System.out.println("게시물 삭제하겠습니다.");
		System.out.print("게시물 번호 입력>");
		try {
			boardNo = sc.nextInt();
			sc.nextLine();
			System.out.println("게시물 비밀번호 입력>");
			String password = sc.nextLine();
			int result = bc.deleteBoard(boardNo, password);
			if(result>0) {
				System.out.println("계정 삭제 성공");
			} else {
				System.out.println("계정 삭제 실패");
			}
		} catch(InputMismatchException e) {
			System.out.println("게시물의 숫자를 입력하세요.");
			return;
		} catch(NotFoundBoardException e) {
			System.out.println("존재하지 않는 게시물번호입니다.");
			return;
		}
	}
	
}
