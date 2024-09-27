package com.kh.member.model.service;

import java.sql.Connection;

import static com.kh.common.JDBCTemplate.*;
import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.vo.Member;

public class MemberService {

	public Member loginMember(String userId, String userPwd) {
		// Connention 객체를 생성하여 Dao에게 전달 
		Connection conn = getConnection();
		
		// DAO 객체에게 DB에 아이디와, 비밀번호에 해당하는 데이터가 있는 지 확인 요청 
		Member m =  new MemberDao().loginMember(conn,userId,userPwd);
		
		// Connection 객체 반납 (Close)
		close(conn);
		
		return m;
	}

	public int insertMember(Member m) {
		Connection conn = getConnection();
		
		// insert(DDL) --> int --> 트랜잭션 처리(commit, rollback)
		

		int result = new MemberDao().insertMember(conn, m);

		System.out.println(result);
		if(result > 0) { // 회원 데이터 추가 성공
			commit(conn); 
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

//	public int idCheck(String userId) {
//		Connection conn = getConnection();
//		
//		int result = new MemberDao().idCheck(conn, userId);
//		
//		close(conn);
//		
//		return result;
//	}

	public int idCheck(String userId) {
		// Connection 객체 생성 
		
		// DQL (Select) => Connection 객체 반납 (close)
		
		
		Connection conn = getConnection();
		
		int result = new MemberDao().idCheck(conn, userId);
		
		close(conn);
		
		return result;
		
	}

	public Member updateMember(Member m) {
		Member mem = null;
		
		Connection conn = getConnection();
		// 객체 생성 
		
		// update DML -> 
		int result = new MemberDao().updateMember(conn, m);
		
		if(result > 0) { 
			commit(conn); 
			// 변경된 사용자 정보 조회 
			mem = new MemberDao().selectMember(conn, m.getUserId());
		}else {
			rollback(conn);
		}
		close(conn);
		return mem;
	}
}
