package com.sist.exam01;

import java.util.Date;
import java.util.Scanner;

public class PrintCalendarThisMonth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("������ �Է��ϼ���");
		int year = sc.nextInt()
				
		System.out.println("���� �Է��ϼ���");
		int month = sc.nextInt();
		
		Date today = new Date();
		
		year = today.getYear()+1900;
		month = today.getMonth()-1;
		//�̴��� �޷��� ����ϱ� ���Ͽ� ���� �̴��� 1���� ������ �ݿ����̶��
		//�տ� ��ĭ�� 5�� ������ְ� ��¥�� ����ؾ���
		//�׷��� �̴��� 1���� ������ �˱� ���Ͽ� �̴��� 1���� Date��ü�� ������
		Date startDate = new Date(year,month,1);
		
		int day = startDate.getDay();
		System.out.printf("%d�� %d��\n",year+1900,month+1);
		System.out.println("��\t��\tȭ\t��\t��\t��\t��");
		
		int []lastDate = {31,28,31,30,31,30,31,31,30,31,30,31};
		
		
		//�� ���� 1���� ���ϸ�ŭ ��ĭ�� ���
		for(int i=1;i<=lastDate[month];i++) {
			System.out.print("\t");
		}
		
		
		for(int i=1;i<32;i++) {
			System.out.print(i +"\t");
			if((i+day)%7 == 0 ) {
				System.out.println();
			}
			
		
			
		}
	}
}
