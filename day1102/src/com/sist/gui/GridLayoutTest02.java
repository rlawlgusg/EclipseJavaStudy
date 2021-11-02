package com.sist.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.GridLayout;

public class GridLayoutTest02 extends JFrame {
	
	public GridLayoutTest02() {
		//프레임을 5행 3열의 그리드레이아웃으로 설정
		setLayout(new GridLayout(5,3));
		
		for(int i=1;i<=14;i++) {
			add(new JButton("버튼"+i));
		}
		
		setSize(400,300);
		setVisible(true);
	
	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GridLayoutTest02();
	}

}
