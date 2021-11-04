package com.sist.goods;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertGoods extends JFrame {

	JTextField jtf_no;
	JTextField jtf_item;
	JTextField jtf_qty;
	JTextField jtf_price;
	
	public InsertGoods() {
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
	
		//프레임의 가운데에 패널을 담고 아래쪽에 버튼을 담음
		add(p,BorderLayout.CENTER);
		add(btn_add,BorderLayout.SOUTH);
		
		setSize(400,300);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btn_add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int no = Integer.parseInt(jtf_no.getText());
				String item = jtf_item.getText();
				int qty = Integer.parseInt(jtf_qty.getText());
				int price = Integer.parseInt(jtf_price.getText());
				
				String sql = "insert into goods values("+no+",'"+item+"',"+qty+","+price+")";
				
				//finally에서도 접근할 수 있도록 Connection과 Statement
				//변수를 try문 바깥에 선언 
				Connection conn = null;
				Statement stmt = null;
				
				try {
					//1. jdbc드라이버를 메모리로 로드함
					Class.forName("oracle.jdbc.driver.OracleDriver");
					//2. DB서버에 연결
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##sist", "sist");
					//3. 데이터베이스 명령을 실행할 수 있는 Statement 객체를 생성함 
					stmt = conn.createStatement();
					//4. 데이터베이스 명령을 실행
					int re = stmt.executeUpdate(sql);
					if(re == 1) {
						System.out.println("상품등록에 성공하였습니다");
						jtf_no.setText("");
						jtf_item.setText("");
						jtf_qty.setText("");
						jtf_price.setText("");
					}else {
						System.out.println("상품등록에 실패하였습니다");
					}
				}catch(Exception ex) {
					System.out.println(ex.getMessage());
				}finally {
					try {
						//5. 사용했던 자원들을 닫아줌 			
						if(stmt != null) {
						stmt.close();
						}
						if(conn != null) {
						conn.close();
						}
					} catch (Exception ex) {}				
				}
			}
		});
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new InsertGoods();
	}

}
