package com.sist.echo03;

import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class TCPChatClient extends JFrame implements ActionListener, Runnable{
	

	JTextArea jta;
	JTextField jtf;
	
	InputStream is;
	OutputStream os;
	
	public TCPChatClient() {
		jta = new JTextArea();
		jtf = new JTextField(50);
		
		JButton btn = new JButton("전송");
		btn.addActionListener(this);
		JPanel p = new JPanel();
		p.add(jtf);
		p.add(btn);
		JScrollPane jsp = new JScrollPane(jta);
		
		add(jsp,BorderLayout.CENTER);
		add(p,BorderLayout.SOUTH);
		
		setSize(800,600);
		setVisible(true);
		
		try {
			Socket socket = new Socket("192.168.168.103",9003);
		
			is = socket.getInputStream();
			os = socket.getOutputStream();
		
		}catch(Exception e) {
			
		}
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
		try {
		
			byte []data = jtf.getText().getBytes();
			os.write(data);
			jtf.setText("");
			
		}catch(Exception ex) {
			System.out.println("예외발생:"+ex.getMessage());
		}
		
	}
	
	@Override
	public void run() {
		byte []data = new byte[100];
		while(true) {
			try {
				is.read(data); 
				String msg = new String(data);
				msg = msg.trim();
				jta.append(msg+"\n");
			}catch(Exception e) {
				
			}//end catch
		}//end while
		
	}//end run

}
//잘모르겠다~~~~~~