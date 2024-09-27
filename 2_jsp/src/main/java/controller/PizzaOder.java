package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PizzaOder
 */
@WebServlet("/pizza.do")
public class PizzaOder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PizzaOder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("userName");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String[] menu = request.getParameterValues("main_menu");
		String[] topping = request.getParameterValues("topping");
		String[] side_menu = request.getParameterValues("side_menu");
			
	
		request.setAttribute("userName", userName);
		request.setAttribute("address", address);
		request.setAttribute("phone", phone);
		request.setAttribute("menu", menu);
		request.setAttribute("topping", topping);
		request.setAttribute("side_menu", side_menu);
		
		// 응답 페이지를 jsp에게 맡기자!
		// jsp 페이지로 응답 설정 : request.getRequestDispatcher(응답할 페이지경로);  
		RequestDispatcher view = request.getRequestDispatcher("views/pizza/orderForm.jsp");
		view.forward(request, response);		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
