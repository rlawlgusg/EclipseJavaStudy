package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sist.vo.CustomerInfoVO;
import com.sist.vo.customervo;

public class CustomerinfoDAO {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private String user = "*****";
	private String password = "*****";
	
	public ArrayList<String> printCustName() {
		ArrayList<String> name = new ArrayList<String>();
		String sql = "select 이름 from 고객 order by 이름";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				name.add(rs.getString(1));
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
				
			}catch(Exception e) {}
		}
		return name;
	}
	
	
	
	public ArrayList<CustomerInfoVO> printCustInfo(String custName){
		ArrayList<CustomerInfoVO> list = new ArrayList<CustomerInfoVO>();
		String sql = "select 극장이름, 상영관.상영관번호, 영화제목, 날짜, 좌석번호, 가격"
				+ "	from 극장, 상영관, 예약"
				+ "	where 극장.극장번호 = 상영관.극장번호 and"
				+ "	상영관.극장번호 = 예약.극장번호 and"
				+ "	상영관.상영관번호 = 예약.극장번호 and"
				+ "	고객번호 = (select 고객번호 from 고객 where 이름 = ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, custName);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new CustomerInfoVO(rs.getString(1), rs.getInt(2), rs.getString(3) , rs.getDate(4), rs.getInt(5), rs.getInt(6)));
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
				
			}catch(Exception e) {}
		}				
		return list;
	}
}
