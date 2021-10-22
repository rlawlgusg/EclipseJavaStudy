package com.sist.exam04;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Calendar today = new Calendar();
		//Calendar today = Calendar.getInstance();
		GregorianCalendar today = new GregorianCalendar();
		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH);
		int date = today.get(Calendar.DAY_OF_MONTH);
		
		System.out.printf("오늘은 %d년 %d월 %d일 입니다",year, month+1, date);
		
		
	}

}
