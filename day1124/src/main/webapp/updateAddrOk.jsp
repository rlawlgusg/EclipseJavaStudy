<%@page import="org.apache.catalina.filters.ExpiresFilter.XServletOutputStream"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.sist.db.ConnectionProvider"%>
<%@page import="java.sql.Connection"%>
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
		int custid = Integer.parseInt(request.getParameter("custid"));
		String address = request.getParameter("address");
		String sql = "update customer set address = ? where custid = ?";	

		try{
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, address);
		pstmt.setInt(2, custid);
		int re = pstmt.executeUpdate();
		if(re == 1){
			%>
			ȸ���� �ּҸ� �����Ͽ����ϴ�
			<% 
		}else{
			%>
			ȸ�� �ּ� ������ �����Ͽ����ϴ�
			<% 
		}
		ConnectionProvider.close(conn, pstmt, null);
	
		}catch(Exception e){
			System.out.println("���ܹ߻�:"+e.getMessage());
		}
		
	%>
	
	
	<hr>
	<a href = "listcustomer.jsp">ȸ�����</a>
	
	
</body>
</html>