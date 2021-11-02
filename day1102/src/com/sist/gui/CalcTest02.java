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
	
	int num1; //������ ���� ù��°���� ���� ����
	int num2; //������ ���� �ι�°���� ���� ����
	String op; //� ������ ���� ���� ���� 
	boolean isNew;
	
	public CalcTest02() {
		
		isNew = true;
		//������� ����� �ؽ�Ʈ�ʵ带 ��������� ����
		jtf = new JTextField(10);
		JPanel p = new JPanel();
		//�г��� ���̾ƿ� ����� GridLayout���� ������
		p.setLayout(new GridLayout(4,4));
		
		//16�� ��ư�� ǥ�õ� ���ڿ��� �迭�� ����
		String []arr = {"7","8","9","+",
						"4","5","6","-",
						"1","2","3","*",
						"0","C","=","/"};
		//��ư�迭�� ������
		JButton []jbn = new JButton [arr.length];
		
		//��ư�迭�� ����ŭ �ݺ������Ͽ� ��ư�� �����Ͽ� �гο� ���� 
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
		//������ ��ư�� ���ڸ� �о�� 
		String cmd = e.getActionCommand();
		System.out.println(cmd);
		
		if(cmd.equals("+")||cmd.equals("-")||cmd.equals("*")||cmd.equals("/")) {
			//����ȭ�鿡 ���̰� �ִ� ���ڸ� ����(num1)�� ������
			num1 = Integer.parseInt(jtf.getText());
			//�׸��� ������� �ؾ������� ����(op)�� ������
			op = cmd;
			//�׸��� ȭ���� ������ ������
			jtf.setText("");
			
		}else if(cmd.equals("=")) {
			//����ȭ�鿡 ���̴� ���ڸ� ����(num2)�� ������
			num2 = Integer.parseInt(jtf.getText());
			//�׸��� op�� �������� ������ num1�� num2�� �ش� ������ �����Ͽ� jtf�� �����
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
			//����ȭ�鿡 ���̰� �ִ� ���ڸ� �����
			jtf.setText("");
		
		}else {
			if(isNew == true) {
				jtf.setText("");
			}
			jtf.setText(jtf.getText()+cmd);
			isNew = false;
		}
		
		//������ ��ư�� ���ڸ� �ؽ�Ʈ�ʵ忡 ��� �����Ͽ� ���
		//jtf.setText(jtf.getText()+cmd);
	}

}
