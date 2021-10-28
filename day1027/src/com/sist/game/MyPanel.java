package com.sist.game;

import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.event.*;
//��, �̻���, ���ּ��� ���ÿ�(�Ѳ�����) ���� �� �ִ� �г� Ŭ������ ���� 
//�гο� Ű���尡 �������� �̺�Ʈ�� ó���ϱ� ���Ͽ� keyListener�� ���� 
import java.util.ArrayList;
class MyPanel extends JPanel implements KeyListener {
	//��,�̻���,���ּ��� �г��� ������ ������ 
	//Enermy enermy;
	
	//�������� ���� ����� ���Ͽ� ArrayList�� ����
	ArrayList<Enermy> enermyList;
	
	SpaceShip spaceship;
	Missile missile;
	//�����ڿ� ��, �г��� �����ǰ� ���ÿ� �����Ͽ�
	public MyPanel() {
		super();
		this.addKeyListener(this); //�г��� Ű���� �̺�Ʈ�� �����
		this.requestFocus(); //�г��� Ű���� ��û�� ������ A
		setFocusable(true);  //�гο� ��Ŀ���� ���� B
		
		enermyList = new ArrayList<Enermy>();
	
		enermyList.add(new Enermy("enermy.png"));
		enermyList.add(new Enermy("enermy.png"));
		enermyList.add(new Enermy("enermy.png"));
		enermyList.add(new Enermy("enermy.png"));
		enermyList.add(new Enermy("enermy.png"));
		

		spaceship = new SpaceShip("spaceship.png");//�̹������ϸ��� ���� ���ּ� ��ü�� ����
		missile = new Missile("missile.png");//�̹������ϸ��� ���� �̻��� ��ü�� ����
		
	
		class MyThread extends Thread{  
			public void run(){	
				while(true) {	  
					missile.update();
					
					for(Enermy enermy : enermyList) {
						enermy.update();
						enermy.crush(missile);
					}

					repaint();
					
					try {Thread.sleep(50);}
					catch(InterruptedException e) {}
				}
			}
		}
		
		Thread t = new MyThread();
		//�����带 ���� 
		t.start();
	}
	
	public void paint(Graphics g) {  
		super.paint(g); 
		//�������� ���� ����ִ� ����Ʈ�� ����ŭ �ݺ��Ͽ� ���� �ٽ� �׷���
		for(Enermy enermy : enermyList) {
			enermy.draw(g);
		}
		spaceship.draw(g);
		missile.draw(g);
	}	
	
	public void keyPressed(KeyEvent event) {
		spaceship.KeyPressed(event);  //������ Ű�����̺�Ʈ�� ������ ���ּ����� ������
		missile.KeyPressed(event, spaceship.x, spaceship.y);	
	}

	public void keyTyped(KeyEvent arg0) {}

	public void keyReleased(KeyEvent arg0) {}
}	
	