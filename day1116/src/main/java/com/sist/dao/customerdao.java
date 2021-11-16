package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sist.vo.customervo;

public class customerdao {
	
		private String driver = "oracle.jdbc.driver.OracleDriver";
		private String url = "jdbc:oracle:thin:@localhost:1521:XE";
		private String user = "c##madang";
		private String password = "madang";
		
		public ArrayList<customervo> listcustomer(){
			ArrayList<customervo> list = new ArrayList<customervo>();
			String sql = "select * from customer";	
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, user, password);
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					list.add(new customervo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
				}
				
			}catch(Exception e) {
				System.out.println("���ܹ߻�:"+e.getMessage());
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

