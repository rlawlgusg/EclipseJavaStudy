package com.sist.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class NumberRandomGame extends JFrame implements KeyListener , ActionListener{
	JTextField jtf01;
	JTextField jtf02;
	JTextArea jta;
	Random random;
	int r = new Random().nextInt(100)+1;
	
	public NumberRandomGame() {
		jtf01 = new JTextField(10);
		jtf02 = new JTextField(10);

		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		
		JButton jbn1 = new JButton("다시 한번");
		JButton jbn2 = new JButton("종료");
		
		p1.add(new JLabel("숫자를 추측하시오:"));
		p1.add(jtf01);
		p2.add(jtf02);
		p3.add(jbn1);
		p3.add(jbn2);
		
		jbn1.addActionListener(this);
		jbn2.addActionListener(this);
		
		jtf01.addKeyListener(this);
		
		add(p1,BorderLayout.NORTH);
		add(p2,BorderLayout.CENTER);		
		add(p3,BorderLayout.SOUTH);
		setTitle("숫자게임");
		setSize(300,200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new NumberRandomGame();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cmd = e.getActionCommand();
		if(cmd.equals("다시 한번")) {
			jtf01.setText("");
		}else if(cmd.equals("종료")) {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		int cmd = e.getKeyChar();
		if(cmd > r) {
			jtf02.setText("너무 높습니다");
		}else if(cmd == r) {
			jtf02.setText("정답 입니다");
		}else if(cmd < r) {
			jtf02.setText("너무 낮습니다");
		}
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

}
