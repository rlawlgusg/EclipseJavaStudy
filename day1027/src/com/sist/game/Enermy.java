package com.sist.game;

import java.io.File;
import java.util.Random;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Enermy extends GraphicObject {
	
	
	
	//���� x������ �����̴� ������ ���� ����
	//��ó������ �����ʳ����� �������� �����̵��� �ϱ� ���Ͽ� ������ ����
	//int dx = -10;
	//int dy = 10;
	
	//���� �̵���θ� ������ ����
	int dx;
	int dy;
	
	//�����ÿ� ������ ǥ���� �׷��� �����̸��� �Ű������� ���޹޾� �θ�Ŭ������ �����ڿ��� ������
	public Enermy(String name) {
		super(name);
		
	//��ó���� ���α׷� �����Ͽ������� ���� ��ġ�� ������ ��ܿ� ��ġ��Ű�� ���Ͽ�
	//x = 500, y = 0 ���� ������ 
	//	x = 500;
	//	y = 0;
		Random r = new Random();
	//��ó���� ���� ��ġ�� ������ ������
		x = r.nextInt(500);
		y = r.nextInt(300);
		
	//���� �̵���ΰ��� �����ÿ� ������ ����
	//�̵��ϴ� �ּҰ�:
	//�̵��ϴ� �ִ밪:
	//� ������ ���� 90���� ���� �������� 10�� ����
		
		dx = r.nextInt() % 90; 
		dy = r.nextInt() % 90; 
		
		//x������ ���� ���������� ��ȣ�� �ٲ���
		if(x<0 || x>500) {
			dx = dx*-1;
		}
		//y������ ���� ���������� ��ȣ�� �ٲ���
		if(y<0 || y>=300) {
			dy = dy*-1;
		}
		
		/*
		if(dx>=0) {
			dx += 10;
		}else {
			dx -= 10;
		}
		if(dy>=0) {
			dy += 10;
		}else {
			dy -= 10;
		}
		*/
		
		System.out.println("x"+dx);
		System.out.println("y"+dy);
	}
	

	public void update() {
		//x��ǥ�� dx��ŭ �����Ŵ
		x += dx;
		y += dy;
		
		//���� ���ʳ��� �����ϸ� ���������� �̵���Ű�� ���Ͽ� dx�� ����� ����
		if(x < 0) {
			dx = +10;
		}
		//���� ������ ���� �����ϸ� �ٽ� �������� �̵���Ű�� ���Ͽ� dx�� ������ ����
		if(x > 500) {
			dx = -10;
		}
		
		if(y >= 400) {
			dy = -10;
		}
		
		if(y < 0) {
			dy = +10;
		}
	}
		//���� �̻��Ͽ� �¾Ҵ��� �Ǻ��ϴ� �޼ҵ�
		
		public void crush(Missile missile){
			//���� �̻��Ͽ� �¾Ҵ��� �Ǻ�
			if(missile.x >= x && missile.x <= x+74 && missile.y >= y && missile.y<=y+73){
				System.out.println("���� �¾Ҿ��!");
				File file = new File("EXPLODE.WAV");
				try {
					//����� ������ �о���� ���� �غ�
					Clip clip = AudioSystem.getClip();	
					//����� ������ �о��
					clip.open(AudioSystem.getAudioInputStream(file));
					//����� ������ ��� 
					clip.start();
				}catch(Exception e) {}
				
				
				
				
				
				
				
				y = -1000;
			}
		
		
		
		}

		
		
	
	
}
