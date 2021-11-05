package com.sist.goods03;

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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.MouseListener;

public class GoodsTest extends JFrame {
	JTextField jtf_no;
	JTextField jtf_item;
	JTextField jtf_qty;
	JTextField jtf_price;
	JTable table; 
	Vector colNames; 
	Vector<Vector> rowData; 
	
	//�����ͺ��̽��� �����Ͽ� �߰�,���,����,���� ����� ���� �ִ�
	//dao�� ����� ���� 
	GoodsDao dao;

	public void printGoods(){
		
		rowData.clear();
		
		ArrayList<GoodsVo> list = dao.listGoods();
		//list�� ��� GoodsVo�� �ϳ��� �����ͼ� ���̺��� �����͸� ǥ���ϱ� ���� rowData�� ����
		for(GoodsVo g:list) {
			Vector v = new Vector();
			v.add(g.getNo());
			v.add(g.getItem());
			v.add(g.getQty());
			v.add(g.getPrice());
			rowData.add(v);
		}	
		//���̺��� �ٽ� �׷��ּ��� ��û��!
		table.updateUI();
	}
	
	
	public GoodsTest() {
		//dao�� ����
		dao = new GoodsDao();
		
		colNames = new Vector<>();
		colNames.add("��ǰ��ȣ");
		colNames.add("��ǰ��");
		colNames.add("����");
		colNames.add("�ܰ�");
		rowData = new Vector<Vector>();
		table = new JTable(rowData, colNames);
		JScrollPane jsp = new JScrollPane(table);
		jtf_no = new JTextField(); 
		jtf_item = new JTextField();
		jtf_qty = new JTextField();	 
		jtf_price = new JTextField();	
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(4,2));
		p.add(new JLabel("��ǰ��ȣ:"));
		p.add(jtf_no);
		p.add(new JLabel("��ǰ�̸�:"));
		p.add(jtf_item);
		p.add(new JLabel("��ǰ����:"));
		p.add(jtf_qty);
		p.add(new JLabel("��ǰ�ܰ�:"));
		p.add(jtf_price);
		JButton btn_add = new JButton("�߰�");
		JButton btn_list = new JButton("���");
		JButton btn_update = new JButton("����");
		JButton btn_delete = new JButton("����");
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
			}});
		
		btn_add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int no = Integer.parseInt(jtf_no.getText());
				String item = jtf_item.getText();
				int qty = Integer.parseInt(jtf_qty.getText());
				int price = Integer.parseInt(jtf_price.getText());
			
				//dao.insertGoods(no,item,qty,price);	
			
				//����ڰ� �Է��� ��ǰ��ȣ,��ǰ��,����,������ ���� Vo�� ����
				GoodsVo g = new GoodsVo(no, item, qty, price);
				//�� Vo�� dao�� insertGoods���� ����
				int re = dao.insertGoods(g);
				if(re == 1) {
					System.out.println("��ǰ��Ͽ� �����Ͽ����ϴ�");
					printGoods();
				}else {
					System.out.println("��ǰ��Ͽ� �����Ͽ����ϴ�");
				}
				
				
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
				
				GoodsVo g = new GoodsVo(no, item, qty, price);
				int re = dao.updateGoods(g);
				if(re == 1) {
					System.out.println("��ǰ������ �����Ͽ����ϴ�");
					printGoods();
				}else {
					System.out.println("��ǰ������ �����Ͽ����ϴ�");
				}
				
			}	
		});
		
		btn_delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int no = Integer.parseInt(jtf_no.getText());
				int re = dao.deleteGoods(no);
				if(re == 1) {
					System.out.println("��ǰ�� �����Ͽ����ϴ�");
					printGoods();
				}else {
					System.out.println("������ �����Ͽ����ϴ�");
				}
			}
			
		});
		
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
				Vector vr = rowData.get(index);
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
		new GoodsTest();
	}

}
