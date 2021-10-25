package com.sist.practice05;
import java.util.Scanner;

public class GetAverage {
	public static void main(String[] args) {
		try {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("평균을 구할 정수의 개수를 입력하세요");
		int count = sc.nextInt();
		int []arr = new int[count];
		
		for(int i=0;i<arr.length;i++) {
			System.out.printf("%d번째 값을 입력하세요: ",i+1);
			 arr[i] = sc.nextInt();
		}
			getAverage(arr);
			
			
		}catch(ArithmeticException e) {
			System.out.println("분모를 0으로 나눌 수 없어요!"); //0
		}catch(NegativeArraySizeException e) {
			System.out.println("배열의 크기가 음수값이 될 수 없어요");//-1
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("배열의 범위를 초과하였습니다");//<=
		}catch(NullPointerException e) {
			System.out.println("입력값이 없습니다");//?
		}
	}
	
	public static void getAverage(int []arr) {
		int sum =0;
		int avg =0;
		for(int i=0;i<arr.length;i++) {
			sum += arr[i];
			avg = sum/arr.length;			
		}
		System.out.println("배열의 평균값은 "+avg+"입니다");
		
	}
	
	
	
	

	
	
	
	
}
