<%@page import="com.sist.dao.searchinfoVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.dao.searchinfoDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="searchinfo.jsp" method="post">
	지역명을 입력하세요: <input type="text" name="dloc">
	<input type="submit" value="검색"> 	
	</form>
	
	<%
	request.setCharacterEncoding("euc-kr");
	if(request.getParameter("dloc") != null){
		String dloc = request.getParameter("dloc");
		searchinfoDAO dao = new searchinfoDAO();
		ArrayList<searchinfoVO> list = dao.search(dloc);
		%>
		<table>
		 <tr>
		 <td>사원번호</td>
		 <td>사원이름</td>
		 <td>급여</td>
		 <td>수당</td>
		 <td>실수령액</td>
		 <td>부서번호</td>
		 <td>부서명</td> 
		 </tr>
		<% 
			for(searchinfoVO s:list){
				%>
				 <tr>
				 <td><%=s.getEno() %></td>
				 <td><%=s.getEname() %></td>
				 <td><%=s.getSalary() %></td>
				 <td><%=s.getComm() %></td>
				 <td><%=s.getTotalsalary() %></td>
				 <td><%=s.getDno() %></td>
				 <td><%=s.getDname() %></td> 
				 </tr>
				<% 		
			}
		
		%>
		</table>
		<% 
	}
	

	%>
	
	</form>

</body>
</html>