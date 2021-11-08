package com.sist.orders;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class OrdersDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userName = "*****";
	String passWord = "*****";
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	OrdersVO ov; 
	
	public ArrayList<OrdersVO> Searchcust(int customernumber){
		ArrayList<OrdersVO> list = new ArrayList<OrdersVO>();
		String sql = "select * from orders where custid=?";
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userName, passWord);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, customernumber);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int orderid = rs.getInt(1);
				int custid = rs.getInt(2);
				int bookid = rs.getInt(3);
				int saleprice = rs.getInt(4);
				String orderdate = rs.getString(5);
				ov = new OrdersVO(orderid, custid, bookid, saleprice, orderdate);
				list.add(ov);
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
