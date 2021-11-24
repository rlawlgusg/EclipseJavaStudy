<%@page import="oracle.security.o3logon.a"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="org.apache.catalina.filters.ExpiresFilter.XServletOutputStream"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
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
	<td>도서번호</td>
	<td>도서명</td>
	</tr>
	
<%
	String sql = "select bookid, bookname from book";
	 String driver = "oracle.jdbc.driver.OracleDriver";
	 String url = "jdbc:oracle:thin:@localhost:1521:XE";
	 String user = "c##madang";
	 String password = "madang";
	 Connection conn = null;
	 Statement stmt = null;
	 ResultSet rs = null;
	 try{
		    Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				%>
				<tr>
				<td><%=rs.getInt(1) %></td>
				<td><a href="detailbook.jsp?bookid=<%=rs.getInt(1) %>"><%=rs.getString(2)%></a></td>
				</tr>
				
		
				<% 
			}
			if(rs != null){
				rs.close();
			}			
			if(stmt != null){
				stmt.close();
			}
			if(conn != null){
				conn.close();
			}
			
	 }catch(Exception e){
		System.out.println("예외발생:"+e.getMessage());
	}

%>
</table>
</body>
</html>