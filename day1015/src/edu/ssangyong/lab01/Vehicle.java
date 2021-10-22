package edu.ssangyong.lab01;

abstract class Vehicle {
	int speed=0; //1번
	public abstract double getKilosPerLiter();
	
	public void printSpeed(int speed) {
		System.out.println("현재 속도는 "+speed+"입니다"); //2번
	};
}
