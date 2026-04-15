package com.kh.board.model.dto;

public class BoardTitleDto {

	private int boardNo;
	private String boardTitle;
	private String consumerId;
	public BoardTitleDto(int boardNo, String boardTitle, String consumerId) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.consumerId = consumerId;
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
	public String getConsumerId() {
		return consumerId;
	}
	public void setConsumerId(String consumerId) {
		this.consumerId = consumerId;
	}
		
		
	

}
