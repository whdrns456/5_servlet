package com.kh.member.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.common.JDBCTemplate;
import com.kh.member.model.vo.Member;

public class MemberDao { 
	
	
	private Properties prop = new Properties();
	
	public MemberDao(){
		
		String filepath = MemberDao.class.getResource("/db/sql/member-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(filepath));
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}
	
	public Member loginMember(Connection conn, String userId, String userPwd) {
		// DB SELECT문 조회 -> ResultSet (한 행만 조회가 된다.) Member 객체 반환 
			
		// 결과로 반환할 객체 
		Member m = null;
		// JDBC 객체 -> SQL문 실행 후 결과를 받아올 객체 
		PreparedStatement pstmt = null; 
		// JDBC 객체 -> 조회 결과가 담길 객체 
		ResultSet rset = null; 
		
		// 실행할 쿼리문 
		String sql = prop.getProperty("loginMember");
				
		try {
			pstmt = conn.prepareStatement(sql); // 미완성 형태 
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			// 조회 결과가 있을 경우 한 행 반환/없을 경우 아무것도 반환되지 않음 
			rset = pstmt.executeQuery(); 
			if(rset.next()){
				// 조회된 결과가 있을 경우 Member 객체에 담기 		
				m = new Member(rset.getInt("user_no")
						,rset.getString("user_id")
						,rset.getString("user_pwd")
						,rset.getString("user_name")
						,rset.getString("phone")
						,rset.getString("email")
						,rset.getString("address")
						,rset.getString("interest")
						,rset.getDate("enroll_date")
						,rset.getDate("modify_date")
						,rset.getString("status"));		
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);	
		}
		return m; 
	}
			
	public int insertMember(Connection conn, Member m) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertMember");
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPwd());
			pstmt.setString(3, m.getUserName());
			pstmt.setString(4, m.getPhone());
			pstmt.setString(5, m.getEmail());
			pstmt.setString(6, m.getAddress());
			pstmt.setString(7, m.getInterest());
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	public int idCheck(Connection conn, String userId) {
		
		int result = 0;
		// Member m = null; 
		
		PreparedStatement pstmt = null;
		ResultSet rset = null; 
		
		String sql = prop.getProperty("userIdCheck");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				result = rset.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}



	public int updateMember(Connection conn, Member m) {
		int result = 0; 
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateMember");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getUserName());
			pstmt.setString(2, m.getPhone());
			pstmt.setString(3, m.getEmail());
			pstmt.setString(4, m.getAddress());
			pstmt.setString(5, m.getInterest());
			pstmt.setString(6, m.getUserId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public Member selectMember(Connection conn, String userId) {
		
		Member m = null;
		PreparedStatement pstmt = null; 
		ResultSet rset = null; 
		
		String sql = prop.getProperty("selectMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				m = new Member(
						rset.getInt("user_no")
						,rset.getString("user_id")
						,rset.getString("user_pwd")
						,rset.getString("user_name")
						,rset.getString("phone")
						,rset.getString("email")
						,rset.getString("address")
						,rset.getString("interest")
						,rset.getDate("enroll_date")
						,rset.getDate("modify_date")
						,rset.getString("status")		
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return m;
	}
}
