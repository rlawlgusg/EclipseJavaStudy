package com.sist.exam04;

import java.util.Scanner;

public class DivideByZeroTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number1,number2,result;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("첫번째 정수: ");
		number1 = sc.nextInt();
		
		System.out.println("두번째 정수: ");
		number2 = sc.nextInt();
		
		result = number1/number2;
		System.out.println(result);
		
		
		
	}

}
