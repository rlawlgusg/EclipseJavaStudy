package com.sist.exam04;

import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String []arr = {"��","��","ȭ","��","��","��","��"};
		Date today = new Date();
		int year = today.getYear()+1900;
		int month = today.getMonth() +1;
		int date = today.getDate();
		int hours = today.getHours();
		int minutes = today.getMinutes();
		int seconds = today.getSeconds();
		int day = today.getDay();
		String yoil = arr[day];
		
		//�ڵ忡 ��Ҽ��� �׾����� ���� ������ �ڹٹ��������� Date���ٴ� Calendar�� GregorianCalendar��
		//����ϱ⸦ �����ؼ� �׷�..�����ص� ����!
		System.out.println(day);
		System.out.printf("����� %d�� %d�� %d�� (%s����) %d�� %d�� %d���Դϴ�\n",year,month,date,yoil,hours,minutes,seconds);
	
		
		
		int year1 = 1995;
		int month2 = 9;
		int date3 = 1;
		Date birth = new Date(year1-1900,month2-1,date3);
		int day4 = birth.getDay();
		System.out.println(birth);
		System.out.println(day4);
		System.out.printf("�������� �¾ ���� %s���� �Դϴ�",arr[day4]);
	
	
	}

}
