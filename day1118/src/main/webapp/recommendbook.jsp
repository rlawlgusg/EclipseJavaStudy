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
	���� �̸��� �Է��ϼ��� <input type="text" name="name">
	<input type="submit" value="�Է�">
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
	<td>������ȣ</td>
	<td>�����̸�</td>
	<td>���ǻ��</td>
	<td>��������</td>
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