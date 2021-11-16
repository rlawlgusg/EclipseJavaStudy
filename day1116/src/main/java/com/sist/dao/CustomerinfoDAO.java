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
	private String user = "c##sist";
	private String password = "sist";
	
	public ArrayList<String> printCustName() {
		ArrayList<String> name = new ArrayList<String>();
		String sql = "select �̸� from �� order by �̸�";
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
		return name;
	}
	
	
	
	public ArrayList<CustomerInfoVO> printCustInfo(String custName){
		ArrayList<CustomerInfoVO> list = new ArrayList<CustomerInfoVO>();
		String sql = "select �����̸�, �󿵰�.�󿵰���ȣ, ��ȭ����, ��¥, �¼���ȣ, ����"
				+ "	from ����, �󿵰�, ����"
				+ "	where ����.�����ȣ = �󿵰�.�����ȣ and"
				+ "	�󿵰�.�����ȣ = ����.�����ȣ and"
				+ "	�󿵰�.�󿵰���ȣ = ����.�����ȣ and"
				+ "	����ȣ = (select ����ȣ from �� where �̸� = ?)";
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
