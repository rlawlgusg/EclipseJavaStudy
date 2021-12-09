package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.vo.DeptVO;
import com.sist.vo.goodsVO;

public class goodsDao {
	public ArrayList<goodsVO> listGoods(){
		String driver="oracle.jdbc.driver.OracleDriver";
		String user="c##madang";
		String pwd="madang";
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<goodsVO> list = new ArrayList<goodsVO>();
		String sql = "select * from goods";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pwd);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				list.add(new goodsVO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5)));
			}
		}catch(Exception e){
			System.out.println("예외발생"+e.getMessage());
		}finally {
			try {
			if(rs != null) {
				rs.close();
			}
			if(stmt != null) {
				stmt.close();
			}
			if(conn != null) {
				conn.close();
			}
			}catch(Exception e) {}
		}
		return list;
		
	}
}
