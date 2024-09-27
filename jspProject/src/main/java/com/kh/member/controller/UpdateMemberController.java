package com.kh.member.controller;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class UpdateMemberController
 */
@WebServlet("/update.me")
public class UpdateMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMemberController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		// 전달된 데이터 추출 
		
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String userPwd = request.getParameter("userPwd");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		
		
		
		String[] interestArr = request.getParameterValues("interest");
		
		System.out.println(userId);
		System.out.println(userName);
		System.out.println(userPwd);
		System.out.println(phone);
		System.out.println(email);
		System.out.println(address);
		
	/*	for(String arr : interestArr) {
			System.out.println(arr);
		}
	*/	
		
		// 문자열 배열 (Strimg join)
		String interest = "";
		
		if(interestArr != null) {
			interest = String.join(",", interestArr);
		}
		
		Member m =  new Member(userId,userName,phone,email,address,interest);
		
		Member updateMem = new MemberService().updateMember(m);
		
		if(updateMem == null) { // 정보 수정 실패 
			// 정보 수정 실패 메세지와 함께 에러페이지로 응답 

			 request.setAttribute("upErrorMsg", "회원정보 수정 실패 했습니다 ");
			 
			 request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			 
			
		}else { 	// 정보 수정 성공 
			// 세션 영역에 변경된 사용자 정보를 저장 
			session.setAttribute("loginUser",updateMem);
			
			
			// 수정 성공했다는 메세지를 알림창을 띄울 수 있도록 세션 영역에 저장 
			session.setAttribute("alertMsg", "업데이트 성공했습니다");
			
			 // 마이페이지로 url 재요청 (/jsp/myPage.me)
			request.getRequestDispatcher("/myPage.me").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
