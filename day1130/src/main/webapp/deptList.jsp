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
	//String []data = {"����1��","����2��","��ȹ��","������"};
	//ArrayList<String> data = new ArrayList<String>();
	//data.add("����1��");
	//data.add("����2��");
	//data.add("��ȹ��");
	//data.add("������");
	
	DeptDao dao = new DeptDao();
	ArrayList<String> data = dao.listDname();
	
	%>
	
	<h2>�μ����</h2>
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