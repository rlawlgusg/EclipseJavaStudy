<%@page import="com.sist.vo.empVO"%>
<%@page import="com.sist.dao.empDAO"%>
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
	<h3>�������</h3>
	<% 
	empDAO dao = new empDAO();
	ArrayList<String> name = dao.listmgrName();
	%>
	<form action="Searchemp.jsp" method="post">
	�������̸�: <select name="mgrName">
	
	<%for(String mgrName:name){
		%>
		<option value="<%=mgrName%>"><%=mgrName%></option>
		<% 
	} %>
	
	</select>
	�ٹ�������: <input type="text" name="working"> <br>
	<input type="submit" value="�˻�">
	</form>
	<% 
	request.setCharacterEncoding("euc-kr");
	if(request.getParameter("mgrName") != null){
		String mgrName = request.getParameter("mgrName");
		int working = Integer.parseInt(request.getParameter("working"));
	//	empDAO dao = new empDAO();
		ArrayList<empVO> list = dao.searchemp(mgrName,working);
		%>	
		
		<table border="1">
		<tr>
		<td>�����ȣ</td>
		<td>�����</td>
		<td>�Ի���</td>
		<td>����</td>
		<td>�ֹι�ȣ</td>
		<td>���̵�</td>
		</tr>
		
		<% 
		for(empVO e : list){
			%>
			<tr>
			<td><%=e.getEno()%></td>
			<td><%=e.getEname()%></td>
			<td><%=e.getHirdate()%></td>
			<td><%=e.getAnnualsalary()%></td>
			<td><%=e.getJumin()%></td>
			<td><%=e.getId()%></td>
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