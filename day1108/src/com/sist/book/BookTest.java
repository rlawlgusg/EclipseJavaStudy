package com.sist.book;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class BookTest extends JFrame{
	
	JTextField search;
	JTable table;
	Vector colNames;
	Vector<Vector> rowData;
	BookDAO dao;
	
	public BookTest() {
		dao = new BookDAO();
		
		search = new JTextField(20);
		JPanel p1 = new JPanel();
		p1.add(new JLabel("출판사 검색"));	
		p1.add(search);	
		
		JButton btn_search = new JButton("검색");
		JButton btn_list = new JButton("목록");
		JPanel p2 = new JPanel();
		p2.add(btn_search);
		p2.add(btn_list);
		
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		p.add(p1,BorderLayout.CENTER);
		p.add(p2,BorderLayout.SOUTH);
		
		rowData = new Vector<Vector>();
		colNames = new Vector();
		colNames.add("도서번호");
		colNames.add("도서이름");
		colNames.add("출판사명");
		colNames.add("가격");
		table = new JTable(rowData, colNames);
		JScrollPane jsp = new JScrollPane(table);
		
		setLayout(new BorderLayout());
		add(p,BorderLayout.CENTER);
		add(jsp,BorderLayout.SOUTH);
		
		setSize(600,600);
		setVisible(true);
	
		btn_search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ArrayList<BookVO> list = dao.SearchBook(search.getText());
				rowData.clear();
				for(BookVO bv : list) {
					Vector v = new Vector();
					v.add(bv.getBookid());
					v.add(bv.getBookname());
					v.add(bv.getPublisher());
					v.add(bv.getPrice());
					rowData.add(v);	
				}
				table.updateUI();
			}
		});
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BookTest();

	}

}
