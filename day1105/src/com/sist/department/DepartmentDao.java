package com.sist.department;
//추가,목록,수정,삭제 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DepartmentDao {
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String user = "*****";
	String pwd = "******";
	int re;

	public int InsertInfo(DepartmentVo dv) {
		re = -1;
		String sql = "insert into department values(?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pwd);
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, dv.getNo());
			pstmt.setString(2, dv.getName());
			pstmt.setString(3, dv.getSite());

			re = pstmt.executeUpdate();
				
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}finally {
			try {
				if(pstmt != null) {
				pstmt.close();
				}
				if(conn != null) {
				conn.close();
				}
			}catch(Exception e) {
				System.out.println("예외발생"+e.getMessage());
			}
		}
		return re;
	}	

	public ArrayList<DepartmentVo> listInfo(){
		
		ArrayList<DepartmentVo> list = new ArrayList<DepartmentVo>();
		String sql = "select * from department Order by no";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);			
			conn = DriverManager.getConnection(url, user, pwd);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int no = rs.getInt(1);
				String name = rs.getString(2);
				String site = rs.getString(3);
				DepartmentVo dv = new DepartmentVo(no, name, site);
				list.add(dv);	
			}
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
				if(rs != null) {
					rs.close();
				}
			}catch(Exception e) {
				System.out.println("예외발생:"+e.getMessage());
			}
		}	
		return list;
	}	
	
	public int UpdateInfo(DepartmentVo dv) {
		re = -1;
		String sql = "update department set name=?,site=? where no=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pwd);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dv.getName());
			pstmt.setString(2, dv.getSite());
			pstmt.setInt(3, dv.getNo());
			
			re = pstmt.executeUpdate();
		
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch(Exception e) {
				System.out.println("예외발생:"+e.getMessage());
			}
		}
		return re;
	}
	
	public int DeleteInfo(int no) {
		re = -1;
		String sql = "delete department where no = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pwd);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			re = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch(Exception e) {
				System.out.println("예외발생:"+e.getMessage());
			}
		}	
		return re;
	}	
	
}
	
