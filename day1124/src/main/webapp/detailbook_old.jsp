<%@page import="com.sist.dao.BookDAO"%>
<%@page import="com.sist.vo.BookVO"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>도서상세</h2>
	<table>
	<%
		int bookid = Integer.parseInt(request.getParameter("bookid"));
		BookDAO dao = new BookDAO();
		BookVO b = dao.getBook(bookid);
	%>
			<tr><td>도서번호 </td><td><%= b.getBookid()%></td></tr>
			<tr><td>도서명 </td><td><%= b.getBookname()%></td></tr>
			<tr><td>출판사명 </td><td><%= b.getPublisher()%></td></tr>
			<tr><td>가격 </td><td><%= b.getPrice()%></td></tr>
	
	
	
	</table>
	
	
	

</body>
</html>