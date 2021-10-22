package com.sist.exam04;
import java.util.Calendar;
import java.util.Scanner;

public class CalendarPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int year=0;
		int month=0;
		int start_day_of_week=0;
		
		System.out.println("년도를 입력하세요");
		year = sc.nextInt();
		System.out.println("월을 입력하세요");
		month = sc.nextInt();
		
		Calendar StartDay = Calendar.getInstance();
		
		StartDay.set(year, Calendar.MONTH+1, 1);
		
		start_day_of_week = StartDay.get(Calendar.DAY_OF_WEEK);
		System.out.println(start_day_of_week);//요일 확인용
		int []lastDate = {31,28,31,30,31,30,31,31,30,31,30,31};
		
		
		
		System.out.printf("%d년 %d월\n",year,month);
		
		
		String []day = {"일","월","화","수","목","금","토"};
		
		for(int i=0;i<day.length;i++) {
			System.out.print(day[i]+"\t");
		}
			System.out.println();
		
		for(int i=1;i<start_day_of_week;i++) {
			System.out.print("\t");
		}
		
		for(int i=1;i<=lastDate[month-1];i++) {
			System.out.print(i +"\t");
			if((i + start_day_of_week-1)%7 == 0 ) {
				System.out.println();
			}

		
			}
		}
	}

