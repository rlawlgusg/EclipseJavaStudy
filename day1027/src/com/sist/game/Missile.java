package com.sist.game;

import java.awt.event.KeyEvent;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Missile extends GraphicObject {
	
	//�̻����� �߻� �Ǿ����� �Ǻ��ϱ� ���� ����
	boolean launched = false;
	
	//�����ÿ� �̹��������̸��� �Ű������� ���޹޾� 
	public Missile(String name) {
		//�θ��� �����ڿ��� ������
		super(name);
		y = -200;
		// TODO Auto-generated constructor stub
	}
	
	public void update() {
		//���࿡ �̻����� �߻� �Ǿ��ٸ� y��ǥ�� 1�� ������
		if(launched) {
			y -= 10;
		}
		//�̻����� y��ǥ�� ȭ���� ���� �Ⱥ��̴� �����̸� launched�� false�� ����
		if(y < -100) {
			launched = false;
		}
	}
	
	//Ű���尡 �������� ���� ���ּ��� �ִ� ��ġ x,y ��ǥ���� ���� ����Ͽ�
	//�̻����� �߻��Ű�� ���Ͽ� KeyPressed�޼ҵ带 �������̵� ��
	//���� �Ű������� ���޹޴� keyevent event�� ���ؼ� � key�� ���������� �� �� ����
	//�� �Ű����� x,y�� ���ּ��� x,y��ġ�� ���޹���
	public void KeyPressed(KeyEvent event,int x,int y) {
		
		if(event.getKeyCode() == KeyEvent.VK_SPACE) {
			
			launched = true; //�̻����� �߻��Ű�� ���Ͽ� launched�� true�� ����
			//�̻����� x,y��ǥ�� ���ּ��� x,y�� ������ 
			this.x = x;
			this.y = y;
			
			//�̻����� �߻�ɶ� �Ҹ��� ������
			
			//�Ҹ����� ��ü ����
			File file = new File("LASER.WAV");
			try {
				//����� ������ �о���� ���� �غ�
				Clip clip = AudioSystem.getClip();	
				//����� ������ �о��
				clip.open(AudioSystem.getAudioInputStream(file));
				//����� ������ ��� 
				clip.start();
			}catch(Exception e) {}

			
			
		}
	}
}
