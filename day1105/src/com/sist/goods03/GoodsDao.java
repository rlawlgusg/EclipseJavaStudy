package com.sist.goods03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

import oracle.net.aso.h;

public class GoodsDao {
		//데이터베이스에 접근하여 모든 상품목록을 읽어와서 반환하는 메소드 정의
		//select * from goods
		//상품레코드 하나하나를 GoodsVo로 포장하고
		//이것들을 모두 ArrayList에 담아서 반환하려고 함
		public ArrayList<GoodsVo> listGoods(){
			ArrayList<GoodsVo> list = new ArrayList<GoodsVo>();
			String sql = "select * from goods Order by no";
			Connection conn = null;  
			PreparedStatement pstmt = null;
			ResultSet rs = null;  
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##sist", "sist");
				pstmt = conn.prepareStatement(sql);		
				rs = pstmt.executeQuery();
				while(rs.next()) {	
					int no = rs.getInt(1);
					String item = rs.getString(2);
					int qty = rs.getInt(3);
					int price = rs.getInt(4);
					//레코드의 내용을 GoodsVo객체로 만들어 list에 담음
					GoodsVo g = new GoodsVo(no, item, qty, price);
					list.add(g);
					//list.add(new GoodsVo(no,item,qty,price));

				}	
			}catch(Exception e) {
				System.out.println("예외발생:"+e.getMessage());
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
				}catch(Exception e) {
				}
			}
			
			return list;
		}
	
		public int updateGoods(GoodsVo g) {
			int re = -1;
			String sql = "update goods set item=?,qty=?,price=? where no=?";
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##sist", "sist");		
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, g.getItem()); 
				pstmt.setInt(2, g.getQty()); 
				pstmt.setInt(3, g.getPrice()); 
				pstmt.setInt(4, g.getNo()); 

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
				}catch(Exception e) {			
				}
			}
			return re;
		}
		
		public int insertGoods(GoodsVo g) {
			int re = -1;
			String sql = "insert into goods values(?,?,?,?)";
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##sist", "sist");
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, g.getNo());
				pstmt.setString(2, g.getItem());
				pstmt.setInt(3, g.getQty());
				pstmt.setInt(4, g.getPrice());
				
				re = pstmt.executeUpdate();
				
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
			return re;
		}
		
		public int deleteGoods(int no) {
			int re = -1;
			String sql = "delete goods where no =?";
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##sist", "sist");
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, no);
				
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
