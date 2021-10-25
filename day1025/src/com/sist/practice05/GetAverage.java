package com.sist.practice05;
import java.util.Scanner;

public class GetAverage {
	public static void main(String[] args) {
		try {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("����� ���� ������ ������ �Է��ϼ���");
		int count = sc.nextInt();
		int []arr = new int[count];
		
		for(int i=0;i<arr.length;i++) {
			System.out.printf("%d��° ���� �Է��ϼ���: ",i+1);
			 arr[i] = sc.nextInt();
		}
			getAverage(arr);
			
			
		}catch(ArithmeticException e) {
			System.out.println("�и� 0���� ���� �� �����!"); //0
		}catch(NegativeArraySizeException e) {
			System.out.println("�迭�� ũ�Ⱑ �������� �� �� �����");//-1
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("�迭�� ������ �ʰ��Ͽ����ϴ�");//<=
		}catch(NullPointerException e) {
			System.out.println("�Է°��� �����ϴ�");//?
		}
	}
	
	public static void getAverage(int []arr) {
		int sum =0;
		int avg =0;
		for(int i=0;i<arr.length;i++) {
			sum += arr[i];
			avg = sum/arr.length;			
		}
		System.out.println("�迭�� ��հ��� "+avg+"�Դϴ�");
		
	}
	
	
	
	

	
	
	
	
}
