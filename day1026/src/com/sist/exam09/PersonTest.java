package com.sist.exam09;

public class PersonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p = new Person("홍길동");
		Person p2 = new Person("유관순");
		//p.start();
		//Runnable 인터페이스에는 start메소드가 없음
		//Thread 객체로 포장해서 start()를 호출해야함 
	
//		Thread t = new Thread(p);
//		Thread t2 = new Thread(p2);
//		t.start();
//		t2.start();
		
		new Thread(p).start();
		new Thread(p2).start();
	}

}
