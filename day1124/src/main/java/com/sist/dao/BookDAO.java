package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.vo.BookVO;

public class BookDAO {
	String sql = "select bookid, bookname from book";
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String user = "c##madang";
	String password = "madang";
	
	 
	//��� ���� ����� ��ȯ�ϴ� �޼ҵ�
	public ArrayList<BookVO> listBook(){
		ArrayList<BookVO> list = new ArrayList<BookVO>();
		String sql = "select * from book";
		 Connection conn = null;
		 Statement stmt = null;
		 ResultSet rs = null;
		try {
			 Class.forName(driver);
			 conn = DriverManager.getConnection(url, user, password);
			 stmt = conn.prepareStatement(sql);
			 rs = stmt.executeQuery(sql);
				while(rs.next()) {
					list.add(new BookVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
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
				
		} catch (Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
		} 
		
		return list;
	}
	
	//������ȣ�� �Ű������� ���޹޾� �ش� ������ ��ȯ�ϴ� �޼ҵ�
	public BookVO getBook(int bookid) {
		BookVO b = null;
		String sql = "select * from book where bookid = ?";
		try { 
		 Connection conn = null;
		 PreparedStatement pstmt = null;
		 ResultSet rs = null;
		 Class.forName(driver);
		 conn = DriverManager.getConnection(url, user, password);
		 pstmt = conn.prepareStatement(sql);
		 pstmt.setInt(1, bookid);
		 rs = pstmt.executeQuery();
			if(rs.next()) {
				b = new BookVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
			}
		 
		} catch (Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
		}
		
		
		return b;
	}
	
}
