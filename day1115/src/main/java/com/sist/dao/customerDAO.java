package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.sist.vo.customerVO;

public class customerDAO {
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String user = "c##madang";
	String password = "madang";

	Connection conn = null;
	PreparedStatement pstmt = null;
	public int insertcustomer(customerVO c) {
		int re = -1;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement("insert into customer values(?,?,?,?)");
			pstmt.setInt(1, c.getCustid());
			pstmt.setString(2, c.getName());
			pstmt.setString(3, c.getAddress());
			pstmt.setString(4, c.getPhone());
			re = pstmt.executeUpdate();

		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch(Exception e) {}
		}
		
		return re;
	}
	
	
}
