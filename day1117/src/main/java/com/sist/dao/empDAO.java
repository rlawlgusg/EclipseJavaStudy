package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sist.vo.empVO;

public class empDAO {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private String user = "*****";
	private String password = "*****";
	
	public ArrayList<String> listmgrName(){
		ArrayList<String> list = new ArrayList<String>();
		String sql = "select distinct m.ename from emp e, emp m where e.mgr = m.eno";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(rs.getString(1));
			}
			
		}catch(Exception e) {
			System.out.println("¿¹¿Ü¹ß»ý:"+e.getMessage());
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
	
	public ArrayList<empVO> searchemp(String mgrName, int working){
		ArrayList<empVO> list = new ArrayList<empVO>();
		String sql = "select e.eno,e.ename,e.hirdate,(e.salary+e.comm)*12, rpad(substr(e.jumin,1,8),14,'*'), substr(e.email,1,instr(e.email,'@')-1)"
				+ " from emp e, emp m"
				+ " where e.mgr = m.eno and"
				+ " m.ename = ? and"
				+ " months_between(sysdate,e.hirdate) >= ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mgrName);
			pstmt.setInt(2, working);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new empVO(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getInt(4), rs.getString(5), rs.getString(6)));
			}
			
		}catch(Exception e) {
			System.out.println("¿¹¿Ü¹ß»ý:"+e.getMessage());
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
	
	
	
	
	

