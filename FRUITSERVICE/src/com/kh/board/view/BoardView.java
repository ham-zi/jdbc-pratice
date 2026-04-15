package com.kh.board.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.kh.board.controller.BoardController;
import com.kh.board.model.dto.BoardDto;
import com.kh.board.model.dto.BoardTitleDto;
import com.kh.consumer.model.dto.ConsumerDto;

public class BoardView {

	private Scanner sc;
	private ConsumerDto consumer;
	BoardController bc = new BoardController();
	public BoardView(Scanner sc, ConsumerDto consumer) {
		this.sc = sc;
		this.consumer = consumer;
	}
	
	public void boardView() {
		while(true) {
			System.out.println("===================");
			System.out.println("게시판 서비스입니다.");
			System.out.println("1 : 게시판 전체 목록");
			System.out.println("2 : 게시판 상세 조회");
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
				selectBoards();
				break;
			case "2" :
				selectBoard();
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
			default  :
				break;
				
			}
		}
	}
	
	
	private void selectBoards() {
		System.out.println("===게시글 전체 조회===");
		
		List<BoardTitleDto>list = bc.selectBoards();
		if(list.isEmpty()) {
			System.out.println("존재하는 게시판이 없습니다.");
		}else {
			list.stream()
				.map(b -> "[게시판번호:"+b.getBoardNo()+", 제목:"+b.getBoardTitle()+", 작성자:"+b.getConsumerId()+"]")
				.forEach(System.out::println);
		}
		System.out.println("==================");
	}
	
	private void selectBoard() {
		selectBoards();
		System.out.print("상세조회 게시판 번호 입력 >");
		int boardNo=0;
		try{
			boardNo = sc.nextInt(); 
			sc.nextLine();
		} catch (InputMismatchException e) {
			System.out.println("게시글의 숫자를 입력해주세요.");
		}
		BoardDto board = bc.selectBoard(boardNo);
		if(board != null) {
			System.out.println("========게시글 상세 조회========");
			System.out.println("게시글번호:"+board.getBoardNo()+",작성일자:"+board.getWirtenDate());
			System.out.println("제목 : "+board.getTitle());
			System.out.println("내용 : "+board.getContent());
			System.out.println("============================");
		} else {
			System.out.println("존재하는 게시글이 없습니다.");
		}
	}
	
	private void createBoard() {
		System.out.println("게시글을 작성합니다.");
		System.out.print("제목 : ");
		String title = sc.nextLine();
		System.out.print("내용 : ");
		String content = sc.nextLine();
		if(title.isBlank() || content.isBlank()) {
			System.out.println("제목이나 내용이 적지 않으셨습니다.");
		}
		int result = bc.createBoard(new BoardDto(consumer.getConsumerNo(),title,content));
		
		if(result > 0) {
			System.out.println("게시판 작성 성공");
		} else {
			System.out.println("게시판 작성 실패");
		}
		
	}

	private void updateBoard() {
		selectMyBoards();
		System.out.println("게시글 수정합니다.");
		System.out.println("번호 입력 >");
	}
	
	private void deleteBoard() {
		selectMyBoards();
		System.out.println("게시글 삭제합니다.");
		System.out.println("번호 입력 >");
	}
	
	private void selectMyBoards() {
		List<BoardTitleDto>list = bc.selectMyBoards(consumer.getConsumerNo());
		if(list.isEmpty()) {
			System.out.println("존재하는 게시판이 없습니다.");
		}else {
			list.stream()
				.map(b -> "[게시판번호:"+b.getBoardNo()+", 제목:"+b.getBoardTitle()+", 작성자:"+b.getConsumerId()+"]")
				.forEach(System.out::println);
		}
		
	}
}
