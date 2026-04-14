package com.kh.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.member.model.dto.MemberDto;
import com.kh.template.JdbcTemplate;

public class MemberDao {

	{
		JdbcTemplate.resisterDriver();
	}
	
	
	public boolean isMemberId(Connection conn,String id) {
		ResultSet rset = null;
		String sql = """
						SELECT
						       MEMBER_NO
						  FROM
						       DS_MEMBER
						 WHERE
						       MEMBER_ID = ?
					 """;
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, id);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				return true;
			} else {
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return false;
	}
	
	public int createMember(Connection conn, MemberDto dto) {
		int result=0;
		String sql = """
						INSERT
						  INTO
						       DS_MEMBER (MEMBER_ID, MEMBER_PW)
						VALUES
							   (
							   ?
							 , ? 
							   )
					 """;
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, dto.getMemberId());
			pstmt.setString(2, dto.getMemberPw());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public MemberDto login(Connection conn, MemberDto dto) {
		ResultSet rset = null;
		MemberDto member = null;
		String sql = """
						SELECT
							   MEMBER_NO
							 , MEMBER_ID
							 , MEMBER_PW
							 , HIRE_DATE
						  FROM
						       DS_MEMBER
						 WHERE 
						       MEMBER_ID = ?
						   AND
						       MEMBER_PW = ?
					 """;
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, dto.getMemberId());
			pstmt.setString(2, dto.getMemberPw());
			rset = pstmt.executeQuery();
			if(rset.next()) {
				member = new MemberDto(rset.getInt("MEMBER_NO"),rset.getString("MEMBER_ID"),rset.getString("MEMBER_PW"),rset.getDate("HIRE_DATE"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return member;
	}
}
