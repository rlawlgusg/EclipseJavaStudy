package com.sist.exam04;

import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String []arr = {"일","월","화","수","목","금","토"};
		Date today = new Date();
		int year = today.getYear()+1900;
		int month = today.getMonth() +1;
		int date = today.getDate();
		int hours = today.getHours();
		int minutes = today.getMinutes();
		int seconds = today.getSeconds();
		int day = today.getDay();
		String yoil = arr[day];
		
		//코드에 취소선이 그어지는 것은 지금의 자바버전에서는 Date보다는 Calendar나 GregorianCalendar를
		//사용하기를 권장해서 그럼..무시해도 좋음!
		System.out.println(day);
		System.out.printf("현재는 %d년 %d월 %d일 (%s요일) %d시 %d분 %d초입니다\n",year,month,date,yoil,hours,minutes,seconds);
	
		
		
		int year1 = 1995;
		int month2 = 9;
		int date3 = 1;
		Date birth = new Date(year1-1900,month2-1,date3);
		int day4 = birth.getDay();
		System.out.println(birth);
		System.out.println(day4);
		System.out.printf("김지현이 태어난 날은 %s요일 입니다",arr[day4]);
	
	
	}

}
