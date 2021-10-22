package com.sist.exam02;

public class StringTestValueOf {
	
	public static void pro(String str) {
		System.out.println(str);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//위와 같이 어떠한 메소드는 String만 매개변수로 갖는 메소드가 있다고 함
		//
		
		int data = 2021;
		//정수형 데이타 data를 갖고 pro를 호출해야 하는 상황이라고 가정
		//pro는 String을 매개변수로 갖기 때문에 바로 호출할 수는 없고 
		//data를 String으로 변환해야함!!
		//pro(data);
		pro(String.valueOf(data));
		pro(data+"");
	}

}
