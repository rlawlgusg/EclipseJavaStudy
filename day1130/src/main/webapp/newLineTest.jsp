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
		String data = "안녕하세요.<br>반갑습니다.";	
		String data2 = "안녕하세요\n반갑습니다.";
		data2 = data2.replace("\n", "<br>");
	%>
	<%=data%><br>
	<%=data2%>
</body>
</html>