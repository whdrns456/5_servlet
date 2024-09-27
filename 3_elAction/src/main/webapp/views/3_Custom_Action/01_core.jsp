<%@page import="com.kh.model.vo.Person"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.lang.reflect.Array"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!--  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" 고정?? -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Custom Action Tag - core</title>
</head>
<body>
	<h1>JSTL Core Library</h1>
	
	<h3>1. 변수</h3>	
	<pre>
	 	* 변수 선언과 동시에 초기화 (c:set var="변수명" value="값" [scope="저장할객체"]) 
		- 변수 선언하고 초기화까지의 기능을 제공 
		- 해당 변수의 저장된 값을 어떤 scope에 setAttribute를 통해서 담아둘 지 결정 		
		=> c:set으로 선언한 변수는 반드시 EL로 %{} 접근해야한다. 
	</pre>
	
	<%--num1 이라는 변수에 10이라는 값을 저장 --%>
	<c:set var="num1" value="10"></c:set> <!-- pageScope.setAttribute("num1",10) -->
	<c:set var="num2" value="20" scope="request"></c:set>
	
	
	<p>
	num1 : ${num1}
	num2 : ${num2}
	
	</p> 
	
	<!-- num1 num2  -->
	<c:set var="addNum" value="${num1 + num2}" scope="session"></c:set>
	addNum : ${addNum}
	
	<!-- value 속성 대신 시작태그와 종료태그 사이에 초기값을 지정 가능하다 value 없이 값을 설정-->
	<c:set var="result">
	
	99999
	
	</c:set>
	
	<p>
		${result} 
	</p>
	
	<%-- 
		<c:remove var="result" value="7777" scope="request"/>
	 --%>
	
	
	<hr>
	
	<pre>
		* 변수 삭제 : (c:remove var="삭제할 변수명" [scope="삭제하고자하는 영역]") 
		- 해당 scope 영역에 저장되어 있는 변수를 찾아 제거하는 태그 		
		=> 해당 scope에 removeAttribute()를 사용하여 제거하는 것과 동일하게 처리됨 
	</pre>
	
	<!-- addNum 변수를 삭제 -->
		
	<b>*특정 스코프 영역에서 제거</b>
		
	
	<p>addNum : ${addNum} </p>
	<c:remove var="addNum" scope="session"/>
	<p>제거 후 addNum : ${addNum}</p> <!-- 공백으로 표시됨 -->
	
	<p>page scope에 저장된 result  : ${pageScope.result}</p> 
	<p>request scope에 저장된 result  : ${request.result}</p> 
	
	<b>모든 스코프에서 제거</b>
	<p>scope 속성 없이 제거 : ${pageScope.result} / ${requestScope.result}</p>
	
	<pre>
		* 변수(데이터) 출력 
		
		(c:out value="출력하고자하는 값" [default="기본값"] escapeXml="true|false")
	
	</pre>
	<c:out value="${addNum}"/>
	
	<c:out value="${addNum}" default="데이터없음"/>
	
	<!-- outData라는 변수에 "<b>강조태그</b>" 값을 저장 -->
	
<%-- 	<c:out value="${addNum}" default="데이터없음" escapeXml="true"/> --%>
	
	<br>
	<c:set var="outData" value="<b>강조태그!!!</b>"/>
	<c:out value="${outData}" escapeXml="false"/> 
	<!-- escapXml 속성이 true(기본값) -> 출력데이터에 태그가 포함되어 있는 경우 해석되지 않음
		 기본값은 true이다 
	
	 -->
	<c:out value="${outData}" escapeXml="false"/>
	
	<hr>
	
	<h3>2. 조건문 if(c:if test="조건식")</h3>
	
	<pre>
		- Java의 if문과 비슷한 역할을 하는 태그 
		- 조건식은 test 속성에 작성 (EL구문을 사용하여 작성) 
	</pre>
	
	<!-- JSTL로 선언된 변수는 스크립트문에서 접근이 불가하다 -->
	<!-- num1 이 num 보다 큰가?  -->
		
	
	<c:if test="${num1 > num2}">
		num1이 num2보다 크다아아아아아아앙
	</c:if>
	
	<c:if test="${num2 gt num1}">
		num2이 num1보다 크다아아아아아아앙
	</c:if>
	
	
	<c:set var="hi" value="안녕"/>
	<!-- hi 변수에 저장된 값이 "안녕"일 경우 hihihi~ 출력 
		그렇지 않으면 bye
	 -->

	<br>
	
	<!-- '' 작은따움표를 통해서 사용할 것 -->
	<c:if test="${hi eq '안녕'}">
		<p>hihihi</p>
	</c:if>
	
	<c:if test="${hi ne '안녕'}">
		<p>byebye</p>
	</c:if>
	<br>
	<h3>3. 조건문 - Choose (c:choose, c:when, c:otherwise) : </h3>
	
	<pre>
	 	-Java의 if - else, if - else if문과 비슷하게 동작하는 태그이다 
	 	- 구조 c: choose
	 	
	 	* c:choose 하위요소로 c:when, c:otherwise를 사용한다. 
	 	c:when / c:when
	 	c:otherwise / c:ootherwise 
	 	
	 	/c:choose 
	 	
	</pre>
	
	<!-- num1의 값이 20보다 크면 "20보다 큼", 
		 10보다 크거나 같으면 "10보다 크거나 같음"
		 , 그렇지 않으면 "10보다 작음"을 출력
	 -->
	
	<c:choose>
		<c:when test="${num1 gt 20}">20보다 큼</c:when>	
		<c:when test="${num1 ge 10}"><h4>10보다 크거나 같음</h4></c:when>	
		<c:otherwise>10보다 작음</c:otherwise>
	</c:choose> 
	<hr>
	
	<h3>4. 반복문 - c:forEach</h3>
	
	<pre>
		* for loop문 :(c:forEach var="변수명" begin="초깃값" end="끝값" [step="반복 시 증가값"])
	
		* 향상된 for문 - (c:forEach var="변수명" items="배열/컬렉션(순차적으로 접근하고자하는 객체)")
											varStatus="현재 접근된 요소의 상태값을 보관하는 변수명")																
	</pre>
	
	<c:forEach var="i" begin="1" end="6">
		
		<ul>
			<li>i의 값은 :  ${i}</li>
		</ul>
	
	</c:forEach>
	
	<!-- h1 ~ h6 태그를 출력하는데, 나는 h1태그야  -->
		<c:forEach var="i" begin="1" end="6">
		<h${i}> h${i} 태그야</hi>
	</c:forEach>
	
	<c:set var="fruits">
		수박, 애플, 토마토, 망고, 딸기
	</c:set>
	
	-> fruits에 저장된 값 : ${fruits}
	
	<ul>
		<c:forEach var="f" items="${fruits}">
			<li>${f}</li>
		</c:forEach>
	</ul>
	
	<%--
		colors라는 변수에 4가지의 색상을 ,로 구분하여 저장 
	 --%>
	 
	 	<c:set var="colors">
		red, orange, blue, pink  
		</c:set>
		
		<ul>
			<c:forEach var="f" items="${colors}">
			<li style="color:${f};"> ${f}</li>
		</c:forEach>
	</ul>
	
	<%
		ArrayList<Person> list = new ArrayList<>(); 

		list.add(new Person("기다운", 30, "남자"));
		list.add(new Person("임현호", 30, "남자"));
		list.add(new Person("카리나", 25, "여자"));		
	%>
	
	<c:set var="pList" value="<%=list%>" scope="request"/>
	
	<table border="1">
		<thead>
			<tr>
				<th>NO</th>
				<th>이름</th>
				<th>나이</th>
				<th>성별</th>
			</tr>
		
		</thead>
		<tbody>
		<%-- <% if(list.isEmpty()){ %>
			<tr>
				<td colspan="4"></td>
			</tr>	 --%>
			
			<c:choose>
			<c:when test="${ empty pList}">
			<tr>
			<td colspan="4">조회된 결과가 없습니다.</td>
			</tr>
			</c:when>
			
			<c:otherwise>
				<c:forEach var="p" items="${ pList}" varStatus="s">
					
					<tr>
						<%-- <td>${s.index}</td> --%> <!-- index : 0부터 시작 -->
						<td>${s.count }</td> <!-- count 1부터 시작한다 -->
						<td>${p.name}</td>
						<td>${p.age}</td>
						<td>${p.gendet}</td>
					</tr>
				</c:forEach>
			</c:otherwise>
			</c:choose>	
		</tbody>
	</table>	
	
	<h3>5. 반복문 - forTokens</h3>
	<pre>
		특정 구분자를 통해서 순차적으로 접근하고자 할 때 사용 
		
		c: forTokens var = "변수명" items="분리하고자하는 대상" delims="구분자"
		
		- 구분자를 통해서 분리된 각각의 값에 순차적으로 접근하여 반복문 수행
		- 콤마(,)가 아닌 다른 구분자를 사용하고자 할 때 사용 
		- Java에서 문자열.split("구분자") 또는 StringTokenizer와 비슷한 기능 
	</pre>
	
	<%-- movie 라는 이름의 변수에 5개 저장 (구분자 : / . ,) --%>
	
	<c:set var="movie" value="에일리언/행복의나라.인사인아웃2,친구/유희왕빛의피라미드"/>
	<h4>영화 목록</h4>
	
	<ol>
		<c:forTokens var="m" items="${movie}" delims="/.,">
		<li>${m}</li>
		</c:forTokens>
	</ol>
	
	<hr>
	
	<h3>6. url, query String 관련 - c:url, c:param </h3>
	<pre>
		* url 경로를 생성하고, query string을 정의해 둘 수 있는 태그 
		c: url var="변수명" value="요청할url"
			c:param name="키값" value="데이터" / 
			c:param name="키값" value="데이터" / 
		/c:url 
	</pre>
	
	<a href="list.do?cpage=1&num=10">기존방식</a>
	
	<c:url var="listUrl" value="list.do">
		<c:param name="cpage" value="1"/>
		<c:param name="num" value="10"/>
	</c:url>
	
	<a href="${ listUrl }">JSTL 방식</a>
	
	
	<br>
	<hr>
	<br>
	
	<h4>2. JSTL Formatting Library</h4>
	
	<pre>
		숫자, 날짜 및 시간 데이터의 출력 형식을 지정할 때 사용하는 문법을 제공
	</pre>	
	

	
	
	
		
	
</body>
</html>