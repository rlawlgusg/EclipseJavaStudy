<%@page import="com.sist.dao.DeptDao"%>
<%@page import="java.util.ArrayList"%>
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
	//String []data = {"개발1팀","개발2팀","기획팀","영업팀"};
	//ArrayList<String> data = new ArrayList<String>();
	//data.add("개발1팀");
	//data.add("개발2팀");
	//data.add("기획팀");
	//data.add("영업팀");
	
	DeptDao dao = new DeptDao();
	ArrayList<String> data = dao.listDname();
	
	%>
	
	<h2>부서목록</h2>
	<hr>
	<ul>
		<% 
			for(String dname : data){
				%>
				<li><%=dname%></li>	
				<%
			}
		%>	
	</ul>
</body>
</html>