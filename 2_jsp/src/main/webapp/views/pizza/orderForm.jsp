<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>피자 주문 페이지</title>
</head>
<body>

	<%
		// System.out.println("Hi JSP");
		// 스크립트릿(Scriptlet) : html 문서 내에 자바코드를 사용할 수 있는 영역
		// 서블릿을 통해 전달된 데이터 추출 
		String name = (String)request.getAttribute("username");
		String phone = (String)request.getAttribute("phone");
		String address = (String)request.getAttribute("address");
		String[] menu = (String[])request.getAttribute("menu");
		String[] topping = (String[])request.getAttribute("topping");
		String[] side_menu = (String[])request.getAttribute("side_menu");
		
	%>
	
	
	<%--변수의 값을 화면상에 출력하고자 할 때, 첫번째 %뒤에 =를 추가 --%>
	
	이름 : <span><%= name%></span> <br>
	전화번호 : <span><%= phone%>></span> <br>
	주소 : <span><%= address%>></span> <br>
	
	음식 : <% if(menu == null) { %>
				없습니다. <br>	
	<% } else { %>
		<ol>
			<% for(String m : menu) {%>
			<li><%= m %></li>
			<% } %>
		</ol>	
		
		<% } %>
	토핑 : <% if(topping == null) { %>
				없습니다. <br>	
	<% } else { %>
		<ol>
			<% for(String t : topping) {%>
			<li><%= t %></li>
			<% } %>
		</ol>	
		
		<% } %>
	
		사이드메뉴 : <% if(side_menu == null) { %>
				없습니다. <br>	
	<% } else { %>
		<ol>
			<% for(String s : side_menu) {%>
			<li><%= s %></li>
			<% } %>
		</ol>	
		
		<% } %>

</body>
</html>