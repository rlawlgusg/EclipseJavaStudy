package com.sist.exam08;

public class PersonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p = new Person("홍길동");
		Person p2 = new Person("유관순");
		
		p.start();
		p2.start();
		//쓰레드를 가동(동시에 공평하게 실행)시키려면 "start()"메소드를 호출
		//그런데 start를 호출하지 않고 run()을 직접 호출하면 쓰레드가 가동(공평하게 실행)
		//되지 않고 일반 메소드처럼 동작함
		//호출한 순서대로 쭉 실행됌 
	}

}
