package com.sist.practice02;

public class MyDateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		String str = "2021/10/25";
		MyDate m = new MyDate(str);
		m.mydate(str);
		System.out.println(m);
		
		}catch(IllegalArgumentException i) {
			System.out.println("예외 발생: "+i.getMessage());
		}
		
		
		
	}

}
