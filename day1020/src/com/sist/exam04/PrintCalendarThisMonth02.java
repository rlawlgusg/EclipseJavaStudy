package com.sist.exam04;

import java.util.Calendar;

public class PrintCalendarThisMonth02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar today = Calendar.getInstance();

		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH);
		//�̴��� �޷��� ����ϱ� ���Ͽ� ���� �̴��� 1���� ������ �ݿ����̶��
		//�տ� ��ĭ�� 5�� ������ְ� ��¥�� ����ؾ���
		//�׷��� �̴��� 1���� ������ �˱� ���Ͽ� �̴��� 1���� Date��ü�� ������
	
		Calendar startDate = Calendar.getInstance();
		int date = startDate.get(Calendar.DATE);
		int day = startDate.get(Calendar.DAY_OF_WEEK);
		System.out.printf("%d�� %d��\n",year,month+1);
		System.out.println("��\t��\tȭ\t��\t��\t��\t��");
		
		int []lastDate = {31,28,31,30,31,30,31,31,30,31,30,31};
		
		
		//�� ���� 1���� ���ϸ�ŭ ��ĭ�� ���
		for(int i=1;i<day;i++) {
			System.out.print("\t");
		}
		
		
		for(int i=1;i<=lastDate[month-1];i++) {
			System.out.print(i +"\t");
			if((i+day)%7 == 0 ) {
				System.out.println();
			}
			
	//�޷���� ���α׷��� Calendar�� Gr`~~�� �̿��� ������ ����		
			
		}
	}
}
