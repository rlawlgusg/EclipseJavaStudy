package com.sist.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class DBProductRead extends JFrame{
	ArrayList<String> contents [];
	public DBProductRead() {
		String sql = "select * from product";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##sist", "sist");
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			//adflskdjfljdslk
					 {rs.getInt(1)},
										{rs.getString(2)},
										{rs.getInt(3)},
										{rs.getInt(4)}
										};	
		
	
		String title [] = {"상품번호","상품이름","수량","단가"};
		
	//	JTable table = new JTable(title, contents);
		JScrollPane p = new JScrollPane(table);
		
		setSize(400,300);
		setVisible(true);
	
		
		
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DBProductRead();
	}

}
