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
	
	//수정할 상품번호, 상품이름, 수량, 가격을 매개변수로 전달받아 데이터베이스에 수정하는 메소드 정의
	public void updateGoods(int no,String item,int qty,int price) {
		String sql = "update goods set item='"+item+"', qty="+qty+", price="+price+" where no="+no;
		Connection conn = null;
		Statement stmt = null;
		try {
			//1.jdbc드라이버를 메모리로 로드함
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2.db서버에 연결함
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "*****", "*****");		
			//3.statement 객체를 생성
			//4.데이터베이스명령을 실행함
			stmt = conn.createStatement();
			
			int re = stmt.executeUpdate(sql);
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
				//그 벡터를 rowData에 담음
				rowData.add(v);
				table.updateUI();
			}	
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}finally {
			try {
				//사용했던 자원들을 닫아줌
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
				if(stmt != null) {
				stmt.close();
				}
				if(conn != null) {
				conn.close();
				}
			} catch (Exception ex) {}				
		}
	}
	//삭제할 상품번호를 매개변수로 전달받아 해당상품을 데이터베이스에 삭제하는 메소드를 정의
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
		colNames.add("상품번호");
		colNames.add("상품명");
		colNames.add("수량");
		colNames.add("단가");
		
		rowData = new Vector<Vector>();
		
		table = new JTable(rowData, colNames);
		
		JScrollPane jsp = new JScrollPane(table);
		
		jtf_no = new JTextField(); //상품번호를 입력받기 위한 입력상자
		jtf_item = new JTextField(); //상품명을 입력받기 위한 입력상자
		jtf_qty = new JTextField();	 //수량을 입력받기 위한 입력상자
		jtf_price = new JTextField();	//가격을 입력받기 위한 입력상자
		
		//입력상자들과 무엇을 입력해야할지 설명하는 라벨들을 담기 위한 패널을 만듬
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(4,2));
		
		//라벨과 입력상자(텍스트필드)들을 패널에 차례대로 담음 
		p.add(new JLabel("상품번호:"));
		p.add(jtf_no);
		p.add(new JLabel("상품이름:"));
		p.add(jtf_item);
		p.add(new JLabel("상품수량:"));
		p.add(jtf_qty);
		p.add(new JLabel("상품단가:"));
		p.add(jtf_price);
		
		//"추가"글씨가 쓰여진 버튼을 만듬
		JButton btn_add = new JButton("추가");
		//"목록"글씨가 쓰여진 버튼을 만듬
		JButton btn_list = new JButton("목록");
		JButton btn_update = new JButton("수정");
		JButton btn_delete = new JButton("삭제");
		
		//버튼들을 담을 패널 생성
		JPanel p2 = new JPanel();
		p2.add(btn_add);
		p2.add(btn_list);
		p2.add(btn_update);
		p2.add(btn_delete);
		
		//입력상자들이 있는 패널과 버튼이 있는 패널을 감쌀 패널을 생성
		JPanel p_center = new JPanel();
		p_center.setLayout(new BorderLayout());
		
		p_center.add(p,BorderLayout.CENTER);
		p_center.add(p2,BorderLayout.SOUTH);
		
		//프레임의 가운데에 입력상자와 버튼을 담고 있는 p_center패널을 담음
		add(p_center,BorderLayout.CENTER);
		//테이블을 담고 있는 스크롤팬을 프레임의 아래쪽에 담음
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
				//수정버튼을 누르면 수정할 상품의 번호, 이름, 수량 가격을 텍스트필드로 부터 읽어와서
				//그것을 메소드에게 전달하여 수정하도록 함
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
		
		//테이블에 마우스 이벤트를 등록하여 선택한 행의 상품의 정보를 각각의 입력상자에 출력
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
				//rowData의 index번째의 벡터를 꺼집어내옴
				Vector vr = rowData.get(index);
				//그 벡터의 요소를 차례로 입력상자에 출력함
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
