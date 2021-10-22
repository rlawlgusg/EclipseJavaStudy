package com.sist.exam06;

public abstract class Vehicle {
	
	protected int speed;
	//추상클래스는 추상메소드이외에 일반속성을 포함 가능! 
	
	public void printSpeed() {
		System.out.println("현재속도:"+speed);
	}
	//추상클래스는 추상메소드 말고도 body가 구체화된 일반 메소드를 포함할 수 있음!
	public abstract double getKillosPerLiter();
		
}
