package com.sist.orders;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
public class OrdersTest extends JFrame {
	
	JTextField custid;
	JTable table;
	Vector colNames;
	Vector<Vector> rowData;
	OrdersDAO dao;
	
	
	public OrdersTest() {
		dao = new OrdersDAO();
		custid = new JTextField(20);
		JButton btn_search = new JButton("검색");
		JButton btn_list = new JButton("목록");
		
		JPanel p1 = new JPanel();
		p1.add(new JLabel("고객번호:"));
		p1.add(custid);
		
		JPanel p2 = new JPanel();
		p2.add(btn_search);
		p2.add(btn_list);
		
		JPanel p3 = new JPanel();
		p3.setLayout(new BorderLayout());
		p3.add(p1,BorderLayout.CENTER);
		p3.add(p2,BorderLayout.SOUTH);
	
		colNames = new Vector();
		colNames.add("주문번호");
		colNames.add("고객번호");
		colNames.add("도서번호");
		colNames.add("할인가격");
		colNames.add("주문날짜");
		rowData = new Vector<Vector>();
		table = new JTable(rowData, colNames);
		JScrollPane jsp = new JScrollPane(table);
		
		setLayout(new BorderLayout());
		add(p3,BorderLayout.CENTER);
		add(jsp,BorderLayout.SOUTH);
		
		setSize(500,600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btn_search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ArrayList<OrdersVO> list = dao.Searchcust(Integer.parseInt(custid.getText()));
				rowData.clear();
				for(OrdersVO ov: list) {
					Vector v = new Vector();
					v.add(ov.getOrderid());
					v.add(ov.getCustid());
					v.add(ov.getBookid());
					v.add(ov.getSaleprice());
					v.add(ov.getOrderdate());
					rowData.add(v);	
				}
				table.updateUI();
			}});
	
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new OrdersTest();
	}

}
