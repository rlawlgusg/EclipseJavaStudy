<%@page import="com.sist.dao.ordersdao"%>
<%@page import="com.sist.dao.ordersvo"%>
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
	//int orderid = Integer.parseInt(request.getParameter("orderid"));
	int custid = Integer.parseInt(request.getParameter("custid"));
	int bookid = Integer.parseInt(request.getParameter("bookid"));
	int saleprice = Integer.parseInt(request.getParameter("saleprice"));
	
	//ordersvo o = new ordersvo(orderid,custid,bookid,saleprice,null);
	ordersvo o = new ordersvo();
	//o.setOrderid(orderid);
	o.setCustid(custid);
	o.setBookid(bookid);
	o.setSaleprice(saleprice);
	
	ordersdao dao = new ordersdao();
	int re = dao.insertOrders(o);
	if(re == 1){
		%>
		�ֹ� ����Ͽ����ϴ�!
		<%
	}else{
		%>
		�ֹ� ��Ͽ� �����Ͽ����ϴ�!
		<% 
	}	


%>
</body>
</html>