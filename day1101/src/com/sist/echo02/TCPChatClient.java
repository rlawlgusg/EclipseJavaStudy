package com.sist.echo02;
//����
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
	//��ȭ������ ����� �ؽ�Ʈ���� ��������� ���� 
	JTextArea jta;
	//���� ��ȭ������ �Է��� �ؽ�Ʈ�ʵ带 ��������� ����
	JTextField jtf;
	
	//����½�Ʈ���� ��������� ����
	InputStream is;
	OutputStream os;
	
	public TCPChatClient() {
		//������� �ؽ�Ʈ������ �ؽ�Ʈ�ʵ带 ����
		jta = new JTextArea();
		jtf = new JTextField(50);
		
		//������ ���� ��ư�� ����
		JButton btn = new JButton("����");
		
		//��ư�� �̺�Ʈ�� �����
		btn.addActionListener(this);
		
		//�ؽ�Ʈ�ʵ�� ��ư�� ������� �г��� ����
		JPanel p = new JPanel();
		p.add(jtf);
		p.add(btn);
		
		//�ؽ�Ʈ���� ��ũ�������� ����
		JScrollPane jsp = new JScrollPane(jta);
		
		//�������� ����� �ؽ�Ʈ���� ���ΰ� �ִ� ��ũ������ ����
		add(jsp,BorderLayout.CENTER);
		
		//�ؽ�Ʈ�ʵ�� ��ư�� ��� �ִ� �г��� �������� �Ʒ��� ����
		add(p,BorderLayout.SOUTH);
		
		//�������� ũ�⸦ ����
		setSize(800,600);
		
		//�������� ȭ�鿡 ���̵��� ����
		setVisible(true);
		
		Thread t = new Thread(this);
		t.start();
		
}//end������
	
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
			System.out.println("���ܹ߻�:"+ex.getMessage());
		}
		
	}
	//������ ���� ���ŵ� �����͸� ��� �޵��� ��
	@Override
	public void run() {
		// TODO Auto-generated method stub
		byte []data = new byte[100];
		while(true) {
			try {
				//����
				String msg = new String(data);//���ڷ� ����ȯ
				msg = msg.trim();
				jta.append(msg+"\n");
			}catch(Exception e) {
				
			}//end catch
		}//end while
		
	}//end run

}
