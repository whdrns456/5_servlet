package test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Servlet implementation class jqAjax2Controller
 */
@WebServlet("/jqAjax2.do")
public class jqAjax2Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public jqAjax2Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// request.setCharacterEncoding("UTF-8");
		// AJAX 때 기본으로 인코딩이 처리된다. 생략이 가능하다

		
		String name = request.getParameter("name"); 
		String strAge= request.getParameter("age");
		
		
		
		
		

		 
		int age = -1;
		if(!strAge.isEmpty()) { age = Integer.parseInt(strAge); }
		  
		  // * 문자열 하나의 데이터로 응답
		  
		  String result = "이름은 " + name + ", 나이 : " + (age == -1 ? "알수없음" : age);
		/*
		 * // 요청 시 전달된 데이터 추출
		 * 
		 * int age = -1; if(!strAge.isEmpty()) { age = Integer.parseInt(strAge); }
		 * 
		 * // * 문자열 하나의 데이터로 응답
		 * 
		 * String result = "이름은 " + name + ", 나이 : " + (age == -1 ? "알수없음" : age);
		 * 
		 * response.setContentType("text/html; charset=UTF-8");
		 * 
		 * response.getWriter().print(result);
		 * 
		 * 
		 * // * 응답 데이터를 여러 개 보내기
		 * 
		 * 
		 * 
		 * response.getWriter().print(name); response.getWriter().print(age);
		 * 
		 * // => 하나의 문자열로 합쳐져서 응답데이터가 전달됨.
		 * 
		 * // response.setContentType("text/html; charset=UTF-8");
		 * 
		 * // * 객체 형태로 응답하기
		 * 
		 *//**
			 * 여러 개의 데이터를 응답하고자 할 때, "JSON" 형태로 응답 (JavaScript Object Notation: 자바스크립트의 객체
			 * 표기법) => ajax 통신할 때 자주 사용되는 형식 중 하나!
			 * 
			 * 
			 * > 자바스크립트 배열 객체 : [value1, value2 value3, ....] => JSONArray > 자바스크립트 일반 객체 :
			 * {key1: value, key2 value2, ...} => JSONObject
			 * 
			 * 
			 * * 라이브러리 추가 필요 (json - simple-x.x.x.jar) =>
			 * https://code.google.com/archive/p/json-simple/downloads
			 * 
			 */
		  
				  // -- 배열 객체(JSONArray)에 담아 응답 --> ArrayList와 유사 
		  		  JSONArray jsonArr = new JSONArray(); // []
				  
				  jsonArr.add(name); // [아이유] jsonArr.add(age); // [아이유, 30]
				  
				  // response.setContentType("text/html; charset=UTF-8"); // => 응답 데이터가
				  // 문자열(String) 타입으로 전달됨 // => 문서 형식 (mime type)을 JSON 형태 (application/json)으로
				 // 설정해야됨 response.setContentType("application/json; charset=UTF-8");
				  response.getWriter().print(jsonArr);
				

		// - 일반 객체(JSONObject)에 담아 응답 --> HashMap과 유사 
		
		JSONObject jsonObj = new JSONObject();
		
		jsonObj.put("name", name);
		jsonObj.put("age", age);
		
		 response.setContentType("application/json; charset=UTF-8");
		 response.getWriter().print(jsonObj);
		
	}

}
