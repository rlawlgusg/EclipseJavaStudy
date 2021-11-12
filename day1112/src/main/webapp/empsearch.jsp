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
	직원의 이름을 입력하세요 <input type="text" name="ename">
	근무위치를 입력하세요 <input type="text" name="dloc">
	<input type="submit" value="검색">
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
		<td>직원명</td>
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