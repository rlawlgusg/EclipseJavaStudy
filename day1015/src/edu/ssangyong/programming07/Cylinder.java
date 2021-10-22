package edu.ssangyong.programming07;

public class Cylinder extends ThreeDimShape {
	double radius;
	double height;
	
	public Cylinder(double radius, double height) {
		super();
		this.radius = radius;
		this.height = height;
	}

	@Override
	public double getVolume() {
		return radius*radius*height*3.14;
	}
	
}
