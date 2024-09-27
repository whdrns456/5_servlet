<%@page import="java.lang.annotation.Retention"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>POST 요청에 대한 응답페이지</title>
</head>
<body>
	<!-- HTML 주석 -->
	
	<%-- JSP 주석 --%>
		
	<h2>간단한 응답 페이지</h2>
	
	<!-- 자바 코드 작성하기 -->
	<%
		// System.out.println("Hi JSP");
		// 스크립트릿(Scriptlet) : html 문서 내에 자바코드를 사용할 수 있는 영역
		// 서블릿을 통해 전달된 데이터 추출 
	
		String name = (String)request.getAttribute("name");
		String gender = (String)request.getAttribute("gender");
		int age = (int)request.getAttribute("age");
		String address = (String)request.getAttribute("address");
		double height = (double)request.getAttribute("height");
		String[] foods = (String[])request.getAttribute("foods");
		
	%>
	<%--변수의 값을 화면상에 출력하고자 할 때, 첫번째 %뒤에 =를 추가 --%>>
	이름 : <span><%= name%>></span> <br>
	성별 : <%if(gender == null) { %>
			
			<p>선택하지 않음</p>
	<% } else { %>
		
		<span><%= gender %></span> <br>
	
	<% } %>
	
	음식 : <% if(foods == null) { %>
				없습니다. <br>	
	<% } else { %>
		<ol>
			<% for(String food : foods) {%>
			<li><%= food %></li>
			<% } %>
		</ol>	
		
		<% } %>
		
		
</body>
</html>