package com.sist.product2;

import java.util.Random;

//�����ڿ� �Һ��ڰ� ������ ��ǰŬ������ ���� 
public class Product {
	
	//����Ǵ� ��ǰ�� ������ ����
	int number;
	
	//��ǰ�� ���� �����Ͽ����� �Һ��Ͽ����� �Ǻ��ϱ� ���� ����
	//�����ڰ� ���ο� ��ǰ�� �����ϸ� true�� ����
	//�Һ��ڰ� ��ǰ�� �Һ��ϸ� false�� ����
	public boolean isNew = false;
	
	
	//�����ڰ� ����� ���ο� ��ǰ�� �����ϴ� �޼ҵ� ����
	//�����ڰ� ��ǰ�� �����ϰ� �ִ� ���ȿ��� �Һ��ڰ� ������ �� ������ �ϱ� ���Ͽ� �Ӱ迵������ ����
	public synchronized void makeNumber() {
		Random r = new Random();
		number = r.nextInt(100);  //���ο� ��ǰ ����
		System.out.println("�����ڰ� ���ο� ��ǰ ������"+number);
	}
	
	//�Һ��ڰ� ����� ��ǰ�� �Һ��ϱ� ���� �޼ҵ带 ����
	public synchronized int getNumber() {
		
		System.out.println("�Һ��ڰ� ��ǰ �Һ���"+number); //�Һ��ڰ� ��ǰ�� �Һ���
		return number;
	}
	
	
	
	
	
	
}
