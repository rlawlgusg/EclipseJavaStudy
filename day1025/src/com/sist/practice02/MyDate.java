package com.sist.practice02;

import java.util.StringTokenizer;

public class MyDate {
	String year, month, date;
	
	public MyDate(String str) {
		super();
		this.year = year;
		this.month = month;
		this.date = date;
	}

	@Override
	public String toString() {
		return   year +"년 " + month +"월 " + date+ "일 ";
	}
	
	public void mydate(String str)throws IllegalArgumentException {
		if(str.equals("")) {
			throw new IllegalArgumentException("문자열값이 없습니다");
		}
		
		StringTokenizer st = new StringTokenizer(str,"/");
		year = st.nextToken();
		month = st.nextToken();
		date = st.nextToken();
		
	}

	
	
	
	
	
}