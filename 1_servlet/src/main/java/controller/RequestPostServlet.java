package controller;

import java.io.IOException;
import java.net.URI;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestPostServlet
 */
@WebServlet("/test2.do")
public class RequestPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public RequestPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("doget 메소드 실행");
		
		// 요청 시 전달된 데이터 => request의 parameter 영역에 있음 
		
		// POST 방식의 경우 데이터를 처리하기(추출) 전에 인코딩 설정 필요하다! 
		request.setCharacterEncoding("UTF-8");
				
		String userName = request.getParameter("userName");
		String gender = request.getParameter("gebder");   // NULL  전달된 값이 없을 경우 
		int age = Integer.parseInt(request.getParameter("age"));
		String address = request.getParameter("address");
		double height = Double.parseDouble(request.getParameter("height"));
		
		System.out.println("이름 :" + userName);
		System.out.println("성별 :" + gender);
		System.out.println("나이 :" + age);
		System.out.println("주소 : "  + address);
		System.out.println("키 :" + height);
		
		// 같은 키 값으로 여러개의 데이터가 전달되는 경우 : getParameterValues("키") : String[]
		String[] foods = request.getParameterValues("food");
		
		System.out.println(foods);
			
		if(foods == null) {
			System.out.println("선택된 음식없음");
		}else {
			System.out.println("food : " + String.join("/", foods));
		}	
	// ---------------------------------------------------------------
		
		/*
		 * * 순수 서블릿 방식 : Java 코드 내에서 html 작성 
		 * * JSP(Java Server Page) 방식 : html 내에 Java 코드 작성  
		 * 
		 */
		
		// 응답 페이지에서 필요한 데이터를 정리하여 전달
		// -> 전달하는 공간 : request 객체의 attribute라는 공간 사용 
		request.setAttribute("name", userName);
		request.setAttribute("gender", gender);
		request.setAttribute("age", age);
		request.setAttribute("address", address);
		request.setAttribute("height", height);
		request.setAttribute("foods", foods);
		
		
		
		// 응답 페이지를 jsp에게 맡기자!
		
		// jsp 페이지로 응답 설정 : request.getRequestDispatcher(응답할 페이지경로);  
		RequestDispatcher view = request.getRequestDispatcher("views/responsePage.jsp");
		view.forward(request, response);
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost 메소드 실행");
		doGet(request, response);
	}

}
