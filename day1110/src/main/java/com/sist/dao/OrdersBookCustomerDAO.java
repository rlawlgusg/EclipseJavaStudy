package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sist.vo.OrdersBookCustomerVO;

public class OrdersBookCustomerDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String user = "c##madang";
	String pwd = "madang";
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public int getTotalsaleprice(String name) {
		int total = 0;
		String sql = "select sum(saleprice) from customer c, orders o where c.custid = o.custid and name = ?";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pwd);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			//rs�� ���ϰ��̸� while���� �����ʰ� if�� ����
			if(rs.next()) {
				total = rs.getInt(1);
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
		return total;
	}
	
	
	
	
	//���̸��� �Ű������� ���޹޾� �� ���� �ֹ��� ������ OrdersBookCustomerVO��
	//�����Ͽ� ArrayList�� ��ȯ�ϴ� �޼ҵ带 ���� 
	public ArrayList<OrdersBookCustomerVO> listorders(String name){
		ArrayList<OrdersBookCustomerVO> list = new ArrayList<OrdersBookCustomerVO>();
		String sql = "select c.custid, name, bookname, publisher, price, saleprice, orderdate from book b, orders o , customer c where o.custid = c.custid and b.bookid = o.bookid and c.name = ? order by price desc";		
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pwd);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new OrdersBookCustomerVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getDate(7)));
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
