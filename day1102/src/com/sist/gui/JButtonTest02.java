package com.sist.gui;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JButtonTest02 extends JFrame {
	
	public JButtonTest02() {
		//��ư�� �����Ͽ� â�� ����
		JButton btn01 = new JButton("��ư1");
		JButton btn02 = new JButton("��ư2");
		
		add(btn01);
		add(btn02);
		
		//â�� ��������� â�� ȭ�鿡 �������� ����
		//���̰� �Ϸ��� â�� ����,���� ���̸� �����ϰ� ȭ�鿡 ���̵��� ����
		setSize(400,300);
		setVisible(true);
		
		//â�� ������ ���α׷��� ���� ���� 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		//�츮�� ���� JButtonTest�� �� JFrame��
		//�����̸��� ���� �� �ʿ䰡 ����
		//��ü�� �����ϱ⸸ �ص� ����
		new JButtonTest02();
	
	}

}
