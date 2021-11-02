package com.sist.echo;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UDPChatClient extends JFrame implements ActionListener {
	
	DatagramSocket socket;
	DatagramPacket packet;
	
	
	//��ȭ ������ ǥ���ϱ� ���� �ؽ�Ʈ���� ��������� ����
	JTextArea jta;
	
	//��ȭ������ �Է��ϱ� ���� �ؽ�Ʈ�ʵ带 ��������� ����
	JTextField jtf;
	
	public UDPChatClient() {
		//����������� �����Ѵ�
		jta = new JTextArea();
		jtf = new JTextField(50);

		//������ ���� ��ư�� ������
		JButton jbn = new JButton("����");
		
		//�ؽ�Ʈ�ʵ�� ��ư�� ���� �г��� ������
		JPanel p = new JPanel();
		p.add(jtf);
		p.add(jbn);
		
		//�ؽ�Ʈ���� ��ũ���� ǥ���ϴ� ��ũ���Ұ�ü�� ����
		JScrollPane jsp = new JScrollPane(jta);
	
		//�������� ����� �ؽ�Ʈ���� ���ΰ� �ִ� ��ũ������ ���� 
		add(jsp,BorderLayout.CENTER);
		
		//�������� �Ʒ��� �ؽ�Ʈ�ʵ�� ��ư�� ��� �ִ� �г��� ����
		add(p,BorderLayout.SOUTH);
		
		//�������� ũ�⸦ ������
		setSize(800,600);
		
		//ȭ�鿡 �����ֵ��� ������
		setVisible(true);
		
		try {
			//�����͸� �ְ� �ޱ� ���� �޼ҵ带 ���� �ִ� DatagramSocket ��ü�� ����
			socket = new DatagramSocket();
		}catch(Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
		}
		
		//���۹�ư�� �̺�Ʈ�� ����Ͽ� �ؽ�Ʈ�ʵ忡 �Է��� ������ ������ ����
		jbn.addActionListener(this);
		
		//������ ���� �����͸� ����Ͽ� �����ϱ� ���� ������Ŭ������ innerŬ������ ����
		
		class ClientThread implements Runnable{
			DatagramPacket packet;
			byte []data = new byte[100];
			public void run() {
				
				//�����͸� �����ϱ� ���� ��Ŷ�� ���� ������
				packet = new DatagramPacket(data, data.length);
				
				//����Ͽ� ������ ���� �����͸� �����ϵ��� ��
				while(true) {
					try {
					socket.receive(packet);
			
					//������ ���� ���ŵ� �����Ͱ� �ִ� �迭�� ������ ���ڿ��� ����
					String msg = new String(data);
					
					//���ŵ� ���ڿ��� �ؽ�Ʈ���� �߰���
					jta.append(msg.trim()+"\n");
					
					//���������� ������ ���Ͽ� �迭�� ������
					Arrays.fill(data, (byte)0);
					
					}catch(Exception e) {
						System.out.println("���ܹ߻�:"+e.getMessage());
					}//end catch
				}//end while			
			}//end run
		}//end innerŬ���� 
		
		//�����尴ü�� �����ϰ� �����带 �������Ѿ���		
		new Thread(new ClientThread()).start();
		
	}//������ ��
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new UDPChatClient();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		//����ڰ� �Է��� ��ȭ������ �ִ� �ؽ�Ʈ�ʵ��� ���ڿ��� ����� 
		String msg = jtf.getText();
		
		//UDP������� �����͸� �������� ��Ŷ�� �����ؾ���
		//�׷��� �� ���ڿ��� byte[] �迭�� ��������
		byte[] data = msg.getBytes();
		
		//192.168.0.3 �������� �ּҸ� ���� InetAddress��ü�� ������
		try {
		InetAddress addr = InetAddress.getByName("192.168.0.48");
		
		int port = 9005;
		
		//�����͸� ���� ��Ŷ�� ������
		packet = new DatagramPacket(data, data.length, addr , port);
	
		//������ �����͸� ������
		socket.send(packet);
		System.out.println("data������");
		
		
		}catch(Exception ex) {
			System.out.println("���ܹ߻�:"+ex.getMessage());
		}
		
		
	}

}
