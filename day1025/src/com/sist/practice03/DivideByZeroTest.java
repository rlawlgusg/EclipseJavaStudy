package com.sist.practice03;
import java.util.Scanner;
public class DivideByZeroTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		int number1, number2, result;
		
		Scanner sc= new Scanner(System.in);
		
		System.out.print("첫 번째 정수: ");
		number1 = sc.nextInt();
		
		System.out.print("두 번째 정수: ");
		number2 = sc.nextInt();
		
		result = number1 / number2;
		System.out.println(result);
		//2번
		}catch(Exception e) {
			System.out.println("잘못된 입력값 입니다");
			System.out.println(e.getMessage());
			e.printStackTrace(); //4번 예외메세지가 뜸
		//3번
		}finally {
			System.out.println("작업완료!");
		}
			
//1번 
//1)4  2)InputMismatchException int에 String값을 넣음 3)ArithmeticException 분모를 0으로 나눌 수 없음
		
	}

}
