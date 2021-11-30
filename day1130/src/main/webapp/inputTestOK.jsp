<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	String id=request.getParameter("id");
	String pwd=request.getParameter("pwd");
%>
로그인 정보는 다음과 같습니다. <br>
아이디:<%=id%> <br>
패스워드:<%=pwd%> <br>
</body>
</html>