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

import com.kh.board.model.dto.BoardDto;
import com.kh.board.model.dto.BoardTitleDto;
import com.kh.template.JdbcTemplate;

public class BoardDao {


	{
		JdbcTemplate.resisterDriver();
	}

	Properties prop = new Properties();
	
	public BoardDao() {
		try {
			prop.loadFromXML(new FileInputStream("resources/board-mapper.xml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int createBoard(Connection conn, BoardDto board) {
		int result = 0;
		
		try(PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("createBoard"))){
			pstmt.setInt(1, board.getConsumerNo());
			pstmt.setString(2, board.getTitle());
			pstmt.setString(3, board.getContent());
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public List<BoardTitleDto> selectBoards(Connection conn){
		List<BoardTitleDto>list = new ArrayList<>();
		
		try(PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("selectBoards"))){
			
			try(ResultSet rset = pstmt.executeQuery()){
				while(rset.next()) {
					BoardTitleDto board = new BoardTitleDto(rset.getInt("BOARD_NO")
														   ,rset.getString("BOARD_TITLE")
														   ,rset.getString("CONSUMER_ID"));
					list.add(board);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public BoardDto selectBoard(Connection conn, int BoardNo) {
		BoardDto board = null;
		
		try(PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("selectBoard"))){
			pstmt.setInt(1, BoardNo);
			try(ResultSet rset = pstmt.executeQuery()){
				if(rset.next()) {
					board = new BoardDto(BoardNo,0, rset.getString("BOARD_TITLE"),rset.getString("BOARD_CONTENT"),rset.getDate("WRITEN_DATE"));
				}
			} catch (SQLException e){
				e.printStackTrace();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return board;
	}
	
	public List<BoardTitleDto> selectMyBoards(Connection conn, int csmNo) {
		List<BoardTitleDto>list = new ArrayList<>();
		
		try(PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("selectMyBoards"))){
			pstmt.setInt(1, csmNo);
			try(ResultSet rset = pstmt.executeQuery()){
				while(rset.next()) {
					BoardTitleDto board = new BoardTitleDto(rset.getInt("BOARD_NO")
							   ,rset.getString("BOARD_TITLE")
							   ,rset.getString("CONSUMER_ID"));
					list.add(board);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
}
