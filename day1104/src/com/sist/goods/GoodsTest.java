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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class GoodsTest extends JFrame {

	JTextField jtf_no;
	JTextField jtf_item;
	JTextField jtf_qty;
	JTextField jtf_price;
	
	JTable table; //모든 상품 목록을 엑셀과 같은 모양으로 보여주기 위한 테이블을 선언
	Vector colNames; //테이블의 칼럼이름을 위한 벡터를 선언
	Vector<Vector> rowData; //테이블의 데이터를 위한 벡터를 선언
	
	public GoodsTest() {
		
		//테이블에 들어갈 칼럼이름을 위한 벡터를 생성하고 자료를 추가
		colNames = new Vector<>();
		colNames.add("상품번호");
		colNames.add("상품명");
		colNames.add("수량");
		colNames.add("단가");
		
		//테이블에 들어갈 실제 데이터들을 담기 위한 벡터를 생성하고 자료를 추가
		rowData = new Vector<Vector>();
		
		Vector v1 = new Vector();
		v1.add("1");
		v1.add("색종이");
		v1.add("10");
		v1.add("1500");
		Vector v2 = new Vector();
		v2.add("2");
		v2.add("딱풀");
		v2.add("20");
		v2.add("700");
		
		rowData.add(v1);
		rowData.add(v2);
		
		//컬럼이름이 있는 colNames벡터와 실제데이터가 있는 rowData벡터를 갖고 
		//엑셀과 같은 화면의 테이블을 생성
		table = new JTable(rowData, colNames);
		
		//테이블의 자료가 너무 많아서 한 화면에 보이지 않을때에 자동으로 스크롤을 만들어주는
		//스크롤팬을 생성
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
		
		//버튼들을 담을 패널 생성
		JPanel p2 = new JPanel();
		p2.add(btn_add);
		p2.add(btn_list);
		
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
		new GoodsTest();
	}

}
