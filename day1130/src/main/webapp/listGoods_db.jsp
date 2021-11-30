<%@page import="com.sist.dao.GoodsDao"%>
<%@page import="com.sist.vo.GoodsVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
		<h2>상품목록</h2>
		<table border="1">
		<thead>
		<th>상품번호</th>
		<th>상품명</th>
		<th>가격</th>
		<th>수량</th>
		<th>이미지</th>
		</thead>
		<%
		GoodsDao dao = new GoodsDao();
		ArrayList<GoodsVO> list = dao.listGoods();
		for(GoodsVO g: list){
			%>
			<tbody>
			<tr>
			<td><%=g.getNo()%></td>
			<td><%=g.getName()%></td>
			<td><%=g.getPrice()%></td>
			<td><%=g.getQty()%></td>
			<td><img src="images/<%=g.getFname()%>" width="50" height="50"> </td>
			</tr>
			</tbody>
			<% 
		}
		
		%>
		
		
	

	</table>
</body>
</html>