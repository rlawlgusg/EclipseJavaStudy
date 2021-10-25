package com.sist.practice04;

import java.util.Scanner;

public class DivideByZeroTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number1, number2, result;
		
		Scanner sc= new Scanner(System.in);
		
		System.out.print("ù ��° ����: ");
		number1 = sc.nextInt();
		
		System.out.print("�� ��° ����: ");
		number2 = sc.nextInt();
		try {
		result = quotient(number1,number2);
		System.out.println(result);
		}catch(DivideByZeroException d) {
			System.out.println(d.getMessage());
		}
	}
//2��
	private static int quotient(int numerator, int denominator) throws DivideByZeroException {
		// TODO Auto-generated method stub
		if(denominator == 0)
			throw new DivideByZeroException("�и� 0���� ���� �� �����"); 
		return numerator / denominator;
	}

}
