//finally : try- catch문과 함께 선언해야하며 try-catch문의 제일 마지막에 위치
//예외처리가 발생여부를 떠나 무조건 실행하도록 하는 구문
//try블록에서 예외가 발생하면 실행 중지 후, catch블록으로 이동하여 예외처리 코드를 실행
//그 후에 finally블록의 코드를 실행함 
//try, catch블록에서 return문을 사용하더라도 finally블록은 항상 실행된다

package com.sist.exam03;

public class  TryCatchFinally
{
	public static void main(String[] args) 
	{
		try{
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		int result = a/b;
		System.out.println("결과: "+result);
		}catch(Exception e){
			System.out.println("두번째수가 0이 아닌 두개의 숫자를 전달해 주세요");
		}finally {
			System.out.println("결과를 다시 선언합니다");
			System.out.println("마지막에 무조건 실행되어야하는 메소드!!");
		}

	
	}
}

