package com.sist.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;

public class CalcTest02 extends JFrame implements ActionListener{
	JTextField jtf;
	
	int num1; //연산을 위한 첫번째수를 담을 변수
	int num2; //연산을 위한 두번째수를 담을 변수
	String op; //어떤 연산을 할지 담을 변수 
	boolean isNew;
	
	public CalcTest02() {
		
		isNew = true;
		//계산결과를 출력할 텍스트필드를 멤버변수로 만듬
		jtf = new JTextField(10);
		JPanel p = new JPanel();
		//패널의 레이아웃 방식을 GridLayout으로 설정함
		p.setLayout(new GridLayout(4,4));
		
		//16의 버튼에 표시될 문자열을 배열에 담음
		String []arr = {"7","8","9","+",
						"4","5","6","-",
						"1","2","3","*",
						"0","C","=","/"};
		//버튼배열을 선언함
		JButton []jbn = new JButton [arr.length];
		
		//버튼배열의 수만큼 반복실행하여 버튼을 생성하여 패널에 담음 
		for(int i=0;i<jbn.length;i++) {
			jbn[i] = new JButton(arr[i]);
			p.add(jbn[i]);
			jbn[i].addActionListener(this);
		}
		
		add(jtf,BorderLayout.NORTH);
		add(p,BorderLayout.CENTER);
		
		setSize(300,400);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		new CalcTest02();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//눌러진 버튼의 글자를 읽어옴 
		String cmd = e.getActionCommand();
		System.out.println(cmd);
		
		if(cmd.equals("+")||cmd.equals("-")||cmd.equals("*")||cmd.equals("/")) {
			//지금화면에 보이고 있는 숫자를 변수(num1)에 저장함
			num1 = Integer.parseInt(jtf.getText());
			//그리고 어떤연산을 해야할지를 변수(op)에 저장함
			op = cmd;
			//그리고 화면을 깨끗히 지워줌
			jtf.setText("");
			
		}else if(cmd.equals("=")) {
			//지금화면에 보이는 숫자를 변수(num2)에 저장함
			num2 = Integer.parseInt(jtf.getText());
			//그리고 op에 연산자의 종류에 num1과 num2를 해당 연산을 수행하여 jtf에 출력함
			int result =0;
			if(op.equals("+")) {
				result = num1 + num2; 
			}else if(op.equals("-")){
				result = num1 - num2;
			}else if(op.equals("*")){
				result = num1 * num2;
			}else if(op.equals("/")){
				result = num1 / num2;	
			}
			isNew = true;
			
			jtf.setText(result+"");
			
		}else if(cmd.equals("C")) {
			//지금화면에 보이고 있는 숫자를 지운다
			jtf.setText("");
		
		}else {
			if(isNew == true) {
				jtf.setText("");
			}
			jtf.setText(jtf.getText()+cmd);
			isNew = false;
		}
		
		//눌러진 버튼의 글자를 텍스트필드에 계속 누적하여 출력
		//jtf.setText(jtf.getText()+cmd);
	}

}
