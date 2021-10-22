package edu.ssangyong.programming07;

public class Rectangle extends TwoDimShape {
	 double width=0;
	 double length=0;
	 String name;
	 	
	public Rectangle(double width, double length) {
		super();
		this.width = width;
		this.length = length;
		
	}


	@Override
	public double getArea() {
		return width*length;
	}
	 	
}
