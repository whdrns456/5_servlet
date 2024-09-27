<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL - fmt </title>
</head>
<body>
		<h1>JSTL - Formatting Library</h1>
		
		
		<h3>1. formatNumber</h3>
		<p>
			숫자데이터 형식(포맷) 지정 <br>
			* 표현하고자 하는 숫자 데이터의 형식을 통화기호, % 등 원하는 쓰임에 맞게 지정하는 태그 
			
			(fmt:formatNumber value="출력할 값" [groupingUsed="true|false"
												type="percent|currency"
												currencySymbol="문자"
			
														])
		
		</p>
		
		
		<!-- n1, n2, n3 변수에 각각 123456789, 0.77, 50000이라는 값을 저장-->
		
		<c:set var="n1" value="123456789"></c:set>
		<c:set var="n2" value="0.77"></c:set>
		<c:set var="n3" value="50000"></c:set>
		<!-- scope를 저장하지 않으면 가장 작은 scope에 저장된다 -->
			
		<c:out value="${n1}"></c:out> , ${n2 }
		<br>
		*세자리마다 구분하여 출력<fmt:formatNumber value="${n1 }"/>		
		<%--groupingUsed 속성의 기본값 : true --%> <br>
		* 그대로 출력 : <fmt:formatNumber value="${n1 }" groupingUsed="false"/>
		* type=percent : <fmt:formatNumber value="${n2 }" type="percent"/> <br>
		* type=currency : <fmt:formatNumber value="${n2 }" type="currency"/> <br>
		* type=currency :  <fmt:formatNumber value="${n3 }" type="currency"/> <br>
		* 심볼 변경 : <fmt:formatNumber value="${n3 }" type="currency" currencySymbol="$"/> <br>
		
		<hr>
		
		<h3>2. formatDate</h3>
		<p>
			날짜 및 시간 데이터의 포맷(형식) 지정 <br>
			* java.util.Date 객체 사용 
		</p>
		
		<%--today라는 변수에 현재 날짜 데이터를 저장 --%>
		
		 <%
		 	Date date = new Date();
		 	
		 %>
		<c:set var="today" value="<%=date%>"/>
		
		${today}
			
			<ul>
				<li>
				현재 날짜 : <fmt:formatDate value="${today }"/>
				<!-- type 속성 생략 시 날짜만 출력 -->
				</li>
				
				<li>
					현재 시간 : <fmt:formatDate value="${today }" type="time"/>
				</li>
				
				<li>
					현재 날짜 + 시간: <fmt:formatDate value="${today }" type="both"/>
				</li>
					현재 날짜 + 시간: <fmt:formatDate value="${today }" type="both" dateStyle="medium" timeStyle="medium"/>
				
				<li>
				 long 스타일 : <fmt:formatDate value="${today }" type="both" dateStyle="long" timeStyle="long"/>
				</li>
				
				<li>
					full 스타일 : 현재 날짜 + 시간: <fmt:formatDate value="${today }" type="both" dateStyle="full" timeStyle="full"/>
				</li>
				
				<li>
					short 스타일 :  <fmt:formatDate value="${today }" type="both" dateStyle="short" timeStyle="short"/>
				</li>
				
				<li>
					나만의 스타일 : <fmt:formatDate value="${today }" type="both" pattern="yyyy-MM-dd (E) HH:mm:ss"/>
				</li>
			</ul>
			
			
</body>
</html>