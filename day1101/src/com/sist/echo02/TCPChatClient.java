package com.sist.echo02;
//전송
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class TCPChatClient extends JFrame implements ActionListener, Runnable{
	//대화내용을 출력할 텍스트에어리어를 멤버변수로 만듬 
	JTextArea jta;
	//내가 대화내용을 입력할 텍스트필드를 멤버변수로 만듬
	JTextField jtf;
	
	//입출력스트림을 멤버변수로 만듬
	InputStream is;
	OutputStream os;
	
	public TCPChatClient() {
		//멤버변수 텍스트에어리어와 텍스트필드를 생성
		jta = new JTextArea();
		jtf = new JTextField(50);
		
		//전송을 위한 버튼을 생성
		JButton btn = new JButton("전송");
		
		//버튼에 이벤트를 등록함
		btn.addActionListener(this);
		
		//텍스트필드와 버튼을 담기위한 패널을 생성
		JPanel p = new JPanel();
		p.add(jtf);
		p.add(btn);
		
		//텍스트에어리어를 스크롤팬으로 감쌈
		JScrollPane jsp = new JScrollPane(jta);
		
		//프레임의 가운데에 텍스트에어리어를 감싸고 있는 스크롤팬을 담음
		add(jsp,BorderLayout.CENTER);
		
		//텍스트필드와 버튼을 담고 있는 패널을 프레임의 아래에 담음
		add(p,BorderLayout.SOUTH);
		
		//프레임의 크기를 설정
		setSize(800,600);
		
		//프레임이 화면에 보이도록 설정
		setVisible(true);
		
		Thread t = new Thread(this);
		t.start();
		
}//end생성자
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TCPChatClient();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		byte []data = new byte[100];
		try {
			DatagramSocket socket = new DatagramSocket(9003);

			InetAddress address = InetAddress.getByName("localhost");
			DatagramPacket packet = new DatagramPacket(data, data.length, address, 9004);
			
			
			
			packet = new DatagramPacket(data, data.length);
			socket.receive(packet);
			
			data = jtf.getText().getBytes();
			jtf.setText("");
			
		}catch(Exception ex) {
			System.out.println("예외발생:"+ex.getMessage());
		}
		
	}
	//서버로 부터 수신된 데이터를 계속 받도록 함
	@Override
	public void run() {
		// TODO Auto-generated method stub
		byte []data = new byte[100];
		while(true) {
			try {
				//센드
				String msg = new String(data);//글자로 형변환
				msg = msg.trim();
				jta.append(msg+"\n");
			}catch(Exception e) {
				
			}//end catch
		}//end while
		
	}//end run

}
