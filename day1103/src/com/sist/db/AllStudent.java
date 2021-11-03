package com.sist.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.BorderLayout;
public class AllStudent extends JFrame{
	
	JTextArea jta;
	
	public AllStudent() {

		jta = new JTextArea();

		try {
			String sql = "select * from student";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##sist", "sist");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
			String name = rs.getString(1);
			int kor = rs.getInt(2);
			int eng = rs.getInt(3);
			int math = rs.getInt(4);
			
			String result = "�̸� "+name+" ���� "+ kor +" ���� "+ eng +" ���� "+ math+" \n ";
			jta.append(result); 
			}
	
			add(jta,BorderLayout.CENTER);

			setSize(400,300);
			setVisible(true);
			
		
			rs.close();
			stmt.close();
			conn.close();

			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			
		}catch(Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AllStudent();
		
		
		
	}

}
