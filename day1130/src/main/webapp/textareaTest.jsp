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
		request.setCharacterEncoding("euc-kr");
		String info = request.getParameter("info");
		String info2 = info.replace("\n", "<br>");
	%>
	�Է��� ������ ������ �����ϴ� <br>
	<%= info2 %>
	<hr>
	<textarea rows="5" cols="60" readonly="readonly"><%=info%></textarea>
	
	
	
</body>
</html>