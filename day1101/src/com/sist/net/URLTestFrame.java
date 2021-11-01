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
	
	//url�� �Է¹ޱ� ���� �ؽ�Ʈ�ʵ带 ��������� ����
	JTextField jtf;
	//url�� ������ ������ �ܾ�ͼ� ����ϱ� ���� �ؽ�Ʈ���� ��������� ����
	JTextArea jta;
	
	public URLTestFrame() {
		//������� �ؽ�Ʈ�ʵ�� �ؽ�Ʈ������ ��ü�� ����
		jtf = new JTextField(50);
		jta = new JTextArea();
		
		//�о���⸦ �����ų ��ư�� ������ 
		JButton btn = new JButton("�о����");
		
		//�ؽ�Ʈ�ʵ�� ��ư�� ��� ���� �г��� ����
		JPanel p = new JPanel();
		
		//�гο� �ؽ�Ʈ�ʵ�� ��ư�� ����
		p.add(jtf);
		p.add(btn);
	
		//�ؽ�Ʈ����� ���α� ���� ��ũ������ ������
		JScrollPane jsp = new JScrollPane(jta);
		
		//�ؽ�Ʈ�ʵ�� ��ư�� ��� �ִ� �г��� �������� ���ʿ� ����
		add(p, BorderLayout.NORTH);
		
		//�ؽ�Ʈ����� ���ΰ� �ִ� ��ũ������ �������� ����� ����
		add(jsp, BorderLayout.CENTER);
		
		//�������� ũ�⸦ ����
		setSize(800,600);
		
		//�������� ȭ�鿡 ���̵��� ����
		setVisible(true);
		
		//��ư�� �̺�Ʈ�� �����
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
			//����ڰ� �Է��� �ּҸ� �о�ͼ�
			//���ͳݻ��� ������ü�� ������
			URL url = new URL(jtf.getText()); 
			//�� ������ ������ �о���̱� ���Ͽ� ��Ʈ���� ����
			InputStream is = url.openStream();
			//�ѹ��� �о���� byte���� �迭�� ����
			byte []data = new byte[100];
			//��Ʈ���� ���� �о�� ���ڿ��� �� ��Ƴ��� ������ ����
			String str = "";
			//��Ʈ���� ���� �ƴҶ����� 100����Ʈ�� �о� ���� 
			while(is.read(data) != -1) {
				//�о���� byte�迭�� �����͸� ���ڿ��� ����� ������
				str += new String(data,"utf-8");
				
				//�迭�� �ٽ� �о���̱� ���� ������ ����� 
				//�׷��� ������ �ǳ��� �̻��� �����Ⱑ ��µ� �� ����
				//byte���� �迭 data�� ��� 0���� �ʱ�ȭ�� 
				//���� 0 �̿��� �ڹٴ� int�� ����ϱ� ������ byte���� ����ȯ
				Arrays.fill(data, (byte)0);
				
			}
			//��ü ������ ���ڿ� ������ �����
			jta.setText(str);
			//��Ʈ���� �ݾ���
			is.close();
			
			}catch(Exception ex) {
				System.out.println(ex.getMessage());
			}
	}

}
