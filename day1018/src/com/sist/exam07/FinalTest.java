package com.sist.exam07;

class Person{
	public String name = "홍길동";
	public final String addr = "서울시 마포구 서교동";
}



public class FinalTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person hong = new Person();
		System.out.println(hong.name);
		System.out.println(hong.addr);
		
		hong.name = "홍두식"; 
		//hong.addr = "제주도 서귀포시 애월읍"; 
		//클래스의 final은 상수이기 때문에 값을 변경할 수 없음 
		System.out.println(hong.name);
		System.out.println(hong.addr);

	}

}
