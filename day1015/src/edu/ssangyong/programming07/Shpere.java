package edu.ssangyong.programming07;

public class Shpere extends ThreeDimShape {
	double radius;
	
	
	public Shpere(double radius) {
		super();
		this.radius = radius;
	}


	@Override
	public double getVolume() {
		return (4*3.14*radius*radius*radius)/3;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
