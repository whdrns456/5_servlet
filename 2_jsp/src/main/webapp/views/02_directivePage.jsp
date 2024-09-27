<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> <%--errorPage ="error500.jsp" --%>>
<%@ page import="java.util.ArrayList"%>    
<%--여러 개의 클래스를 import 하고자 할 떄 컴마로 (,) 구분할 수 있음! --%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>page 지시어</title>
</head>
<body>
		<h1>지시어</h1>
		
		<% 
			ArrayList<String> list = new ArrayList<>();
			// 0번 위치에 "직화제육"			
			list.add("직화제육"); // ["직화제육"]
			
			// 1번 위치에 "햄버거" 데이터 추가
			list.add("햄버거"); // ["직화제육", "햄버거"]
				
			// 2번 위치에 
			Date today = new Date();
			
		%>
			
		<h2>리스트의 길이 : <%--TODO --%>></h2>
		<h2>0번 인덱스의 값 : </h2>
		<h2>1번 인덱스의 값 : </h2>
		<h2>현재 날짜 및 시간</h2>
		
		<%=list.get(0) %>
		<%=list.get(1) %>
		<%=list.size() %>
		<%=today.toLocaleString() %>
		
		<%=list.get(8) %>
	
		
</body>
</html>