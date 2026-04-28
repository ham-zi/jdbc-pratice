package com.kh.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.common.Template;
import com.kh.exception.NotFoundBoardException;
import com.kh.model.dao.BoardDao;
import com.kh.model.dto.BoardDto;

public class BoardService {

	BoardDao bd = new BoardDao();
	
	public int createBoard(BoardDto board) {
		SqlSession session = Template.getSqlSession();
		int result = bd.createBoard(session, board);
		if(result > 0) {
			session.commit();
		}
		session.close();
		return result;
	}
	
	public List<BoardDto> selectAll() {
		SqlSession session = Template.getSqlSession();
		List<BoardDto> list = bd.selectBoard(session);
		session.close();
		return list;
	}
	
	public int deleteBoard(int boardNo,String password) {
		SqlSession session = Template.getSqlSession();
		int result = 0;
		BoardDto board = findBoardByNo(boardNo);
		if(board == null) {
			throw new NotFoundBoardException();
		}
		if(board.getPassword().equals(password)) {
			result = bd.deleteBoard(session, boardNo);			
		}
		
		if(result > 0) {
			session.commit();
		}
		session.close();
		return result;
	}
	
	private BoardDto findBoardByNo(int boardNo) {
		SqlSession session = Template.getSqlSession();
		BoardDto board = bd.findBoardByNo(session, boardNo);
		session.close();
		return board;
	}
}
