package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestGetServlet
 */
@WebServlet("/test.do")
public class RequestGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestGetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// System.out.println("GET 요청이 들어왔습니다 ~~~ ");
	
		/* 
		 * 첫번째 매개변수 (request) : 에는 요청 시 전달된 내용들이 담겨져 있다 
		 * 										(사용자가 입력한 값, 요청방식, 요청자의 ip 주소 등)
		 * 두번째 매개변수 (response)에는 요청 처리 후 응답할 때 사용되는 객체이다
		 * 
		 * ---- 
		 * 
		 * 요청 시 전달된 데이터 추출 (request 객체의 parameter 영역 안에 데이터가 담겨 있다.)
		 * request.getParameter("키")
		 *  
		 *  
		 */
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
		
		// Servlet - > DAO > DB 작업 
		/**
		 * int  result = new MemberService().insert(userName, height, address.....);
		 * 	if(result > 0){// 성공}	
		 * else {실패}
		 * 
		 */
		// 인코딩 처리 : 응답데이터의 문서 형식 및 인코딩 방식 설정 
		response.setContentType("text/html; charset=utf-8");
		
		// 응답 시 사용할 스트림 객체(응답 페이지 작성할 것임!)
		PrintWriter pw = response.getWriter();
		
		pw.println("<html>");
		pw.println("<head>");
		
		pw.println("<style>");
		pw.println("span {color: red; }");
		
		pw.println("</style>");
		
		pw.println("</head>");
		
		pw.println("<body>");
		pw.println("<h2>응답페이지 요청</h2>");
		
		pw.printf("<span>%s</span>님",userName);
		pw.printf("<span>%s</span>에 살고 ",address);
		pw.printf("<span>%d</span>살입니다 ",age);
		
		if(foods == null) {
			pw.println("종아하는 음식이 없습니다 ");
		}else {
			pw.printf("좋아하는 음식 : <span>%s</span>", String.join("/", foods));
		}
		
		pw.println("</body>");
		pw.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
