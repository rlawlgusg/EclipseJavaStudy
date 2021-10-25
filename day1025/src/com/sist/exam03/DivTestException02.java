package com.sist.exam03;

//프로그램 실행시에 두개의 정수를 전달받아 나누기 한 결과를 출력하는 프로그램 작성
public class DivTestException02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		int div = a/b;
		System.out.println("결과: "+div);
		}catch(ArithmeticException e){
			System.out.println("분모가 0이 될 수는 없어요!");
		}catch(Exception e){
			System.out.println("나누기할 정수 두개를 전달해야 합니다");
		}finally {
			System.out.println("작업완료");
		}
	}

}
