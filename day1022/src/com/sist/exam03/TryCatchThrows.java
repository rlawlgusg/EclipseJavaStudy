//throws도 예외처리를 위해 사용 
//예외를 상위쪽으로 미루어 처리
//메소드 선언부끝에 작성 메소드에서 처리하지 않은 예외를 호출한 곳으로 떠넘김
package com.sist.exam03;

class ThrowsTest{
	
	public static void test(String a,String b) throws NumberFormatException{
		int sum = Integer.parseInt(a)+Integer.parseInt(b);
		System.out.printf(a,b);
	} 
}

public class TryCatchThrows {

	public static void main(String[] args) {
	
		
		ThrowsTest test = new ThrowsTest();
		try {
			ThrowsTest.test("1", "ㄱ");
		}catch(NumberFormatException e) {
			System.out.println("잘못된 입력값 입니다");
		}
		

	}

}
