package com.sist.exam06;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//��ǻ���ϰ� ������ϰ� ����,����,�� ������ �ϴ� ���α׷��� �ۼ�
		//��ǻ�Ͱ� ����,����,�� �߿� �ϳ��� �ڵ����� ����̱��ϵ��� �ؾ���
		//�׸��� ��������� ����,����,�� �߿� �ϳ��� �Է¹޵��� �ؾ��� 
		Scanner sc = new Scanner(System.in);
		//0:����, 1:����, 2:�� 
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(0, "����");
		map.put(1, "����");
		map.put(2, "��");
		
		//���������
		Random r = new Random();
		int com = r.nextInt(3);
		
		System.out.println("0:���� 1:���� 2:��");
		System.out.print("�����ϼ���");
		int user = sc.nextInt();
		
		System.out.println("��ǻ�ʹ� "+map.get(com)+"�� �������ϴ�");
		System.out.println("����� "+map.get(user)+"�� �������ϴ�");
		
		if(com == user) {
			System.out.println("�������������� �����ϴ�!");
		}
		else if(user == 0 && com == 2 || user == 1 && com ==0 ||user == 2 && com == 1) {
			System.out.println("����� �̰���ϴ�");
		}else {
			System.out.println("��ǻ�Ͱ� �̰���ϴ�");
		}
			
			
	}

}
