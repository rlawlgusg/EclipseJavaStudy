package com.sist.exam04;

import java.util.Calendar;

public class PrintCalendarThisMonth02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar today = Calendar.getInstance();

		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH);
		//이달의 달력을 출력하기 위하여 만약 이달의 1일의 요일이 금요일이라면
		//앞에 빈칸을 5개 출력해주고 날짜를 출력해야함
		//그래서 이달의 1일의 요일을 알기 위하여 이달의 1일의 Date객체를 생성함
	
		Calendar startDate = Calendar.getInstance();
		int date = startDate.get(Calendar.DATE);
		int day = startDate.get(Calendar.DAY_OF_WEEK);
		System.out.printf("%d년 %d월\n",year,month+1);
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		
		int []lastDate = {31,28,31,30,31,30,31,31,30,31,30,31};
		
		
		//그 달의 1일의 요일만큼 빈칸을 출력
		for(int i=1;i<day;i++) {
			System.out.print("\t");
		}
		
		
		for(int i=1;i<=lastDate[month-1];i++) {
			System.out.print(i +"\t");
			if((i+day)%7 == 0 ) {
				System.out.println();
			}
			
	//달력출력 프로그램을 Calendar나 Gr`~~를 이용한 것으로 수정		
			
		}
	}
}
