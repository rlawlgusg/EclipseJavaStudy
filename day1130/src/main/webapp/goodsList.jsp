<%@page import="java.util.ArrayList"%>
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
	ArrayList<String> list = new ArrayList<String>();
	list.add("ball1.jpg");
	list.add("ball2.jpg");
	list.add("ball3.jpg");
	list.add("ball4.jpg");
	list.add("ball5.jpg");
	%>
	<h2>목록</h2>
	<hr>
	
	<% 
	for(String images: list){
		%>	
		<img src="images/<%=images%>" width="50" height="50">
		<% 
	}
	
	%>
	
	
	
	

</body>
</html>