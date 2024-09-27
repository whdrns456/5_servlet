<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

    <ol>
        <li>선</li>
        <li></li>
        <li>
            표현식(출력식) : &lt;%= 자바코드 %&gt
            자바코드의 값을 화면상에 출력하기 위해 사용
        </li>
    </ol>
    

    <h1>스크립팅 원소</h1>

    <!--HTML 주석 : 브라우저의 개발자 도구 탭에서 노출됨--><br>
    <%-- JSP 주석은 브라우저 개발자 도구 탭에서 노출되지 않음 --%> 

    <% 
        // 스크립트릿 : 해당 영역에서는 일반적인 자바코드 작성한다
        // (변수 선언, 초기화, 제어문 등)
        
        int sum = 0; 
        for(int i = 1; i <= 100; i++){
            sum += i; 
        }
    %>
        <p>
            화면에 출력 <br>
            표현식을 사용하여 출력 : <%= sum %>
            스크립트릿을 사용하여 출력 : <% out.println(sum); %>

            <%-- out : JSP 내장객체(PrintWriter) --%>
        </p>

        <%
            String[] pArr = {"기다운", "양준혁", "조건웅","임현호"};
        %>

        <h5>배열 길이 : </h5>
        <%= pArr.length %>

        <h5>배열에 담긴 값 : </h5>
        <%= String.join("," , pArr) %>

        <h5>반복문 사용하여 출력</h5>
        <ul>
            <% for(int i = 0; i<pArr.length; i++) { %>
                <% out.println(pArr[i]); %>
            <% } %>   
        </ul>

        



</body>
</html>