package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sist.vo.BookVO;

public class BookDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String user = "c##madang";
	String password = "madang";
	
	
	//������ �Ű������� ���޹޾� �� ���� ������ ��� ��������� �˻��Ͽ�
	//ArrayList�� ��ȯ�ϴ� �޼ҵ� ����
	public ArrayList<BookVO> searchBook(int price){
		ArrayList<BookVO> list = new ArrayList<BookVO>();
		String sql = "select * from book where price <= ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, price);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new BookVO(rs.getInt(1), rs.getString(2)
									, rs.getString(3), rs.getInt(4)));
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
	
	public ArrayList<BookVO> searchBook(int start, int end){
		ArrayList<BookVO> list = new ArrayList<BookVO>();
		String sql = "select * from book where price between ? and ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new BookVO(rs.getInt(1), rs.getString(2)
						, rs.getString(3), rs.getInt(4)));
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
