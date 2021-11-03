package com.sist.chat;

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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ChatClient2 extends JFrame implements ActionListener {
	//��ȭ������ ����� �ؽ�Ʈ���� ��������� ���� 
	JTextArea jta;
	//���� ��ȭ������ �Է��� �ؽ�Ʈ�ʵ带 ��������� ����
	JTextField jtf;
	
	//����½�Ʈ���� ��������� ����
	InputStream is;
	OutputStream os;
	
	public ChatClient2() {
		//������� �ؽ�Ʈ������ �ؽ�Ʈ�ʵ带 ����
		jta = new JTextArea();
		jtf = new JTextField();
		
		//������ ���� ��ư�� ����
		JButton btn = new JButton("����");
		
		//��ư�� �̺�Ʈ�� �����
		btn.addActionListener(this);
		
		//�ؽ�Ʈ�ʵ�� ��ư�� ������� �г��� ����
		JPanel p = new JPanel();
		
		//�г��� ���̾ƿ������ BorderLayout���� ����
		p.setLayout(new BorderLayout());
		p.add(jtf,BorderLayout.CENTER);
		p.add(btn,BorderLayout.EAST);
		
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
		
		try {
			//����� ���Ͽ� ������ ������ ��û��
			Socket socket = new Socket("222.120.183.156",9003);
		
			//������� ���� ��Ʈ���� ������
			is = socket.getInputStream();
			os = socket.getOutputStream();
		
		}catch(Exception e) {
			
		}
		
		//������ �������� �����͸� ����Ͽ� �ޱ� ���� ������ Ŭ������ ����
		class ClientThread implements Runnable{
			byte []data = new byte[100];
			public void run() {
				while(true) {
					try {
					//������ ������ �����͸� ������
					is.read(data);
					//������ �����͸� ���ڿ��� ����
					String msg = new String(data);
					//������ ���ڿ��� �ؽ�Ʈ���� �߰���
					jta.append(msg.trim()+"\n");
					
					}catch(Exception e) {
						System.out.println("���ܹ߻�"+e.getMessage());
					}
				}//end run
			}
		}//end innerclass
		//�����κ��� ����Ͽ� ���ŵ� �޼����� �ޱ����� ������ ��ü�� �����ϰ� ������
	ClientThread ct = new ClientThread();
	new Thread(ct).start();
}//end������
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ChatClient2();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			//����ڰ� �Է��� �ؽ�Ʈ�ʵ��� ������ ������ �������� ��
			//OutputStream void write(byte[] b) �޼ҵ带 �̿���
			byte []data = jtf.getText().getBytes();
			os.write(data);
			//�޼����� �����ϰ� ���� �޼��� �Է��� ���Ͽ� �ؽ�Ʈ�ʵ带 ������ ������
			jtf.setText("");
			
		}catch(Exception ex) {
			System.out.println("���ܹ߻�:"+ex.getMessage());
		}
		
	}

}
