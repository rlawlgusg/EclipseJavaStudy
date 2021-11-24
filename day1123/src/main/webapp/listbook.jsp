<%@page import="com.sist.vo.BookListVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.dao.BookListDAO"%>
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
	int bookid = 1;
	String bookname = "bookname";
%>

<a href="detailbook.jsp?bookid=<%=bookid%>>"><%=bookname%></a>
	
</body>
</html>