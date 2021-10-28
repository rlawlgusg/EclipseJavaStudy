package com.sist.exam02;

public class MyDateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		//	String str = "2022/03/11";
			String str = null;
			MyDate lastdate = new MyDate(str);
			int year = lastdate.getYear();
			int month = lastdate.getMonth();
			int date = lastdate.getDate();
			System.out.printf("수료일은 %d년 %d월 %d일 입니다",year,month,date);
		}catch(IllegalArgumentException e) {
			//System.out.println("예외발생 : "+e.getMessage());
			e.printStackTrace();
		}
		
		
		
	}

}
