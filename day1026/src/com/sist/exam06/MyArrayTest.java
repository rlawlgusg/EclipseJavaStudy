package com.sist.exam06;

public class MyArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		MyArray array = new MyArray();
		System.out.println("배열의 평균은 "+array.getAverage());
		}catch(NegativeArraySizeException e) {
			System.out.println("배열의 크기는 음수가 될 수 없어요");
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("예외발생 : 배열의 인덱스 범위를 넘었습니다");
		}catch(NullPointerException e) {
			System.out.println("예외발생 : 배열이 생성되지 않았습니다");
		}
		
		
	}

}
/*
1)이 프로그램에서 ArithmeticException은 언제 발생할 수 있나?
:배열의 길이가 0일때 
2)NegaiveArraySizeException은 언제발생?
:배열의 크기가 음수일때
3)ArrayIndexOutOfBoundsException
:배열의 인덱스 범위를 넘는 인덱스에 접근하려고 할때
4)NullPointerException
:배열변수를 선언하기만 하고 배열을 생성하지 않고 사용하려고 할때
*/