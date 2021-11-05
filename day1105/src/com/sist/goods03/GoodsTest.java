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
	
	//데이터베이스에 접근하여 추가,목록,수정,삭제 기능을 갖고 있는
	//dao를 멤버로 선언 
	GoodsDao dao;

	public void printGoods(){
		
		rowData.clear();
		
		ArrayList<GoodsVo> list = dao.listGoods();
		//list에 담긴 GoodsVo를 하나씩 꺼내와서 테이블의 데이터를 표현하기 위한 rowData에 담음
		for(GoodsVo g:list) {
			Vector v = new Vector();
			v.add(g.getNo());
			v.add(g.getItem());
			v.add(g.getQty());
			v.add(g.getPrice());
			rowData.add(v);
		}	
		//테이블을 다시 그려주세요 요청함!
		table.updateUI();
	}
	
	
	public GoodsTest() {
		//dao를 생성
		dao = new GoodsDao();
		
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
			
				//사용자가 입력한 상품번호,상품명,수량,가격을 갖고 Vo를 생성
				GoodsVo g = new GoodsVo(no, item, qty, price);
				//그 Vo를 dao의 insertGoods에게 전달
				int re = dao.insertGoods(g);
				if(re == 1) {
					System.out.println("상품등록에 성공하였습니다");
					printGoods();
				}else {
					System.out.println("상품등록에 실패하였습니다");
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
					System.out.println("상품수정에 성공하였습니다");
					printGoods();
				}else {
					System.out.println("상품수정에 실패하였습니다");
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
					System.out.println("상품을 삭제하였습니다");
					printGoods();
				}else {
					System.out.println("삭제에 실패하였습니다");
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
