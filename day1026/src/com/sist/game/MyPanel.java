package com.sist.game;

import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.event.*;
//��, �̻���, ���ּ��� ���ÿ�(�Ѳ�����) ���� �� �ִ� �г� Ŭ������ ���� 
//�гο� Ű���尡 �������� �̺�Ʈ�� ó���ϱ� ���Ͽ� keyListener�� ���� 
class MyPanel extends JPanel implements KeyListener {
	//��,�̻���,���ּ��� �г��� ������ ������ 
	Enermy enermy;
	SpaceShip spaceship;
	Missile missile;
	//�����ڿ� ��, �г��� �����ǰ� ���ÿ� �����Ͽ�
	public MyPanel() {
		super();
		this.addKeyListener(this); //�г��� Ű���� �̺�Ʈ�� �����
		this.requestFocus(); //�г��� Ű���� ��û�� ������ A
		setFocusable(true);  //�гο� ��Ŀ���� ���� B
		//�г��� ȭ�鱸������߿� ���� Ű����κ��� �Է¹޾� ���̴� �뵵�� �ƴϱ� ������
		//Ű����κ��� �Է��� �޾Ƶ��̰� �Ϸ��� �гο� �ϴ��� ��Ŀ���� �����ؾ���
		
		enermy = new Enermy("enermy.png"); //�̹������ϸ��� ���� �� ��ü�� ����
		spaceship = new SpaceShip("spaceship.png");//�̹������ϸ��� ���� ���ּ� ��ü�� ����
		missile = new Missile("missile.png");//�̹������ϸ��� ���� �̻��� ��ü�� ����
		
		//�г��� ��������� ��,�̻���,���ּ��� ���� ����������(���ÿ�,�����ϰ�) �����̵��� �ϱ� ���Ͽ�
		//��Ƽ�����带 ���� 
		//��,�̻���,���ּ��� ���ÿ�(�����ϰ�) �����̰� �ϴ� ����� �ٸ� �������� ������ ����
		//���� �̰� �гο����� �ʿ���
		//�̷����� Ŭ������ Ŭ�����ȿ� ���� �� ���� 
		//�̰��� inner class��� �� 
		class MyThread extends Thread{  //ThreadŬ������ ��ӹ޾� ��Ƽ�����带 ����
			public void run(){	//run�� �������̵��Ͽ� ���ÿ� �����ų ��ɾ�(��)�� ����
				while(true) {	//��� �ݺ��Ͽ� ��,�̻���,���ּ��� �����̵��� �ϱ����Ͽ� while(true)�� �̿�
					enermy.update();  //���� �����̵��� �ϱ� ���Ͽ� ���� ��ġ�� �����ϴ� �޼ҵ带 ȣ�� 
			//		spaceship.update(); //���ּ��� �����̵��� �ϱ� ���Ͽ� ���ּ��� ��ġ�� �����ϴ� �޼ҵ带 ȣ��
					//���ּ��� Ű���尡 ������ �������� �ѹ� �����̵��� �Ǿ� ���� �׷��� ȣ������ �ʾƵ� �� 
					missile.update();	////�̻����� �����̵��� �ϱ� ���Ͽ� �̻����� ��ġ�� �����ϴ� �޼ҵ带 ȣ��
					
					//���� �̻��Ͽ� �¾Ҵ��� �Ǻ��Ͽ� ���ִ� �޼ҵ带 ȣ��
					enermy.crush(missile);
					
					repaint();	//��,�̻���,���ּ��� ����� ��ġ�� �ٽ� �׸��� ���� ��û�� ��
								//ȭ�鿡 �׷����� �׷��ִ� �޼ҵ�� paint�޼ҵ��� 
								//����ڰ� ���� paint�� ȣ���� ���� ���� repaint�� ȣ���Ͽ�
								//paint�� ���۽�ų �� ���� 
					try {Thread.sleep(50);}
					catch(InterruptedException e) {}
				}
			}
		}
		//��,�̻���,���ּ��� ���� ���������� �����̵��� ����
		//��Ƽ������ ��ü MyThread�� ����
		Thread t = new MyThread();
		//�����带 ���� 
		t.start();
	}
	//��,�̻���,���ּ��� ����� ��ġ�� �׷����� �ٽ� �׷���
	//�гο� �׷����� ǥ���ϱ� ���ؼ��� paint�� �������̵� ����
	//�Ű������� ���޹��� Graphics�� �׷����� ǥ���ϱ� ���� �پ��� �޼ҵ���� ����
	public void paint(Graphics g) {  
		super.paint(g); //�׷����� �׸��� ���� �׷��Ƚ��� g�� ������ �����Ͽ� �ٽ� ����� ��ġ�� �׸�������
		//�׷����� �׸��� ���� �׷��Ƚ��� g�� ��,���ּ�,�̻��Ͽ� �����Ͽ� ����� ���ӿ� �׸����� ��
		enermy.draw(g); 
		spaceship.draw(g);
		missile.draw(g);
	}	
	//�гο��� Ű���尡 ��������
	public void keyPressed(KeyEvent event) {
		spaceship.KeyPressed(event);  //������ Ű�����̺�Ʈ�� ������ ���ּ����� ������
		missile.KeyPressed(event, spaceship.x, spaceship.y);	
		//������ Ű�����̺�Ʈ�� ������ ���ּ��� ��ġ�� �̻��Ͽ� ������
	}

	public void keyTyped(KeyEvent arg0) {}

	public void keyReleased(KeyEvent arg0) {}
}	
	