package edu.ssangyong.programming07;

public class Triangle extends TwoDimShape {
	 double width=0;
	 double length=0;
	 String name;
	 
	 public Triangle(double width, double length) {
			super();
			this.width = width;
			this.length = length;
	}

	@Override
	public double getArea() {
		return (width * length)/2;
	}
	 
	 
	 
}
