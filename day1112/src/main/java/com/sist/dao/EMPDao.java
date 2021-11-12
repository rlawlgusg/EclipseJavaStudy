package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EMPDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String user = "c##madang";
	String password = "madang";
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public ArrayList<String> empsearch(String ename, String dloc){
		ArrayList<String> list  = new ArrayList<String>();
		String sql = "select ename from emp where dno in (  select dno from dept where dno = (select dno from emp where ename in ?) or dloc = ? )";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ename);
			pstmt.setString(2, dloc);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(rs.getString(1));
			}
			
		}catch(Exception e) {
			
		}finally {
			try{
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
				
			}catch(Exception e) {}
			
		}
		
		
		return list;
	}
	
}
