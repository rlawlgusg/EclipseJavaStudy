package com.sist.department;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.util.Vector;
import java.awt.BorderLayout;
public class DepartmentTest extends JFrame {
	
	JTextField jtf_no;
	JTextField jtf_name;
	JTextField jtf_site;
	JTable table;
	Vector colName;
	Vector<Vector> rowDate;
	
	public DepartmentTest() {
	
		jtf_no = new JTextField();
		jtf_name = new JTextField();
		jtf_site = new JTextField();
			
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(3,2));
		p.add(new JLabel("부서번호:"));
		p.add(jtf_no);
		p.add(new JLabel("부서이름:"));
		p.add(jtf_name);
		p.add(new JLabel("부서위치:"));
		p.add(jtf_site);

		JButton btn_add = new JButton("추가");
		JButton btn_list = new JButton("목록");
		JButton btn_update = new JButton("수정");
		JButton btn_delete = new JButton("삭제");
		JPanel b =new JPanel();
		b.add(btn_add);
		b.add(btn_list);
		b.add(btn_update);
		b.add(btn_delete);
		
		JPanel c = new JPanel();
		c.setLayout(new BorderLayout());
		c.add(p,BorderLayout.CENTER);
		c.add(b,BorderLayout.SOUTH);

		colName = new Vector();
		colName.add("부서번호");
		colName.add("부서이름");
		colName.add("부서위치");
		rowDate = new Vector<Vector>();
		table = new JTable(rowDate, colName);
		JScrollPane jsp = new JScrollPane(table);
			
		add(c,BorderLayout.CENTER);
		add(jsp,BorderLayout.SOUTH);
		
		setSize(500,700);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DepartmentTest();
	}

}
