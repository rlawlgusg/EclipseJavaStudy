package com.sist.net;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.awt.BorderLayout;

public class URLTestFrame extends JFrame implements ActionListener{
	
	//url을 입력받기 위한 텍스트필드를 멤버변수로 만듬
	JTextField jtf;
	//url의 문서의 내용을 긁어와서 출력하기 위한 텍스트에어리어를 멤버변수로 만듬
	JTextArea jta;
	
	public URLTestFrame() {
		//멤버변수 텍스트필드와 텍스트에리어 객체를 생성
		jtf = new JTextField(50);
		jta = new JTextArea();
		
		//읽어오기를 수행시킬 버튼을 생성함 
		JButton btn = new JButton("읽어오기");
		
		//텍스트필드와 버튼을 담기 위한 패널을 생성
		JPanel p = new JPanel();
		
		//패널에 텍스트필드와 버튼을 담음
		p.add(jtf);
		p.add(btn);
	
		//텍스트에리어를 감싸기 위해 스크롤팬을 생성함
		JScrollPane jsp = new JScrollPane(jta);
		
		//텍스트필드와 버튼을 담고 있는 패널을 프레임의 위쪽에 담음
		add(p, BorderLayout.NORTH);
		
		//텍스트에리어를 감싸고 있는 스크롤팬을 프레임의 가운데에 담음
		add(jsp, BorderLayout.CENTER);
		
		//프레임의 크기를 설정
		setSize(800,600);
		
		//프레임을 화면에 보이도록 설정
		setVisible(true);
		
		//버튼에 이벤트를 등록함
		btn.addActionListener(this);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new URLTestFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			//사용자가 입력한 주소를 읽어와서
			//인터넷상의 문서객체를 생성함
			URL url = new URL(jtf.getText()); 
			//그 문서의 내용을 읽어들이기 위하여 스트림을 생성
			InputStream is = url.openStream();
			//한번에 읽어들일 byte형의 배열을 만듬
			byte []data = new byte[100];
			//스트림을 통해 읽어온 문자열을 다 모아놓을 변수를 만듬
			String str = "";
			//스트림의 끝이 아닐때까지 100바이트씩 읽어 들임 
			while(is.read(data) != -1) {
				//읽어들인 byte배열의 데이터를 문자열로 만들어 누적함
				str += new String(data,"utf-8");
				
				//배열을 다시 읽어들이기 전에 깨끗히 비워줌 
				//그렇지 않으면 맨끝에 이상한 쓰레기가 출력될 수 있음
				//byte형의 배열 data를 모두 0으로 초기화함 
				//숫자 0 이오면 자바는 int로 취급하기 때문에 byte으로 형변환
				Arrays.fill(data, (byte)0);
				
			}
			//전체 누적된 문자열 변수를 출력함
			jta.setText(str);
			//스트림을 닫아줌
			is.close();
			
			}catch(Exception ex) {
				System.out.println(ex.getMessage());
			}
	}

}
