package com.kh.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login.me")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// POST  (요청 시 전달되는 데이터에 한글이 포함된 경우 필요)
		request.setCharacterEncoding("UTF-8");
		
		//  요청 시 전달된 데이터 추출 (아이디, 패스워드)
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		System.out.println("아이디 : " + userId);
		System.out.println("비밀번호 : " + userPwd);
		
		// 1.Service 객체의 메소드 호출 
		// 2.전달된 사용자 정보가 DB에 저장되어 있는 지 확인 => Service 서비스에 요청 
		Member member = new MemberService().loginMember(userId,userPwd);
		
		if(member == null) {
			// 조회 결과가 없는 경우 => 로그인 실패 (에러페이지? 에러메세지?)
			request.setAttribute("errorMsg", "로그인 실패 아이디와 비밀번호를 확인할 수 없습니다 ");
			// 처리된 결과에 따라 응답 사용자가 보게 될 응답화면을 지정하여 포워딩 또는 url 재요청 
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}else {
			// 1. 조회 결과가 있는 경우 => 로그인 성공 			
			// 2. 로그인된 사용자 정보를 session 영역에 저장 
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", member);
			
			// * 포워딩 방식 -> 요청한 url이 변경되지 않음(xxx/login.jsp)
			// 메인 페이지(첫 페이지, index.jsp로) 응답 jsp -> request.getContextPath(); 
			// * url 재요청 방식 :
			response.sendRedirect(request.getContextPath());
		
			// request.setAttribute("userName", member.getUserName());
			// menubar.jsp 페이지에서 로그인 유무를 확인할 때 사용 
		}
		
		/**
		 * 응답페이지에 전달할 값이 있을 경우 어딘가 담아줘야 함. (담을 수 있는 영역 --> JSP 내장 객체 (4종류))
			[1] application : 어플리케이션(프로젝트) 전역에서 사용할 수 있음 
			[2] session : 서버가 실행되는 동안에 세션이 만료되기 전까지 사용할 수 있음
			 				JSP,SERvlet에서 접근 가능하다 
			[3] request : 요청된 request 객체가 가지고 있음. 포워딩된 jsp페이지에서만 접근 가능하다 
		 	[4] page : jsp 페이지에서 생성하고 해당 페이지 내에서만 사용 가능. 
		 */	
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
