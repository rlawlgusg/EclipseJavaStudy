package com.sist.department;

import javax.lang.model.util.ElementKindVisitor14;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DepartmentTest extends JFrame{
	
	JTextField jtf_no;
	JTextField jtf_name;
	JTextField jtf_site;
	JTable table;
	Vector colName;
	Vector<Vector> rowData;
	DepartmentDao dao;
	
	public DepartmentTest() {
		dao = new DepartmentDao();
		
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
		rowData = new Vector<Vector>();
		table = new JTable(rowData, colName);
		JScrollPane jsp = new JScrollPane(table);
			
		add(c,BorderLayout.CENTER);
		add(jsp,BorderLayout.SOUTH);
		
		setSize(500,700);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		

		btn_add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int no = Integer.parseInt(jtf_no.getText());
				String name = jtf_name.getText();
				String site = jtf_site.getText();
				DepartmentVo dv = new DepartmentVo(no, name, site);
				int re = dao.InsertInfo(dv);
				if(re == 1) {
					System.out.println("�μ����� �߰��� �����Ͽ����ϴ�");
				}else {
					System.out.println("�μ����� �߰��� �����Ͽ����ϴ�");
				}
				
			}
			
		});
		
		btn_list.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				printinfo();
			}
			
		});
		
		btn_update.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int no = Integer.parseInt(jtf_no.getText());
				String name = jtf_name.getText();
				String site = jtf_site.getText();

				DepartmentVo dv = new DepartmentVo(no, name, site);
				int re = dao.UpdateInfo(dv);
				if(re == 1) {
					System.out.println("ȸ������ ������Ʈ �Ͽ����ϴ�");
					printinfo();
				}else {
					System.out.println("ȸ������ ������Ʈ�� �����Ͽ����ϴ�");
				}	
			}
			
		});
		
		btn_delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int no = Integer.parseInt(jtf_no.getText());
				int re = dao.DeleteInfo(no);
				if(re ==1) {
					System.out.println("ȸ�������� �����Ͽ����ϴ�");
					printinfo();
				}else {
					System.out.println("ȸ������ ������ �����Ͽ����ϴ�");
				}
			}
			
		});
		
		table.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {
				int index = table.getSelectedRow();
				Vector v = rowData.get(index);
				jtf_no.setText(v.get(0)+""); 
				jtf_name.setText(v.get(1)+""); 
				jtf_site.setText(v.get(2)+""); 
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
		});
		
	}
	
	public void printinfo() {
		rowData.clear();
		ArrayList<DepartmentVo> list = dao.listInfo();
		for(DepartmentVo dv : list) {
			Vector v = new Vector();
			v.add(dv.getNo());
			v.add(dv.getName());
			v.add(dv.getSite());
			rowData.add(v);
		}	
		table.updateUI();
	}	
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DepartmentTest();
	}

}
