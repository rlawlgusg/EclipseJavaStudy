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
	<h3>**고객 등록**</h3>
	<form action="insertcustomer.jsp" method="post">
	고객번호 : <input type="text" name="custid"> <br>
	고객이름 : <input type="text" name="name"> <br>
	고객주소 : <input type="text" name="address"> <br>
	전화번호 : <input type="text" name="phone"> <br> <br>
	<input type="submit" value="등록">
	<input type="reset" value="취소">
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
		고객등록에 성공하였습니다
			<% 		
		}else{
			%>
			<br>
		고객등록에 실패하였습니다	
			<%
		}
	
	}
	%>
	
</body>
</html>