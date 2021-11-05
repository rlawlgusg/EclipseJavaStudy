package com.sist.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BookDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String user = "c##sist";
	String pwd = "sist";
	
	public int updateBook(BookVo m) {
		int re = -1;
		String sql = "update book set name=?,publisher=?,price=? where no =?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pwd);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getName());
			pstmt.setString(2, m.getPublisher());
			pstmt.setInt(3, m.getPrice());
			pstmt.setInt(4, m.getNo());
			
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
				System.out.println(e.getMessage());
			}
		}
		return re;
	}
	
	public int deleteBook(int no) {
	      int re=-1;
	      String sql = "delete book where no=?";
	      
	      Connection conn=null;
	      PreparedStatement pstmt=null;
	      
	      try {
	         Class.forName(driver);
	         conn = DriverManager.getConnection(url,user,pwd);
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setInt(1,no);
	         
	         re = pstmt.executeUpdate();   
	         
	      }catch(Exception e) {
	         System.out.println("예외발생:"+e.getMessage());
	      }finally{
	         try {
	            if(pstmt != null) {
	               pstmt.close();
	            }
	            if(conn != null) {
	               conn.close();
	            }
	         }catch (Exception e) {
	            
	         }
	      }
	      return re;
	   }
	
	public ArrayList<BookVo> listbook(){
	      ArrayList<BookVo> list = new ArrayList<BookVo>();
	      String sql = "select * from book order by no";
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null; 
	      try {
	         Class.forName(driver);
	         conn = DriverManager.getConnection(url,user,pwd);
	         pstmt = conn.prepareStatement(sql);
	         rs = pstmt.executeQuery(sql);
	         
	         while(rs.next()) {
	            int no = rs.getInt(1);
	            String name = rs.getString(2);
	            String publisher = rs.getString(3);
	            int price = rs.getInt(4);
	   
	            list.add(new BookVo(no,name,publisher,price));
	         }
	         
	      }catch (Exception e) {
	         System.out.println("예외발생:"+e.getMessage());
	      }finally {
	         try{
	            if(rs != null) {
	               rs.close();
	            }
	            if(conn != null) {
	               conn.close();
	            }
	            if(pstmt != null) {
	               pstmt.close();
	            }
	         }catch (Exception e) {
	            // TODO: handle exception
	         }
	      }
	      return list;      
	   }
	
	public int insertBook(BookVo b) {
	      int re=-1;
	      Connection conn= null;
	      PreparedStatement pstmt = null;
	      String sql = "insert into book values(?,?,?,?)";
	      
	      try {
	         
	         Class.forName(driver);
	         conn =DriverManager.getConnection(url,user,pwd);
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setInt(1,   b.getNo());
	         pstmt.setString(2, b.getName());
	         pstmt.setString(3, b.getPublisher());
	         pstmt.setInt(4, b.getPrice());
	         
	         re= pstmt.executeUpdate();
	         if(re==1) {
	            System.out.println("성공하였습니다.");
	         }
	         
	      } catch (Exception e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }finally {
	        try {
	    	  if(conn!=null)
	            conn.close();
	          if(pstmt!=null)
	            pstmt.close();
	        }catch(Exception e) {}
	      }
	      return re;
	   }

	
}
