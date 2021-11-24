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
		String publisher = request.getParameter("publisher");
		String sql = "delete book100 where publisher = ?";
		
		try{
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, publisher);
		int re = pstmt.executeUpdate();
		ConnectionProvider.close(conn, pstmt, null);
		if(re >= 1){
			out.print("삭제 성공");
		}else{
			out.print("삭제 실패");	
		}
		
	}catch(Exception e){
		System.out.println("예외발생:"+e.getMessage());		
	}		
%>
</body>
</html>