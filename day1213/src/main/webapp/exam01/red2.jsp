<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body bgcolor="red">
	<h2>red입니다.</h2>
	<%
		response.sendRedirect("yellow2.jsp");
	%>
</body>
</html>