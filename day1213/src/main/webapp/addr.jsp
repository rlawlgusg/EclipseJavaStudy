<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	이름 : 홍길동
	<jsp:include page="addr.jsp">
		<jsp:param value='<%=URLEncoder.encode("서울시 마포구 서교동") %>' name="data"/>
	</jsp:include>
</body>
</html>