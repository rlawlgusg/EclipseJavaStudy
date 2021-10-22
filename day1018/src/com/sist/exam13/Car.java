package com.sist.exam13;

class Car implements Movable{

	@Override
	public void speedUp(int amount) {
		amount++;
		System.out.println("향상된 스피드는" +amount);
	}

	@Override
	public void speedDown(int amount) {
		amount--;
		System.out.println("감소된 스피드는 "+amount);
		
	}

	@Override
	public void printSpeed() {
		System.out.println("현재 스피드는 "+speed+"입니다");		
	}
	
	public void TurnLeft() {
		System.out.println("좌회전 합니다");
	}
	
	public void TurnRight() {
		System.out.println("우회전 합니다");
	}
	
	
}
