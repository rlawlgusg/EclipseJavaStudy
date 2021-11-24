<%@page import="com.sist.vo.BookVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.dao.BookDAO"%>
<%@page import="oracle.security.o3logon.a"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="org.apache.catalina.filters.ExpiresFilter.XServletOutputStream"%>
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
	<table>
	<tr>
	<td>도서번호</td>
	<td>도서명</td>
	</tr>
	<%
	BookDAO dao = new BookDAO();
	ArrayList<BookVO> list = dao.listBook();
	for(BookVO b:list){
		%>
		<tr>
		<td><%=b.getBookid()%></td>
		<td><a href = "detailbook_old.jsp?bookid=<%=b.getBookid()%>"><%=b.getBookname()%></a></td>
		</tr>
		<% 	
	}
	
	%>



</table>
</body>
</html>