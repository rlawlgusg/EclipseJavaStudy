package com.sist.inner;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//��ư�� ���� �̺�Ʈ ó���� ���ؼ��� ActionListener �������̽��� �����ؾ���
//����, MyFrame�ڽ��� ActionListener �������̽��� �����ϰ� �Ǹ�
//�ϳ��� actionPerformed �޼ҵ忡�� 
//��� ��ư�� �̺�Ʈ ó���� �ؾ��� 
//������ ���� ���������� �Ǵ��ϴ� if�� �������� �� ���� 
//�׷��� ��ư�ϳ��� ��ó�� ��簴ü�� �̸����� innerŬ������ ���� ó���� 

public class MyFrame extends JFrame {
	
	public MyFrame() {
		JButton btn01 = new JButton("����");
		JButton btn02 = new JButton("����");
		setLayout(new FlowLayout());
		
		add(btn01);
		add(btn02);
		
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		btn01.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("�����Դϴ�");
			}
		});
		btn02.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("�����Դϴ�");
			}
		});
	
		
		
		
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyFrame();
	}

}
