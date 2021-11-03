package com.sist.db;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class DBProduct extends JFrame {

	JTextField jtf_name;	
	JTextField jtf_num;	
	JTextField jtf_amount;	
	JTextField jtf_cost;	
	
	public DBProduct() {
		
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		
		jtf_num = new JTextField(10);
		jtf_name = new JTextField(10);
		jtf_amount = new JTextField(10);
		jtf_cost = new JTextField(10);
		
		p1.add(new JLabel("상품번호"));
		p1.add(jtf_num);
		p1.add(new JLabel("상품명"));
		p1.add(jtf_name);
		p1.add(new JLabel("수량"));
		p1.add(jtf_amount);
		p1.add(new JLabel("단가"));
		p1.add(jtf_cost);
	
		setLayout(new BorderLayout());
		JButton btn1 = new JButton("추가");
		JButton btn2 = new JButton("리셋");
		JButton btn3 = new JButton("닫기");
		p2.add(btn1);
		p2.add(btn2);
		p2.add(btn3);
		add(p1,BorderLayout.CENTER);
		add(p2,BorderLayout.SOUTH);
	
		setTitle("상품");
		setSize(700,100);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				int num = Integer.parseInt(jtf_num.getText());
				String name = jtf_name.getText();
				int amount = Integer.parseInt(jtf_amount.getText());
				int cost = Integer.parseInt(jtf_cost.getText());
				
				try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##sist", "sist");
				Statement stmt = conn.createStatement();
			
				String sql = "insert into product values("+num+","+"'"+name+"'"+","+amount+","+cost+")"; 
				int re = stmt.executeUpdate(sql);
				System.out.println("re:"+re);
				stmt.close();
				conn.close();
				}catch(Exception ex) {
					System.out.println("예외발생:"+ex.getMessage());
				}
			}
		});
	
		btn2.addActionListener(new ActionListener() { //리셋
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jtf_name.setText("");	
				jtf_num.setText("");	
				jtf_amount.setText("");	
				jtf_cost.setText("");	
			}
		});
		
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DBProduct();
	}

}
