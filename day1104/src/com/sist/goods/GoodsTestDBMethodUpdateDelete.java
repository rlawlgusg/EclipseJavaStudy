package com.sist.goods;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.awt.event.MouseListener;

public class GoodsTestDBMethodUpdateDelete extends JFrame {

	JTextField jtf_no;
	JTextField jtf_item;
	JTextField jtf_qty;
	JTextField jtf_price;
	
	JTable table; 
	Vector colNames; 
	Vector<Vector> rowData; 
	
	//������ ��ǰ��ȣ, ��ǰ�̸�, ����, ������ �Ű������� ���޹޾� �����ͺ��̽��� �����ϴ� �޼ҵ� ����
	public void updateGoods(int no,String item,int qty,int price) {
		String sql = "update goods set item='"+item+"', qty="+qty+", price="+price+" where no="+no;
		Connection conn = null;
		Statement stmt = null;
		try {
			//1.jdbc����̹��� �޸𸮷� �ε���
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2.db������ ������
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##sist", "sist");			//3.statement ��ü�� ����
			//4.�����ͺ��̽������ ������
			stmt = conn.createStatement();
			
			int re = stmt.executeUpdate(sql);
			if(re == 1) {
				System.out.println("��ǰ������ �����Ͽ����ϴ�");
				printGoods();	
			}else {
				System.out.println("��ǰ������ �����Ͽ����ϴ�");
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
			}catch(Exception e) {
				
			}
		}
	
	
	}
	
	
	public void printGoods(){
		rowData.clear();
		String sql = "select * from goods Order by no";
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
				String item = rs.getString(2);
				int qty = rs.getInt(3);
				int price = rs.getInt(4);
				Vector v = new Vector();
				v.add(no);
				v.add(item);
				v.add(qty);
				v.add(price);
				//�� ���͸� rowData�� ����
				rowData.add(v);
				table.updateUI();
			}	
		}catch(Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
		}finally {
			try {
				//����ߴ� �ڿ����� �ݾ���
				if(rs != null) {
					rs.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				if(conn != null) {
					conn.close();
				}		
			}catch(Exception e) {
			}
		}
	}
	
	public void insertGoods(int no,String item,int qty,int price) {
		String sql = "insert into goods values("+no+",'"+item+"',"+qty+","+price+")";
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##sist", "sist");
			stmt = conn.createStatement();
			int re = stmt.executeUpdate(sql);
			if(re == 1) {
				System.out.println("��ǰ��Ͽ� �����Ͽ����ϴ�");
				jtf_no.setText("");
				jtf_item.setText("");
				jtf_qty.setText("");
				jtf_price.setText("");	
				printGoods();	
			}else {
				System.out.println("��ǰ��Ͽ� �����Ͽ����ϴ�");
			}
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
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
	//������ ��ǰ��ȣ�� �Ű������� ���޹޾� �ش��ǰ�� �����ͺ��̽��� �����ϴ� �޼ҵ带 ����
	public void deleteGoods(int no) {
		String sql = "delete goods where no ="+no;
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##sist", "sist");
			stmt = conn.createStatement();
			int re = stmt.executeUpdate(sql);
			if(re == 1) {
				System.out.println("��ǰ�� �����Ͽ����ϴ�");
				printGoods();
				jtf_no.setText("");
				jtf_item.setText("");
				jtf_qty.setText("");
				jtf_price.setText("");	
			}else {
				System.out.println("������ �����Ͽ����ϴ�");
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
			}catch(Exception e) {}
		}	
	}
		
	public GoodsTestDBMethodUpdateDelete() {
		colNames = new Vector<>();
		colNames.add("��ǰ��ȣ");
		colNames.add("��ǰ��");
		colNames.add("����");
		colNames.add("�ܰ�");
		
		rowData = new Vector<Vector>();
		
		table = new JTable(rowData, colNames);
		
		JScrollPane jsp = new JScrollPane(table);
		
		jtf_no = new JTextField(); //��ǰ��ȣ�� �Է¹ޱ� ���� �Է»���
		jtf_item = new JTextField(); //��ǰ���� �Է¹ޱ� ���� �Է»���
		jtf_qty = new JTextField();	 //������ �Է¹ޱ� ���� �Է»���
		jtf_price = new JTextField();	//������ �Է¹ޱ� ���� �Է»���
		
		//�Է»��ڵ�� ������ �Է��ؾ����� �����ϴ� �󺧵��� ��� ���� �г��� ����
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(4,2));
		
		//�󺧰� �Է»���(�ؽ�Ʈ�ʵ�)���� �гο� ���ʴ�� ���� 
		p.add(new JLabel("��ǰ��ȣ:"));
		p.add(jtf_no);
		p.add(new JLabel("��ǰ�̸�:"));
		p.add(jtf_item);
		p.add(new JLabel("��ǰ����:"));
		p.add(jtf_qty);
		p.add(new JLabel("��ǰ�ܰ�:"));
		p.add(jtf_price);
		
		//"�߰�"�۾��� ������ ��ư�� ����
		JButton btn_add = new JButton("�߰�");
		//"���"�۾��� ������ ��ư�� ����
		JButton btn_list = new JButton("���");
		JButton btn_update = new JButton("����");
		JButton btn_delete = new JButton("����");
		
		//��ư���� ���� �г� ����
		JPanel p2 = new JPanel();
		p2.add(btn_add);
		p2.add(btn_list);
		p2.add(btn_update);
		p2.add(btn_delete);
		
		//�Է»��ڵ��� �ִ� �гΰ� ��ư�� �ִ� �г��� ���� �г��� ����
		JPanel p_center = new JPanel();
		p_center.setLayout(new BorderLayout());
		
		p_center.add(p,BorderLayout.CENTER);
		p_center.add(p2,BorderLayout.SOUTH);
		
		//�������� ����� �Է»��ڿ� ��ư�� ��� �ִ� p_center�г��� ����
		add(p_center,BorderLayout.CENTER);
		//���̺��� ��� �ִ� ��ũ������ �������� �Ʒ��ʿ� ����
		add(jsp,BorderLayout.SOUTH);
		
		setSize(800,600);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btn_list.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				printGoods();
			
			}	
		});
		
		btn_add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int no = Integer.parseInt(jtf_no.getText());
				String item = jtf_item.getText();
				int qty = Integer.parseInt(jtf_qty.getText());
				int price = Integer.parseInt(jtf_price.getText());
			
				insertGoods(no,item,qty,price);
				
			}
		});
		btn_update.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//������ư�� ������ ������ ��ǰ�� ��ȣ, �̸�, ���� ������ �ؽ�Ʈ�ʵ�� ���� �о�ͼ�
				//�װ��� �޼ҵ忡�� �����Ͽ� �����ϵ��� ��
				int no = Integer.parseInt(jtf_no.getText());
				String item = jtf_item.getText();
				int qty = Integer.parseInt(jtf_qty.getText());
				int price = Integer.parseInt(jtf_price.getText());
			
				updateGoods(no,item,qty,price);
			}
			
		});
		
		btn_delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int no = Integer.parseInt(jtf_no.getText());
				deleteGoods(no);
			}
			
		});
		
		//���̺� ���콺 �̺�Ʈ�� ����Ͽ� ������ ���� ��ǰ�� ������ ������ �Է»��ڿ� ���
		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				int index = table.getSelectedRow();
				//rowData�� index��°�� ���͸� �������
				Vector vr = rowData.get(index);
				//�� ������ ��Ҹ� ���ʷ� �Է»��ڿ� �����
				jtf_no.setText(vr.get(0)+"");
				jtf_item.setText(vr.get(1)+"");
				jtf_qty.setText(vr.get(2)+"");
				jtf_price.setText(vr.get(3)+"");
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
		
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GoodsTestDBMethodUpdateDelete();
	}

}
