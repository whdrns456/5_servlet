<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="javax.xml.crypto.Data"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
			String year = new SimpleDateFormat("yyyy").format(new Date());
			
%>
	
		Copyright &copy; <%=year%>, KH L classRoom	
		전달된 값 : ${ param.month }
		
			

</body>
</html>