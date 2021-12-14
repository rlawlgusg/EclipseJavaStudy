<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<%
	String color = request.getParameter("color");
	String name = request.getParameter("name");
%>
<body bgcolor="<%=color %>">
	move.jsp로 이동하였습니다
	<hr>
	이름 : <%=URLDecoder.decode(name) %>
</body>
</html>