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




	<h2>�ֹ����</h2>
	<form action="insertOrdersOK.jsp" method="post">

	�ֹ���ȣ: <input type="text" name="orderid"> <br>

	����ȣ: <select name="custid">
	<% for(customervo c:customerlist){
		%>
		<option value="<%=c.getCustid() %>"><%=c.getCustid()%></option>
		<% 
	}%>
	</select>
	<br>
	������ȣ: <select name="bookid">
	<%for(bookvo b:booklist){
		%>
		<option value="<%=b.getBookid()%>"><%=b.getBookid()%></option>
		<%
		} 
		%>
	</select> 
	<br>
	���űݾ�: <input type="text" name="saleprice"> <br>
	<input type="submit" value="���">
	<input type="reset" value="���">
	
	
	
	</form>
	
	
	
	
	
</body>
</html>