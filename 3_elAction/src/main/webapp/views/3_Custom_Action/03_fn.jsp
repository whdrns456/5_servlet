<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL - fn</title>
</head>
<body>
	<h1>JSTL - function library</h1>
		
	<c:set var="qt" value="Know yourself"/>
	
	* 명언 : ${ qt } <br>
	
	<ul>
		<li>
			길이 : ${qt.length() }
		</li>
		
		<li>
			길이(fn) : ${fn:length(qt) } <%-- ArrayList, 문자열 사용 가능(길이) --%>
		</li>
		
			<li>
				대문자로 출력 : ${ fn:toUpperCase(qt) }
			</li>
			
			<li>
				소문자로 출력 : ${ fn:toLowerCase(qt) }
			</li>
			
			
			<li>
				'r' 의 시작 인덱스 : ${ fn:indexOf(qt, "r")}
			</li>
				
			<li>
				's'의 포함 여부 : ${fn:contains(qt, 's')}
			</li>	
	</ul>
	
	
	<c:if test="${fn:contains(qt,'s')}">
		<mark>'s'가 포함되어 있다</mark>
	</c:if>
	
	
	
	
</body>
</html>