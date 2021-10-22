package com.sist.exam13;

public class CarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car = new Car();
		car.printSpeed();
		car.speedUp(100);
		car.printSpeed();
		car.speedDown(100);
		car.printSpeed();
	
		
		Movable m = new Car();
		m.speedUp(100);
		//m.TurnLeft(); //ºÒ°¡´É..
		/*
		Car c = m;
		Car c = (Car)m;
		Car c = new Car();
		Movable m = c;
		Movable m = (Movable)c;
		*/
	}

}
