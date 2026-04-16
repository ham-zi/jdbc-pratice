package com.kh.board.model.dto;

import java.sql.Date;

public class BoardDto {

	private int boardNo;
	private int consumerNo;
	private String title;
	private String content;
	private Date wirtenDate;
	
	public BoardDto(int boardNo, int consumerNo, String title, String content, Date wirtenDate) {
		super();
		this.boardNo = boardNo;
		this.consumerNo = consumerNo;
		this.title = title;
		this.content = content;
		this.wirtenDate = wirtenDate;
	}
	
	public BoardDto(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}
	
	

	public BoardDto(int consumerNo, String title, String content) {
		super();
		this.consumerNo = consumerNo;
		this.title = title;
		this.content = content;
	}

	public BoardDto() {
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public int getConsumerNo() {
		return consumerNo;
	}

	public void setConsumerNo(int consumerNo) {
		this.consumerNo = consumerNo;
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
