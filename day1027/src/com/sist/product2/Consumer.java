package com.sist.product2;

//�Һ��ڸ� ���� Ŭ������ ����
public class Consumer extends Thread {
	
	//��ǰ�� ���� Ŭ������ ��������� ������ 
	//�� ��ǰ��ü�� �����ڰ� ���� �ִ� ��ǰ�� ������ ��ü�� >���� ��ǰ�� �����ڿ����� �ϰ�����
	private Product product;
	
	//�Һ��ڰ�ü �����ÿ� ��ǰ��ü�� �Ű������� ���޹޾� ��������� ������ 
	public Consumer(Product product) {
		this.product = product;
	}
	
	//�����尡 �ؾ��� ���� run�� �������̵��Ͽ� ����
	public void run() {
		
		//�ݺ������Ͽ� 10���� ��ǰ�� �Һ��ϵ��� ��
		for(int i=1;i<=10;i++) {
			product.getNumber();//��ǰ(����)�� �Һ��ϱ� ���� getNumber �޼ҵ带 ȣ����
			try {
				Thread.sleep(300);
			}catch(Exception e) {}
		}
	}
	
	
	
	
	
	
	
	
}
