package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sist.vo.BookVO;

public class BookDAO {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private String user = "*****";
	private String password = "*****";
	
	public ArrayList<BookVO> listTop3(){
		ArrayList<BookVO> list = new ArrayList<BookVO>();
		String sql = "select * from today_top3";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new BookVO(rs.getString(1), rs.getInt(2)));
			}
			
			
		}catch(Exception e) {
			System.out.println("¿¹¿Ü¹ß»ý:"+e.getMessage());
		}finally {
			try {
				
			}catch(Exception e) {}
		}
		
		
		return list;
	}
	
	
	
}
