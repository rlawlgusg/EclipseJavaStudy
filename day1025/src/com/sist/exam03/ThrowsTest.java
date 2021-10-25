package com.sist.exam03;

public class ThrowsTest {
	
	public static void div(int a, int b) throws ArithmeticException{
		int r = a/b;
		System.out.println("나누기결과: "+r);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
		div(4,2);	
		}catch(ArithmeticException e) {
			System.out.println("0으로 나눌 수 없어요!");
		}	
		
	
	}

}
