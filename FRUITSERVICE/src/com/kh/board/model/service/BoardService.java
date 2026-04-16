package com.kh.board.model.service;

import com.kh.board.model.dao.BoardDao;
import com.kh.board.model.dto.BoardDto;
import com.kh.board.model.dto.BoardTitleDto;
import com.kh.template.Template;

import static com.kh.template.JdbcTemplate.*;

import java.sql.Connection;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class BoardService {

	BoardDao bd = new BoardDao();
	
	public int createBoard(BoardDto board) {
		SqlSession session = Template.getSession();
		int result = bd.createBoard(session, board);
		if(result > 0) {
			session.commit();
		}
		session.close();
		return result;
	}
	
	public List<BoardTitleDto> selectBoards() {
		SqlSession session = Template.getSession();
		List<BoardTitleDto>list = null;
		list = bd.selectBoards(session);
		session.close();
		return list;
	}
	
	public BoardDto selectBoard(int boardNo) {
		SqlSession session = Template.getSession();
		BoardDto board = null;
		board = bd.selectBoard(session, boardNo);
		session.close();
		return board;
	}
	
	public List<BoardTitleDto> selectMyBoards(int csmNo) {
		SqlSession session = Template.getSession();
		List<BoardTitleDto>list = null;
		list = bd.selectMyBoards(session, csmNo);
		session.close();
		return list;
	}
	
	public int updateBoard(BoardDto board) {
		SqlSession session = Template.getSession();
		int result = bd.updateBoard(session,board);
		if(result > 0) {
			session.commit();
		}
		session.close();
		return result;
	}
	
	public int deleteBoard(int boardNo) {
		SqlSession session = Template.getSession();
		int result = bd.deleteBoard(session, boardNo);
		if(result>0) {
			session.commit();
		}
		session.close();
		return result;
	}
	
}
