package com.sist.game;

import javax.swing.JFrame;
//GUI���α׷��ֿ���
//â�� ����� ���ؼ��� JFrame�� ��ӹ���
public class MyFrame extends JFrame {
	//�����ڿ���
	public MyFrame() {
		setTitle("My Game"); //â�� ������ ����
		add(new MyPanel()); //��,�̻���,���ּ��� �����ϰ� �ִ� �г��� �����Ͽ� �����ӿ� ����
		setSize(500, 500);  //�������� ũ�⸦ ����
		setVisible(true);	//�������� ȭ�鿡 ���̵��� ���� 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyFrame();	//�������� ����
	}

}
