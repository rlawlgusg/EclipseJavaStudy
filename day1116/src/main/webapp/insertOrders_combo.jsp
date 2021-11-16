<%@page import="java.lang.StackWalker.Option"%>
<%@page import="com.sist.vo.customervo"%>
<%@page import="com.sist.vo.bookvo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.dao.customerdao"%>
<%@page import="com.sist.dao.bookdao"%>
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
	bookdao bookdao = new bookdao();
	customerdao customerdao = new customerdao();
	ArrayList<bookvo> booklist = bookdao.listbook();
	ArrayList<customervo> customerlist = customerdao.listcustomer();	
	%>




	<h2>주문등록</h2>
	<form action="insertOrdersOK.jsp" method="post">

	주문번호: <input type="text" name="orderid"> <br>

	고객번호: <select name="custid">
	<% for(customervo c:customerlist){
		%>
		<option value="<%=c.getCustid() %>"><%=c.getCustid()%></option>
		<% 
	}%>
	</select>
	<br>
	도서번호: <select name="bookid">
	<%for(bookvo b:booklist){
		%>
		<option value="<%=b.getBookid()%>"><%=b.getBookid()%></option>
		<%
		} 
		%>
	</select> 
	<br>
	구매금액: <input type="text" name="saleprice"> <br>
	<input type="submit" value="등록">
	<input type="reset" value="취소">
	
	
	
	</form>
	
	
	
	
	
</body>
</html>