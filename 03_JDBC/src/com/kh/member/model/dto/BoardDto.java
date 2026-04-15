package com.kh.member.model.dto;

import java.sql.Date;

public class BoardDto {
	//게시글수가 21억이 넘을수도 있다. -> Long
	//보통 래퍼클래스 Long을 쓴다 왜냐면 의도를 명확하게 null이냐 null이 아니냐 파악하기 위해서.
	
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private String boardWriter;

	public BoardDto() {	}

	public BoardDto(String boardTitle, String boardContent, String boardWriter) {
		super();
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardWriter = boardWriter;
	}

	public BoardDto(int boardNo, String boardTitle, String boardContent, String boardWriter) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardWriter = boardWriter;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getBoardWriter() {
		return boardWriter;
	}

	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}
	
	
}
