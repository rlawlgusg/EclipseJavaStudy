package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sist.vo.bookvo;

public class bookdao {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private String user = "*****";
	private String password = "*****";
	
	public ArrayList<bookvo> listbook(){
		ArrayList<bookvo> list = new ArrayList<bookvo>();
		String sql = "select * from book";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new bookvo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
			}
			
		}catch(Exception e) {
			System.out.println("¿¹¿Ü¹ß»ý:"+e.getMessage());
		}finally {
			try {
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
