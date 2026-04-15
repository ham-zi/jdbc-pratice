package com.kh.board.controller;

import com.kh.board.model.dto.BoardDto;
import com.kh.board.model.service.BoardService;

public class BoardController {

	BoardService bs = new BoardService();
	
	public int createBoard(BoardDto dto) {
		return bs.createBoard(dto);
	}
	
}
