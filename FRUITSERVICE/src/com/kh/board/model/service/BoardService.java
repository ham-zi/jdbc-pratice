package com.kh.board.model.service;

import com.kh.board.model.dao.BoardDao;
import com.kh.board.model.dto.BoardDto;
import com.kh.board.model.dto.BoardTitleDto;

import static com.kh.template.JdbcTemplate.*;

import java.sql.Connection;
import java.util.List;

public class BoardService {

	BoardDao bd = new BoardDao();
	
	public int createBoard(BoardDto board) {
		Connection conn = getConnection();
		int result = bd.createBoard(conn, board);
		if(result > 0) {
			commit(conn);
		}
		close(conn);
		return result;
	}
	
	public List<BoardTitleDto> selectBoards() {
		Connection conn = getConnection();
		List<BoardTitleDto>list = null;
		list = bd.selectBoards(conn);
		close(conn);
		return list;
	}
	
	public BoardDto selectBoard(int boardNo) {
		Connection conn = getConnection();
		BoardDto board = null;
		board = bd.selectBoard(conn, boardNo);
		close(conn);
		return board;
	}
	
	public List<BoardTitleDto> selectMyBoards(int csmNo) {
		Connection conn = getConnection();
		List<BoardTitleDto>list = null;
		list = bd.selectMyBoards(conn, csmNo);
		close(conn);
		return list;
	}
	
	public int updateBoard(BoardDto board) {
		Connection conn = getConnection();
		int result = bd.updateBoard(conn,board);
		if(result > 0) {
			commit(conn);
		}
		close(conn);
		return result;
	}
	
	public int deleteBoard(int boardNo) {
		Connection conn = getConnection();
		int result = bd.deleteBoard(conn, boardNo);
		if(result>0) {
			commit(conn);
		}
		close(conn);
		return result;
	}
	
}
