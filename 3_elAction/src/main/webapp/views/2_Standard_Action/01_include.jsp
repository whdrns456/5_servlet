<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h3>* jsp : include</h3>
		
		<p>또 다른 페이지를 포함하고자 할 때 쓰는 태그이다</p>
		
		<h4>[1]기존 include 지시어를 이용한 방식</h4>
	 	
		<%-- 	<%@include file="footer.jsp"%> : 기존 방식 --%>
			
		<%--
			기존 include 방식은 포함된 페이지의 변수로 
			접근이 가능하고 같은 이름의 변수 선언이 불가능하다 
			
			<%@include file= "footer.jsp"%> 
			
			year 변수로 접근 가능한가? <%= year %>
			포함된 페이지의 변수로 접근이 가능하고, 
			같은 이름의 변수 선언 불가!
			
			<% String year = "2020"; %>	
		
			컴파일 시점
			
		 --%>			
		 
		 <h4>[2] 표준 액션 태그를 이용한 방식</h4>
		 
		 <!--
		 	표준 액션 태그 이용한 방식 
		 	<
		 		jsp:include page="footer.jsp"
		 		
		 	>
		 	
		 -->

		<jsp:include page="footer.jsp"/>
		
		<!-- 전달되는 값이 없을 때 사용하는 방식 
		
		 	런타임 시점 
		-->
		<p>
			특징 1) include하고 있는 페이지에 선언된 변수를 공유하지 않음 
			=> 동일한 이름의 변수를 선언할 수 있음 	
		</p>
		
		<% String year = "2020"; %>
		<%= year %>
		
		<p>
		특징 2) include되는 페이지로 데이터(값을) 전달 할 수 있다 
		<jsp:include page="footer.jsp">
			<jsp:param name="month" value="8" />		
		</jsp:include>
		</p> 
		
</body>
</html>