package com.kh.board.controller;


import java.util.List;

import com.kh.board.model.dto.BoardDto;
import com.kh.board.model.dto.BoardTitleDto;
import com.kh.board.model.service.BoardService;

public class BoardController {

	BoardService bs = new BoardService();
	
	
	public int createBoard(BoardDto board) {
		return bs.createBoard(board);
	}
	
	public List<BoardTitleDto> selectBoards(){
		return bs.selectBoards();
	}
	
	public BoardDto selectBoard(int boardNo) {
		return bs.selectBoard(boardNo);
	}
	
	public List<BoardTitleDto> selectMyBoards(int csmNo) {
		return bs.selectMyBoards(csmNo);
	}
	
	public int updateBoard(BoardDto board) {
		return bs.updateBoard(board);
	}
	
	public int deleteBoard(int boardNo) {
		return bs.deleteBoard(boardNo);
	}
	
	
}
