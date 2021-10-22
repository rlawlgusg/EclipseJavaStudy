package com.sist.exam13;

interface Movable {
	final int speed = 100; 
	public abstract void speedUp(int amount);
	public abstract void speedDown(int amount);
	
	public abstract void printSpeed();

}
