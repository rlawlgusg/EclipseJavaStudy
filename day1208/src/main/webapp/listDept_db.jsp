<%@page import="com.sist.vo.DeptVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.dao.DeptDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<meta name="viewport" content="width=device-width,initial-scale=1" >
<title>Insert title here</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
	<table class="table table-hover">
		<thead>
			<tr>
				<th>부서번호</th>
				<th>부서명</th>
				<th>부서위치</th>
			</tr>
		</thead>
		<tbody>
			<%
			DeptDao dao = new DeptDao();
			ArrayList<DeptVO> list = dao.listDept();
			for(DeptVO d: list){
			%>
			<tr>
			<td><%=d.getDno()%></td>
			<td><%=d.getDname()%></td>
			<td><%=d.getDloc()%></td>
			</tr>
			<% 
			}
			%>
		</tbody>
	</table>
	</div>
</body>
</html>