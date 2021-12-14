<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="calc" class="com.sist.util.Calculator"/>
	<%
		int m = calc.process(5);
	%>
	5의 3제곱 : <%=m %>
</body>
</html>