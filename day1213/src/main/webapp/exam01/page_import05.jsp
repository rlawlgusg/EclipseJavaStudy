<%@page import="java.util.*"%>
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
		HashSet set = new HashSet();
		set.add(10);
		set.add(20);
		set.add(10);
		set.add(20);
		ArrayList list = new ArrayList();
		list.add("사과");
		list.add("수박");
		
		Date today = new Date();
	%>
	list : <%=	list	%> <br>
	today : <%=	today %> <br>
	set : <%= set %>
</body>
</html>