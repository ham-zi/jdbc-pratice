package com.kh.member.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.member.model.dto.BoardDto;
import com.kh.member.model.dto.LoginResponse;
import com.kh.member.model.dto.MemberDto;

public class MemberDao {
	
	private Properties prop = new Properties();
	//메소드를 호출할 때 마다
	//XML파일로부터 Properties객체로 입력받는 코드를 써야하는데
	// 생각해보니? Service단에서 필요할 때 마다 Dao 기본생성자를 호출하고 있음
	public MemberDao() {
		try {
			prop.loadFromXML(new FileInputStream("resources/member-mapper.xml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//초기화블록과 생성자로 만드는것. 차이점이 뭘가?
	// 생성자는 매개변수를 받을 수 있따
	
	public boolean idCheck(Connection conn, String memberId) {

		String sql = prop.getProperty("idCheck");
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql);){
			pstmt.setString(1, memberId);
			ResultSet rset = pstmt.executeQuery();
			rset.next();
			return rset.getInt("COUNT(*)") > 0 ? true : false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	public int signUp(Connection conn, MemberDto member) {
		
		int result = 0;
		String sql = prop.getProperty("signUp");
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql);) {
			
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberpwd());
			pstmt.setString(3, member.getMemberName());
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	public LoginResponse login(Connection conn, MemberDto member) {
		LoginResponse lr = null;
		
		try(PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("login"))){
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberpwd());
			try(ResultSet rset = pstmt.executeQuery();){
				if(rset.next()){
				lr = new LoginResponse(rset.getString("MEMBER_ID"), rset.getString("MEMBER_NAME"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lr;
	}
	
	
	// 물음표 -> 위치홀더 
	
	public int loginCheck(Connection conn, String memberId) {
		int result = 0;
		try(PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("loginCheck"))){
			pstmt.setString(1, memberId);
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return result;
	}
	
	public int selectInsertCount(Connection conn, String memberId) {
		int result = 0;
		
		try(PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("selectInsertCount"))){
			pstmt.setString(1, memberId);
			try(ResultSet rset = pstmt.executeQuery()){
				rset.next();
				result = rset.getInt("COUNT(*)");
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}
	
	public int insertBoard(Connection conn, BoardDto board) {
		int result = 0;
		
		try(PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("insertBoard"))){
			pstmt.setString(1, board.getBoardTitle() );
			pstmt.setString(2, board.getBoardContent() );
			pstmt.setString(3, board.getBoardWriter() );
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public List<BoardDto> selectBoardList(Connection conn) {
		List<BoardDto> boards = new ArrayList<>();
		
		try(PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("selectBoardList"))) {
			try(ResultSet rset = pstmt.executeQuery()){
				while(rset.next()) {
					int boardNo = rset.getInt("BOARD_NO");
					String title = rset.getString("BOARD_TITLE");
					String name = rset.getString("MEMBER_NAME");
					
					BoardDto bd = new BoardDto(boardNo, title, null, name);
					boards.add(bd);
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return boards;
	}
	
	public BoardDto selectBoard(Connection conn, int boardNo) {
		BoardDto board = null;
		try(PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("selectBoard"))) {
			pstmt.setInt(1, boardNo);
			try(ResultSet rset = pstmt.executeQuery()){
				if(rset.next()) {
					board = new BoardDto(rset.getInt("BOARD_NO"),rset.getString("BOARD_TITLE"),rset.getString("BOARD_CONTENT"),rset.getString("MEMBER_NAME"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		return board;
	}

	
}
