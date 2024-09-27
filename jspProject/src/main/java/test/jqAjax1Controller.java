package test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class jqAjax1Controller
 */
@WebServlet("/jqAjax1.do")
public class jqAjax1Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public jqAjax1Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청 시 전달되는 데이터 추출 
		
	 	 String data = request.getParameter("data");
		
	 	 System.out.println("전달된 데이터 : " + data);
	 	 
	 	 // 응답 데이터 
	 	 String result = "전달된 값 : " + data + ", 데이터 길이 : " + data.length();
		
	 	 
	 	 
	 	 // *  응답 데이터 타입 , 인코딩 설정 
	 	 response.setContentType("text/html; charset=UTF-8");
	 	 
	
	 	 
	 	 // 응답 데이터 (돌려주기) 
	 	 
	 	 response.getWriter().print(result);
	 	 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
