package com.sist.product;
//�����ڸ� ���� Ŭ������ ����
public class Producer extends Thread {
	//��ǰ�� ���� Ŭ������ ��������� ����
	private Product product;
	
	//������ ��ü �����ÿ� ��ǰ��ü�� �Ű������� ���޹޾� ������� ��ǰ�� �ʱ�ȭ�� 
	public Producer(Product product) {
		this.product = product;
	}
	
	//������ Ŭ������ ����Ͽ� ���ο� ��ǰ�� �����ϱ� ���� �޼ҵ带 ȣ���Ű�� ���Ͽ�
	//�����尡 �ؾ��ϴ� ���� run�޼ҵ带 �������̵��Ͽ� ���� 
	public void run() {
		
		//10���� ���ο� ��ǰ�� �����ϵ��� ��
		for(int i=1;i<=10;i++) {
			product.makeNumber();//���ο� ��ǰ(����)�� �����ϱ� ���Ͽ� ��ǰ��ü�� makeNumber�� �޼ҵ带 ȣ����
			try {
				Thread.sleep(200);
			}catch(Exception e) {}
		}
	}



}
