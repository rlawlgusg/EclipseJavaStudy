package com.sist.exam03;

public abstract class ThreeDimShape extends Shape {
	protected double volume;	
	
	public ThreeDimShape() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ThreeDimShape(int x, int y) {
		super(x, y);
	}

	public abstract double getVolume();
}
