package com.sist.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

public class BookDAO {
	BookVO bv;
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userName = "c##madang";
	String passWord = "madang";
	//���ǻ���� �Ű������� ���޹޾� �ش� ���ǻ��� ��� ��������� �˻��Ͽ� ArrayList�� ��ȯ
	//������ �Ʒ��� �޼ҵ��� ������ �ϼ��ϰ� 
	//������ ���α׷��� GUI�� ����
	//ȭ�� ����, Ŭ�����̸� �����Ӱ� 
	public ArrayList<BookVO> SearchBook(String keyword){
		ArrayList<BookVO> list = new ArrayList<BookVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userName, passWord);
			String sql = "select * from book where publisher = ? order by price desc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, keyword);
			rs = pstmt.executeQuery();
			
		//	int bookid = 0;
		//	String bookname = "";
		//	String publisher = "";
		//	int price = 0;

			while(rs.next()) {
				int	bookid = rs.getInt(1);
				String	bookname = rs.getString(2);
				String	publisher = rs.getString(3);
				int	price = rs.getInt(4);	
				bv = new BookVO(bookid, bookname, publisher, price);
				list.add(bv);
			}
			
		}catch(Exception e) {
			System.out.println("���ܹ߻�"+e.getMessage());
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
