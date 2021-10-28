package com.sist.exam01;

public class SetPriorityTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person kim = new Person("������");
		Person hong = new Person("ȫ�浿");
		Person lee = new Person("�̼���");
		//lee.setPriority(10);
		lee.setPriority(Thread.MAX_PRIORITY);
		//�ְ�켱������ �����Ͽ��ٰ� �ݵ�� ���� ���� ���� �������� ����
		//������ ���� ���� �����޶�� ���޼��� �����ϴ� �� ��
		//1,10
		kim.start();
		hong.start();
		lee.start();
		//kim,hong,lee �����尡 ��� ���������� ���
		try {
			kim.join();
			hong.join();
			lee.join();
		}catch(Exception e){}
		
		System.out.println("kim�� �켱����"+kim.getPriority());
		System.out.println("hong�� �켱����"+hong.getPriority());
		System.out.println("lee�� �켱����"+lee.getPriority());
	}

}
