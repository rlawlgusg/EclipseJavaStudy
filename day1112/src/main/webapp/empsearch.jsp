<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.dao.EMPDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="empsearch.jsp" method="post">
	������ �̸��� �Է��ϼ��� <input type="text" name="ename">
	�ٹ���ġ�� �Է��ϼ��� <input type="text" name="dloc">
	<input type="submit" value="�˻�">
	</form>
	
	<% 
	request.setCharacterEncoding("euc-kr");
	if(request.getParameter("ename") != null ){
		String ename = request.getParameter("ename");
		String dloc =  request.getParameter("dloc");
		EMPDao dao = new EMPDao();
		ArrayList<String> list  = dao.empsearch(ename, dloc);
		
		%>
		<table >
		<tr>
		<td>������</td>
		</tr>
		
		<% 
			for(String emp : list){
				%>
				<table>
				<tr>
				<td><%=emp %></td>
				</tr>
						
				<% 
			}
		%>
		
		
		</table>
	
		
		
		<% 
	}
	
	%>
	
	
	
	
	
</body>
</html>