package com.kh.board.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.ibatis.session.SqlSession;

import com.kh.board.model.dto.BoardDto;
import com.kh.board.model.dto.BoardTitleDto;
import com.kh.template.JdbcTemplate;

public class BoardDao {

	
	public int createBoard(SqlSession session, BoardDto board) {
		return session.insert("boardMapper.createBoard", board);
	}
	
	public List<BoardTitleDto> selectBoards(SqlSession session){
		return session.selectList("boardMapper.selectBoards");
	}
	
	public BoardDto selectBoard(SqlSession session, int boardNo) {
		return session.selectOne("boardMapper.selectBoard", boardNo);
	}
	
	public List<BoardTitleDto> selectMyBoards(SqlSession session, int csmNo) {
		return session.selectList("boardMapper.selectMyBoards", csmNo);
	}
	
	public int updateBoard(SqlSession session, BoardDto board) {
		return session.update("boardMapper.updateBoard", board);
	}
	
	public int deleteBoard(SqlSession session, int boardNo) {
		return session.delete("boardMapper.deleteBoard", boardNo);
	}
	
}
