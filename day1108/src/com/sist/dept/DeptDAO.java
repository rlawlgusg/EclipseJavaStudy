package com.sist.dept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

//DAO:Database Access Object
//	  �����ͺ��̽� ���̺� �����Ͽ� �ڷḦ �߰�,�б�,����,������ ����ϴ� ��ü
public class DeptDAO {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private String userName = "c##sist";
	private String passWord = "sist";
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//�����ͺ��̽� ���̺�(dept)�� ���ڵ带 �߰��ϴ� �޼ҵ带 ����
	public int insert(DeptVO d) {
		int re = -1;
		String sql = "insert into dept values(?,?,?)";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userName, passWord);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, d.getDno());
			pstmt.setString(2, d.getDname());
			pstmt.setString(3, d.getDloc());
			re = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
		}finally{
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
		
	//�����ͺ��̽� ���̺�(dept)�� ���ڵ带 �����ϴ� �޼ҵ带 ����
	public int update(DeptVO d) {
		int re = -1;
		String sql = "update dept set dname=?,dloc=? where dno=?";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userName, passWord);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, d.getDname());
			pstmt.setString(2, d.getDloc());
			pstmt.setInt(3, d.getDno());
			re = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("���ܹ߻�"+e.getMessage());
		}finally{
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
	//�����ͺ��̽� ���̺�(dept)�� ���ڵ带 �����ϴ� �޼ҵ带 ����
	public int delete(int dno) {
		int re = -1;
		String sql = "delete depte where no=?";
		try {
			conn = DriverManager.getConnection(url, userName, passWord);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dno);	
		}catch(Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
		}finally{
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
	//�����ͺ��̽� ���̺�(dept)�� ���ڵ带 �о���� �޼ҵ带 ����
	public ArrayList<DeptVO> listAll(){
		ArrayList<DeptVO> list = new ArrayList<DeptVO>();
		String sql = "select * from dept";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userName, passWord);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			//ResultSet�� �о��(�˻���) ��� ���ڵ���� list�� ����
			while(rs.next()) {
			//	int dno = rs.getInt(1);
			//	String dname = rs.getString(2);
			//	String dloc = rs.getString(3);
				
			//	DeptVO d = new DeptVO();
			//	d.setDno(dno);
			//	d.setDname(dname);
			//	d.setDloc(dloc);
			//	DeptVO d = new DeptVO(dno, dname, dloc);
			//	list.add(d);
				
			//	list.add(new DeptVO(dno, dname, dloc));
				list.add(new DeptVO(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		}catch(Exception e) {
			System.out.println("���ܹ߻�"+e.getMessage());
		}finally{
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
	
	
	
	
	
}
