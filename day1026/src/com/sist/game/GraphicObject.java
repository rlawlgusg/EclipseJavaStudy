package com.sist.game;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

//��,���ּ�,�̻��� Ŭ�������� ���������� ������ �� �Ӽ��� ������ �̾� �Ϲ�ȭ��
public class GraphicObject {
	BufferedImage img = null; //ȭ�鿡 �׸��� ǥ���ϱ� ���� ��ü
	
	int x=0, y=0; //�׸��� ��µ� ��ġ 
	
	//�����ÿ� �׷����̹��� ������ �Ű������� ���޹���
	public GraphicObject(String name) {
		//�Ű������� ���޹��� ���ϸ����� BufferedImage��ü�� ������
		try {
		img = ImageIO.read(new File(name));
		}catch(Exception e) {
			System.out.println("���ܹ߻� : "+e.getMessage());
			System.exit(0);
		}
	}
	//�׷����̹����� ��ġ�� �����ϱ� ���� �޼ҵ��̸� �ڽ�Ŭ�������� �ڽſ��� �µ��� �������Ұ���
	public void update() {}
	//����� ��ġ�� �̹����� �ٽ� �׸��� ���� �޼ҵ���
	public void draw(Graphics g) {
		g.drawImage(img,x,y,null); //x,y��ǥ�� �̹����� �׷���
	}
	//��,�̻���,���ּ� ������ ��ü���� keyPressed(Ű�� ������ ��)�� �ڽſ��� �µ��� �������̵�
	public void keyPressed(KeyEvent event) {}
	
}