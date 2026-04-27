package com.kh.controller;

import java.util.List;

import com.kh.model.dto.BoardDto;
import com.kh.model.service.BoardService;

public class BoardController {

	BoardService bs = new BoardService();

	
	public int createBoard(BoardDto board) {
		return bs.createBoard(board);
	}
	
	public List<BoardDto> selectAll() {
		return bs.selectAll();
	}
}
