<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="person" class="com.sist.vo.Person" scope="request"/>
	
	<p>아이디: ><%=person.getId() %>
	이름: ><%=person.getName() %></p>
	<%
		person.setId(20220001);
		person.setName("김유신");
	%>
	
	<jsp:include page="useBeanTest03.jsp"></jsp:include>
	
</body>
</html>