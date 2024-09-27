<%@page import="com.kh.model.vo.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL 기본구문</title>
</head>
<body>
<%-- 
		<h3>
			기존 방식 
		</h3>
		
		<%
		  String classRoom = (String)request.getAttribute("classRoom");
		  Person student =  (Person)request.getAttribute("student"); 	
		
	
			// session scope에서 데이터 가져오기 
				
			String academy = (String)session.getAttribute("academy");
			Person teacher = (Person)session.getAttribute("teacher");
			
			
		/* session.setAttribute("academy", "KH");
		session.setAttribute("teacher", new Person("강사님", 20, "남자"));
		 */
		%>
		

		<p>
		강의장 : <%=classRoom %> <br>
		학원 :   <%=academy %>	<br>	
		강사 :   <%=teacher.getName() %>, 
				<%= teacher.getAge() %>, 
				<%= teacher.getGendet()%> <br>
		
		학생 정보 : 
		<ul>
			<li><%= student.getAge() %></li>
			<li><%= student.getName() %></li>
			<li><%= student.getGendet()%></li>
		</ul>
		</p>
		
--%>
	<h3>EL을 사용하여 보다 쉽게 각 scope영역의 데이터를 화면에 출력</h3>
	
	<p>
		EL을 이용하여 getXXX메소드를 사용하지 않고 키값만 제시하면 바로 접근 가능 <br>  
		기본적으로 EL은 JSP 내장 객체를 구분하지 않고 모든 내장 객체의 키값을 검색하여 
		존재하는 경우 그 값을 가져옴 
		
		
	</p>	
		
	<!-- $ { } EL 표현식-->	
	<p>
	학원 : ${academy} <br>
	강의장 : ${classRoom}<br>
	강사 : ${teacher.name}, ${teacher.age}, ${teacher.gendet}<br>
	학생정보 
			${student.name}, ${student.age}, ${student.gendet}
	</p>
		
	
	<h3>동일한 키값으로 저장된 데이터 확인</h3>
	
	scope 값 : ${scope}
	<!--  
		EL은 공유범위가 가장 작은 scope 부분 해당 키를 찾아준다. (키값을 검색함)
		page -> request -> session -> application 
		
			
	-->	
	<br>
	
	테스트 : %{test}	<!-- 찾지 못한 경우 빈값으로 확인됨 -->
			
	<h3>직접 scope에 데이터 담기</h3>
	
	<% 
		// page scope에 데이터 담기 
		pageContext.setAttribute("scope","page4~~~");
	%>		
	
	
	page scope : ${scope} 또는 ${pageScope.scope} <br>
	
	request scope : ${requestScope.scope} 
	session scope : ${sessionScope.scope}
	application scope : ${applicationScope.scope} 	
			
</body>
</html>