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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class GoodsTestDBMethod extends JFrame {

	JTextField jtf_no;
	JTextField jtf_item;
	JTextField jtf_qty;
	JTextField jtf_price;
	
	JTable table; //모든 상품 목록을 엑셀과 같은 모양으로 보여주기 위한 테이블을 선언
	Vector colNames; //테이블의 칼럼이름을 위한 벡터를 선언
	Vector<Vector> rowData; //테이블의 데이터를 위한 벡터를 선언
	
	//데이터베이스에 연결하여 goods테이블의 모든 상품을 읽어와서(검색하여, 조회하여)
	//테이블에 출력하는 메소드를 정의
	
	public void printGoods(){
		
		//새로운 상품을 등록하면 계속하여 호출될 수 있으니
		//rowData를 먼저 깨끗히 비워줌 
		rowData.clear();
		
		//데이터베이스에 연결하여 실행할 명령어
		String sql = "select * from goods Order by no";
		
		//데이터베이스 연결과 필요한 변수들을 선언
		Connection conn = null; //DB서버에 연결을 위한 변수
		Statement stmt = null;  //데이터베이스 명령을 실행하기 위한 변수
		ResultSet rs = null;  //읽어온 데이터를 담기위한 변수
		try {
			//1. jdbc드라이버를 메모리로 로드함
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2. db서버에 연결함
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##sist", "sist");
			//3.statement객체를 생성
			stmt = conn.createStatement();
			//4.데이터베이스 명령을 실행함
			//사용하는 메소드 두가지
			//int re = executeUpdate(String sql) : 자료를 추가,수정,삭제
			//ResultSet rs = executeQuery(String sql) : 자료를 읽어올때
			rs = stmt.executeQuery(sql);
			//5.일처리를 한다
			//검색한 자료가 있는 만큼 반복실행하여 한 행씩 읽어와서 그것을 벡터로 만들어
			//그 벡터를 테이블의 자료를 위한 rowData에 담음 
			//ResultSet의 결과에서 특정 레코드를 가리키는 커서가 있음
			//이 커서를 한 행씩 옮겨주는 메소드가 next()
			//이 메소드는 다음에 레코드가 있어서 성공적으로 옮겨지면 true를 반환하고
			//다음에 레코드가 더이상 없어서 옮겨지지 않으면 false를 반환
			//그래서 보통 ResultSet에 결과를 모두 읽어서 처리하려면 다음과 같이 
			//while문을 이용함 
			while(rs.next()) {
				//현재 커서가 바라보고 있는 레코드의 속성값을 읽어오기 위해서는 자료형에 따라
				//get~()을 사용함
				//칼럼의 값이 문자열이라면 getString()을 이용하고 
				//칼럼의 값이 정수라면 getInt()를 사용
				//이때 매개변수로 컬럼의 인덱스나 컬럼의 이름을 문자열로 전달
				//여기서 인덱스는 1부터 시작 
				
				int no = rs.getInt(1);
				String item = rs.getString(2);
				int qty = rs.getInt(3);
				int price = rs.getInt(4);
				
				//벡터를 하나 만들고 그 벡터에 no,item,qty,price를 담음
				Vector v = new Vector();
				v.add(no);
				v.add(item);
				v.add(qty);
				v.add(price);
				//그 벡터를 rowData에 담음
				rowData.add(v);
				//바뀐내용으로 테이블을 다시 그림
				//처음 테이블을 만들때에는 rowData벡터가 비어있음
				//나중에 테이블의 데이터인 rowData에 바뀐 자료를 적용하기 위해서는
				//updateUI를 호출해야함
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
		//데이터베이스 insert를 수행하는 메소드를 만들고 호출하도록 수정 
		
		
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
				
				//상품등록을 성공하면 테이블의 내용을 다시 읽어오도록 메소드를 호출함
				printGoods();
				
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
	
	
	public GoodsTestDBMethod() {
		
		//테이블에 들어갈 칼럼이름을 위한 벡터를 생성하고 자료를 추가
		colNames = new Vector<>();
		colNames.add("상품번호");
		colNames.add("상품명");
		colNames.add("수량");
		colNames.add("단가");
		
		//테이블에 들어갈 실제 데이터들을 담기 위한 벡터를 생성하고 자료를 추가
		rowData = new Vector<Vector>();
		
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
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GoodsTestDBMethod();
	}

}
