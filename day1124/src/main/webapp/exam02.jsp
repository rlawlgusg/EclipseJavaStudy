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
	<table>
	<tr>
	<td>�����̸�</td>
	<td>��������</td>
	</tr>
	<% 
	String sql = "select publisher, sum(saleprice) from book b, orders o where b.bookid=o.bookid" 
			+ "	group by publisher";
	try{
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			%>		
				<tr>
				<td><%=rs.getString(1)%></td>
				<td><%=rs.getInt(2)%></td>
				</tr>
			<% 	
		}
	}catch(Exception e){
		System.out.println("���ܹ߻�:"+e.getMessage());
	}

	
	ConnectionProvider.close(conn,stmt,rs);
	
	
	%>


</table>

</body>
</html>