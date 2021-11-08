package com.sist.goods02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class GoodsDao {
	
		public void updateGoods(int no,String item,int qty,int price) {
			String sql = "update goods set item=?,qty=?,price=? where no=?";
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "*****", "*****");		
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, item); 
				pstmt.setInt(2, qty); 
				pstmt.setInt(3, price); 
				pstmt.setInt(4, no); 

				int re = pstmt.executeUpdate(); 
				if(re == 1) {
					System.out.println("상품수정에 성공하였습니다");
				}else {
					System.out.println("상품수정에 실패하였습니다");
				}
				
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
				}catch(Exception e) {			
				}
			}
		}
		
		public void insertGoods(int no,String item,int qty,int price) {
			String sql = "insert into goods values(?,?,?,?)";
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##sist", "sist");
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, no);
				pstmt.setString(2, item);
				pstmt.setInt(3, qty);
				pstmt.setInt(4, price);
				
				int re = pstmt.executeUpdate();
				if(re == 1) {
					System.out.println("상품등록에 성공하였습니다");
				}else {
					System.out.println("상품등록에 실패하였습니다");
				}
			}catch(Exception ex) {
				System.out.println(ex.getMessage());
			}finally {
				try {		
					if(pstmt != null) {
					pstmt.close();
					}
					if(conn != null) {
					conn.close();
					}
				} catch (Exception ex) {}				
			}
		}
		public void deleteGoods(int no) {
			String sql = "delete goods where no =?";
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##sist", "sist");
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, no);
				int re = pstmt.executeUpdate();
				if(re == 1) {
					System.out.println("상품을 삭제하였습니다");
				}else {
					System.out.println("삭제에 실패하였습니다");
				}
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
		}
	
}
