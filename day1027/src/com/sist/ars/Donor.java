package com.sist.ars;

//�����ڸ� ���� Ŭ������ �����带 ��ӹ޾� ������
public class Donor extends Thread {
	private String name;	//�������� �̸��� ���� �������
	private Account tvArs;	//�����ڵ��� ��ݾ��� �����ϱ� ���Ͽ� ��������� ����
	//������ ��ü �����ÿ� �������� �̸��� ������ ��ݾ� ��ü�� �Ű������� ���޹޾� ��������� ������
	public Donor(String name,Account tvArs) {
		this.name = name;
		this.tvArs =tvArs;
	}
	//�����尡 �ؾ��� ���� run�� �������̵� �Ͽ� ���� 
	public void run() {
		for(int i=1; ;i++) {	 //��� �ݺ��Ͽ�
			
			//�Ա��ϱ� ���� ��ݾ��� 100000���� �Ѿ����� �ݺ����� Ż���ϵ��� ��
			if(tvArs.getBalance() >= 100000) {
				break;
			}
			
			tvArs.deposit(1000); //��ݾ� ��ü�� 1000���� �Ա���
			System.out.println(name+"��(��) "+i+"��° �Ա��Ͽ����ϴ�"); //���° �Ա��Ͽ����� �����
			try {	//0.2�� ����ϵ��� ��
				Thread.sleep(200);
			}catch(Exception e) {}
		}
	}
}

