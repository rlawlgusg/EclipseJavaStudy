package com.sist.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sist.goods03.GoodsVo;

public class MemberDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String id = "c##sist";
	String pw = "sist";
	
	public int insertMember(MemberVo m) {
		int re = -1;
		String sql = "insert into member values(?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pw);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, m.getNo());
			pstmt.setString(2, m.getName());
			pstmt.setString(3, m.getAddr());
			pstmt.setInt(4, m.getAge());
			pstmt.setString(5, m.getPhone());
			
			re = pstmt.executeUpdate();
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}finally {
			try {		
				if(pstmt != null) {
				pstmt.close();
				}
				if(conn != null) {
				conn.close();
				}
			} catch (Exception ex) {}				
		}
		return re;
	}
	
	public int updateMember(MemberVo m) {
		int re = -1;
		String sql = "update member set name=?,addr=?,age=?,phone=? where no =?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pw);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getName());
			pstmt.setString(2, m.getAddr());
			pstmt.setInt(3, m.getAge());
			pstmt.setString(4, m.getPhone());
			pstmt.setInt(5, m.getNo());
			
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
				System.out.println(e.getMessage());
			}
		}
		return re;
	}
	
	public int deleteMember(int no) {
		int re = -1;
		String sql = "delete member where no = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pw);
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
	
	public ArrayList<MemberVo> listMember(){
		ArrayList<MemberVo> list = new ArrayList<MemberVo>();		
		String sql = "select * from member order by no";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			
			while(rs.next()) {
				int no = rs.getInt(1);
				String name = rs.getString(2);
				String addr = rs.getString(3);
				int age = rs.getInt(4);
				String phone = rs.getString(5);
				MemberVo m = new MemberVo(no, name, addr, age, phone);
				list.add(m);
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
	
	
	
	
	

