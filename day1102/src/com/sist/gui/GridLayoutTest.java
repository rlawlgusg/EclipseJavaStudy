package com.sist.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.GridLayout;

public class GridLayoutTest extends JFrame {
	
	public GridLayoutTest() {
		//�������� 5�� 3���� �׸��巹�̾ƿ����� ����
		setLayout(new GridLayout(5,3));
		
		for(int i=1;i<=15;i++) {
			add(new JButton("��ư"+i));
		}
		
		setSize(400,300);
		setVisible(true);
	
	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GridLayoutTest();
	}

}