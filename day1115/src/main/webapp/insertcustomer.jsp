<%@page import="com.sist.dao.customerDAO"%>
<%@page import="com.sist.dao.customerVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h3>**�� ���**</h3>
	<form action="insertcustomer.jsp" method="post">
	����ȣ : <input type="text" name="custid"> <br>
	���̸� : <input type="text" name="name"> <br>
	���ּ� : <input type="text" name="address"> <br>
	��ȭ��ȣ : <input type="text" name="phone"> <br> <br>
	<input type="submit" value="���">
	<input type="reset" value="���">
	</form>	
	
	<%
	request.setCharacterEncoding("euc-kr");
	if( request.getParameter("custid") != null)
	{		
		int custid  = Integer.parseInt(request.getParameter("custid"));	
		String name  = request.getParameter("name");	
		String address  = request.getParameter("address");	
		String phone  = request.getParameter("phone");	
		customerVO c = new customerVO(custid, name,address,phone);
		customerDAO dao = new customerDAO();
		int re = dao.insertcustomer(c);
		if(re == 1){
			%>
			<br>
		����Ͽ� �����Ͽ����ϴ�
			<% 		
		}else{
			%>
			<br>
		����Ͽ� �����Ͽ����ϴ�	
			<%
		}
	
	}
	%>
	
</body>
</html>