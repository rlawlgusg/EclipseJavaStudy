package edu.ssangyong.programming07;

public class Cube extends ThreeDimShape {
	 double width=0;
	 double length=0;
	 double height=0;
	
		public Cube(double width, double length, double height) {
		super();
		this.width = width;
		this.length = length;
		this.height = height;
	}

		@Override
		public double getVolume() {
			return width*length*height;
	}
}
