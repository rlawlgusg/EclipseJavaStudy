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
		p.add(new JLabel("�μ���ȣ:"));
		p.add(jtf_no);
		p.add(new JLabel("�μ��̸�:"));
		p.add(jtf_name);
		p.add(new JLabel("�μ���ġ:"));
		p.add(jtf_site);

		JButton btn_add = new JButton("�߰�");
		JButton btn_list = new JButton("���");
		JButton btn_update = new JButton("����");
		JButton btn_delete = new JButton("����");
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
		colName.add("�μ���ȣ");
		colName.add("�μ��̸�");
		colName.add("�μ���ġ");
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
