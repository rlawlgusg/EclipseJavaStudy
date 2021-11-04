
package com.sist.memberDB;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MemberTestDB extends JFrame {
	JTextField jtf_no;
	JTextField jtf_name;
	JTextField jtf_addr;
	JTextField jtf_age;
	JTextField jtf_phone;
	JTable table; 
	Vector colNames; 
	Vector<Vector> rowData;
	public MemberTestDB() {
		
		jtf_no = new JTextField();
		jtf_name = new JTextField();
		jtf_addr = new JTextField();
		jtf_age = new JTextField();
		jtf_phone = new JTextField();
		
		JPanel p = new JPanel();
		JPanel p2 = new JPanel();
		
		p.setLayout(new GridLayout(5,2));
		p.add(new JLabel("ȸ����ȣ:"));
		p.add(jtf_no);
		p.add(new JLabel("ȸ���̸�:"));
		p.add(jtf_name);
		p.add(new JLabel("ȸ���ּ�:"));
		p.add(jtf_addr);
		p.add(new JLabel("ȸ������:"));
		p.add(jtf_age);
		p.add(new JLabel("��ȭ��ȣ:"));
		p.add(jtf_phone);
	
		JButton btn_add = new JButton("�߰�");
		JButton btn_list = new JButton("���");
		JButton btn_update = new JButton("����");
		JButton btn_delete = new JButton("����");
		
		p2.add(btn_add);
		p2.add(btn_list);
		p2.add(btn_update);
		p2.add(btn_delete);

		JPanel p_center = new JPanel();
		p_center.setLayout(new BorderLayout());
		p_center.add(p,BorderLayout.CENTER);
		p_center.add(p2,BorderLayout.SOUTH);
		
		colNames = new Vector<>();
		colNames.add("ȸ����ȣ");
		colNames.add("ȸ���̸�");
		colNames.add("ȸ���ּ�");
		colNames.add("ȸ������");
		colNames.add("��ȭ��ȣ");
		
		rowData = new Vector<Vector>();
	
		table = new JTable(rowData, colNames);
		JScrollPane jsp = new JScrollPane(table);
		
		add(p_center,BorderLayout.CENTER);
		add(jsp,BorderLayout.SOUTH);
		
		setSize(800,600);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btn_add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//���߿� �߰�
				int no = Integer.parseInt(jtf_no.getText());
				String name = jtf_name.getText();
				String addr = jtf_addr.getText();
				int age = Integer.parseInt(jtf_age.getText());
				String phone = jtf_phone.getText();
				insertMember(no, name, addr, age, phone);
			}
		});
		
		btn_list.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				printMember();
			}
		});
	
	
	}

	
	public void insertMember(int no, String name, String addr, int age, String phone) {
		String sql = "insert into Member values("+no+",'"+name+"','"+addr+"',"+age+",'"+phone+"')";
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##sist", "sist");
			stmt = conn.createStatement();
			int re = stmt.executeUpdate(sql);
			if(re == 1) {
				System.out.println("ȸ����Ͽ� �����Ͽ����ϴ�");
				jtf_no.setText("");
				jtf_name.setText("");
				jtf_addr.setText("");
				jtf_age.setText("");	
				jtf_phone.setText("");		
			}
		}catch(Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
		}finally {
			try {		
				if(stmt != null) {
				stmt.close();
				}
				if(conn != null) {
				conn.close();
				}
			} catch (Exception ex) {}				
		}
	}
	public void printMember() {
		rowData.clear();
		String sql = "select * from member order by no";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##sist", "sist");
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				while(rs.next()) {
					int no = rs.getInt(1);
					String name = rs.getString(2);
					String addr = rs.getString(3);
					int age = rs.getInt(4);
					String phone = rs.getString(5);
					Vector v = new Vector();
					v.add(no);
					v.add(name);
					v.add(addr);
					v.add(age);
					v.add(phone);
					rowData.add(v);
					table.updateUI();
				}
				
			}catch(Exception e) {
				System.out.println("���ܹ߻�:"+e.getMessage());
			}finally {
				try {
					if(conn != null) {
					conn.close();
					}
					if(stmt != null) {
					stmt.close();
					}
				}catch(Exception e) {
					System.out.println("���ܹ߻�:"+e.getMessage());
				}
			}
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new  MemberTestDB();
	}

}

//ȸ����ȣ ȸ���̸� �ּ� ���� ��ȭ��ȣ�� �����ϱ� ���� �����ͺ��̽� ���̺��� ����
//CRUD�� ������ ���α׷� �ۼ� 

