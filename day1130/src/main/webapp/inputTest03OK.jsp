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
		String []interest = request.getParameterValues("interest");
		for(String data:interest){
			%>
			<%=data%><br>
			<% 
		}
	%>
	
</body>
</html>