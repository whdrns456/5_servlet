package test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class jqAjax3Controller
 */
@WebServlet("/jqAjax3.do")
public class jqAjax3Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public jqAjax3Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// Member m = new MemberService().selectMember(userNo);
		
			// 요청 시 전달된 데이터 추출 
		
			String no = request.getParameter("userNo");
			
			Member m = new Member(Integer.parseInt(no), "아이유", "iu1004","서울");
	
		
			// response.getWriter().print(m);
			
			
			// => vo 객체를 전달하고자 할 경우, JSONObject 
			
			/*
			 * JSONObject jsnObj = new JSONObject();
			 * 
			 * jsnObj.put("userNo", m.getUserNo()); jsnObj.put("userName", m.getUserName());
			 * jsnObj.put("userId", m.getUserId()); jsnObj.put("address", m.getAddress());
			 * 
			 * response.setContentType("application/json; charset=UTF-8");
			 * response.getWriter().print(jsnObj);
			 */
			
			// => 좀 더 간단한 방법으로 응답하기 (GSON: Google JSON)
			Gson gson = new Gson();
			
			response.setContentType("application/json; charset=UTF-8");
			
			// Gson객체.toJson(vo객체, 응답할 스트림);
			
			gson.toJson(m, response.getWriter());
			
			/**
			 * Gson 사용 시 vo 객체를 응답하는 경우 JSONbject 형태로 전달 
			 * 	이때, key 값은 vo객체로 전달한다
			 * 
			 *  ArrayList/배열 데이터를 응답하는 경우 JSONArray 형태로 전달
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
