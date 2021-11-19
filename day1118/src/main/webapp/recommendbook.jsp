<%@page import="com.sist.vo.RecommendBookVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.dao.RecommendBookDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="recommendbook.jsp" method="post">
	고객의 이름을 입력하세요 <input type="text" name="name">
	<input type="submit" value="입력">
	</form>
	<%
	request.setCharacterEncoding("euc-kr");
	if(request.getParameter("name") != null){
		String name = request.getParameter("name");

		RecommendBookDAO dao = new RecommendBookDAO();
		ArrayList<RecommendBookVO> list = dao.recommendbook(name);	
	%>
	<table>
	<tr>
	<td>도서번호</td>
	<td>도서이름</td>
	<td>출판사명</td>
	<td>도서가격</td>
	</tr>
	
	<% 
	for(RecommendBookVO r : list){
		%>
		<tr>
		<td><%=r.getBookid()%></td>
		<td><%=r.getBookname()%></td>
		<td><%=r.getPublisher()%></td>
		<td><%=r.getPrice()%></td>
		</tr>	
		<%
	}
	
	
	
	
	%>
	
	
	
	
	
	</table>
	
	<% 
	
	
	
	
	}
	%>

</body>
</html>