package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.sist.vo.searchinfoVO;

public class searchinfoDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String user = "*****";
	String pwd = "*****";
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public ArrayList<searchinfoVO> search(String dloc){
		ArrayList<searchinfoVO> list = new ArrayList<searchinfoVO>();
		String sql = "select eno, ename, salary, comm, salary+comm, d.dno, dname from dept d, emp e where d.dno = e.dno and dloc = ? order by dname , ename";
		try {
		Class.forName(driver);
		conn = DriverManager.getConnection(url, user, pwd);
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, dloc);
		rs = pstmt.executeQuery();		
		while(rs.next()) {
			list.add(new searchinfoVO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getString(7)));
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
