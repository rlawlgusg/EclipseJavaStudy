package com.sist.exam04;

import java.util.Date;

public class System_CurrentTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long data = System.currentTimeMillis();
		
		System.out.println(data);
		//1634715380082
		//1634715412935
		
		//��¥�� ���� �뵵�ε� ���������
		//��������� �뵵�ε� �����
		Date today = new Date(data);
		
		//long data2 = 1634715380082;
		//�ڹٴ� �������� ���� ���� ������ int�� ����ؿ� �׷��� int�� ������ �Ѿ��ٰ� ��������
		//���������� long�� ǥ���ϱ� ���Ͽ� ���̻� l�� ����
		long data2 = 1634715380082l;
		Date date = new Date(data2);
		
		System.out.printf("���ݽð�:%d�� %d�� %d��",today.getHours(),today.getMinutes(),today.getSeconds());)
		System.out.printf("�Ʊ�ð�:%d�� %d�� %d��",date.getHours(),date.getMinutes(),date.getSeconds());
	}

}
