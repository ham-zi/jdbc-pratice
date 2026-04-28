package com.kh.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.model.dto.BoardDto;

public class BoardDao {

	public int createBoard(SqlSession session, BoardDto board) {
		return session.insert("boardMapper.createBoard", board);
	}
	
	public List<BoardDto> selectBoard(SqlSession session) {
		return session.selectList("boardMapper.selectAll");
	}
	
	public int deleteBoard(SqlSession session, int boardNo) {
		return session.delete("boardMapper.deleteBoard", boardNo);
	}
	
	public BoardDto findBoardByNo(SqlSession session,int boardNo) {
		return session.selectOne("boardMapper.findBoardByNo",boardNo);
	}
}
