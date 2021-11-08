package com.sist.prestatement;

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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String id = "*****";
	String pw = "*****";
	Connection conn = null;
	PreparedStatement ps = null;
	public void updateGoods(int no,String item,int qty,int price) {
		String sql = "update goods set item='"+item+"', qty="+qty+", price="+price+" where no="+no;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, id, pw);			
			ps = conn.prepareStatement(sql);
	
			int re = ps.executeUpdate();
			if(re == 1) {
				System.out.println("상품수정에 성공하였습니다");
				printGoods();	
			}else {
				System.out.println("상품수정에 실패하였습니다");
			}
			
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}finally {
				try {
					if(ps != null) {
						ps.close();
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
		ResultSet rs = null;  
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, id, pw);
			ps = conn.prepareStatement(sql);			
			rs = ps.executeQuery(sql);
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
				rowData.add(v);
				table.updateUI();
			}	
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(ps != null) {
					ps.close();
				}
				if(conn != null) {
					conn.close();
				}		
			}catch(Exception e) {
			}
		}
	}
	
	public void insertGoods(int no,String item,int qty,int price) {
		String sql = "insert into goods(no,item,qty,price) values(?,?,?,?)"; //수정했당 
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, id, pw);
			ps = conn.prepareStatement(sql);
			ps.setInt(1, no);
			ps.setString(2, item);
			ps.setInt(3, qty);
			ps.setInt(4, price);
			int re = ps.executeUpdate();
			if(re == 1) {
				System.out.println("상품등록에 성공하였습니다");
				jtf_no.setText("");
				jtf_item.setText("");
				jtf_qty.setText("");
				jtf_price.setText("");	
				printGoods();	
			}else {
				System.out.println("상품등록에 실패하였습니다");
			}
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}finally {
			try {		
				if(ps != null) {
					ps.close();
				}
				if(conn != null) {
				conn.close();
				}
			} catch (Exception ex) {}				
		}
	}
	public void deleteGoods(int no) {
		String sql = "delete goods where no ="+no;
		try {
			
			int re = ps.executeUpdate();
			if(re == 1) {
				System.out.println("상품을 삭제하였습니다");
				printGoods();
				jtf_no.setText("");
				jtf_item.setText("");
				jtf_qty.setText("");
				jtf_price.setText("");	
			}else {
				System.out.println("삭제에 실패하였습니다");
			}
			
			
			
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}finally {
			try {
				if(ps != null) {
					ps.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch(Exception e) {}
		}	
	}
		
	public GoodsTestDBMethodUpdateDelete() {
		colNames = new Vector<>();
		colNames.add("상품번호");
		colNames.add("상품명");
		colNames.add("수량");
		colNames.add("단가");
		
		rowData = new Vector<Vector>();
		
		table = new JTable(rowData, colNames);
		
		JScrollPane jsp = new JScrollPane(table);
		
		jtf_no = new JTextField(); 
		jtf_item = new JTextField(); 
		jtf_qty = new JTextField();	 
		jtf_price = new JTextField();	
		
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(4,2));
		 
		p.add(new JLabel("상품번호:"));
		p.add(jtf_no);
		p.add(new JLabel("상품이름:"));
		p.add(jtf_item);
		p.add(new JLabel("상품수량:"));
		p.add(jtf_qty);
		p.add(new JLabel("상품단가:"));
		p.add(jtf_price);
		
		JButton btn_add = new JButton("추가");
		JButton btn_list = new JButton("목록");
		JButton btn_update = new JButton("수정");
		JButton btn_delete = new JButton("삭제");
		
		JPanel p2 = new JPanel();
		p2.add(btn_add);
		p2.add(btn_list);
		p2.add(btn_update);
		p2.add(btn_delete);
		
		JPanel p_center = new JPanel();
		p_center.setLayout(new BorderLayout());
		
		p_center.add(p,BorderLayout.CENTER);
		p_center.add(p2,BorderLayout.SOUTH);
		
		add(p_center,BorderLayout.CENTER);
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
		
		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				int index = table.getSelectedRow();
				Vector vr = rowData.get(index);
				jtf_no.setText(vr.get(0)+"");
				jtf_item.setText(vr.get(1)+"");
				jtf_qty.setText(vr.get(2)+"");
				jtf_price.setText(vr.get(3)+"");
			}
			public void mouseClicked(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			
		});
		
		
		
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GoodsTestDBMethodUpdateDelete();
	}

}
