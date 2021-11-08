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
					System.out.println("부서정보 추가에 성공하였습니다");
				}else {
					System.out.println("부서정보 추가에 실패하였습니다");
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
					System.out.println("회원정보 업데이트 하였습니다");
					printinfo();
				}else {
					System.out.println("회원정보 업데이트에 실패하였습니다");
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
					System.out.println("회원정보를 삭제하였습니다");
					printinfo();
				}else {
					System.out.println("회원정보 삭제에 실패하였습니다");
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
