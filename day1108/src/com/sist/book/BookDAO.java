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
	//출판사명을 매개변수로 전달받아 해당 출판사의 모든 도서목록을 검색하여 ArrayList로 반환
	//팀별로 아래의 메소드의 내용을 완성하고 
	//좀전의 프로그램을 GUI로 수정
	//화면 구성, 클래스이름 자유롭게 
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
			System.out.println("예외발생"+e.getMessage());
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
