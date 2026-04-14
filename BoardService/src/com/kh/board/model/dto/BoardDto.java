package com.kh.board.model.dto;

import java.sql.Date;

public class BoardDto {

	private int boardNo;
	private String title;
	private String content;
	private Date wirtenDate;
	public BoardDto(int boardNo, String title, String content, Date wirtenDate) {
		super();
		this.boardNo = boardNo;
		this.title = title;
		this.content = content;
		this.wirtenDate = wirtenDate;
	}
	
	
	public BoardDto(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}


	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getWirtenDate() {
		return wirtenDate;
	}
	public void setWirtenDate(Date wirtenDate) {
		this.wirtenDate = wirtenDate;
	}

}
