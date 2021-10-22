package edu.ssangyong.programming07;

public class Ellipse extends TwoDimShape {
	double radius=0;
	String name;

	public Ellipse(double radius) {
		super();
		this.radius = radius;
	}


	@Override
	public double getArea() {
		return radius*radius*3.14;
	}



	


}
