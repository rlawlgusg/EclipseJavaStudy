package com.sist.exam01;

public interface Movable {
	int speed = 100; 
	//기본이 final인데 초기화하지 않으면 에러
	//반드시 초기값을 주어야한다!
	public abstract void speedUp(int amount);
	public abstract void speedDown(int amount);
	
	public void printspeed() {
		System.out.println("현재속도"+speed);
	}
	//인터페이스는 바디가 구체화된 메소드를 만들 수 없음
}
