package com.sist.practice03;
import java.util.Scanner;
public class DivideByZeroTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		int number1, number2, result;
		
		Scanner sc= new Scanner(System.in);
		
		System.out.print("ù ��° ����: ");
		number1 = sc.nextInt();
		
		System.out.print("�� ��° ����: ");
		number2 = sc.nextInt();
		
		result = number1 / number2;
		System.out.println(result);
		//2��
		}catch(Exception e) {
			System.out.println("�߸��� �Է°� �Դϴ�");
			System.out.println(e.getMessage());
			e.printStackTrace(); //4�� ���ܸ޼����� ��
		//3��
		}finally {
			System.out.println("�۾��Ϸ�!");
		}
			
//1�� 
//1)4  2)InputMismatchException int�� String���� ���� 3)ArithmeticException �и� 0���� ���� �� ����
		
	}

}
