package edu.ssangyong.lab01;

abstract class Vehicle {
	int speed=0; //1��
	public abstract double getKilosPerLiter();
	
	public void printSpeed(int speed) {
		System.out.println("���� �ӵ��� "+speed+"�Դϴ�"); //2��
	};
}
