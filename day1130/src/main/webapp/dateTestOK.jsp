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
		String birthDate = request.getParameter("birthDate");
		String hireDate = request.getParameter("hireDate");
	%>
	���� : <%=birthDate%> <br>
	�Ի��� : <%=hireDate %> 

</body>
</html>