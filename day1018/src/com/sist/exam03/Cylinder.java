package com.sist.exam03;

public class Cylinder extends ThreeDimShape {
	private double radius;
	private double height;
	
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}

	public Cylinder(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}


	public Cylinder(int x, int y, double radius, double height) {
		super(x, y);
		this.radius = radius;
		this.height = height;
	}

	public Cylinder() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Cylinder [radius=" + radius + ", height=" + height + ", volume=" + volume + ", x=" + x + ", y=" + y
				+ "]";
	}

	@Override
	public double getVolume() {
		// TODO Auto-generated method stub
		volume = Math.PI*Math.pow(radius, 2)*height;
		return  volume;
	}

}
