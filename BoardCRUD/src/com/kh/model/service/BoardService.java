package com.kh.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.common.Template;
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
}
