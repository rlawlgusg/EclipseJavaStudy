package com.sist.exam10;

//final클래스는 상속할 수 없음!
public class ColorRect extends Rect {
	private String color;

	public ColorRect(double width, double height, String color) {
		super(width, height);
		this.color = color;
	}
	
	public void info() {
		System.out.println("가로: "+width+", 세로: "+height +", 면적: "+area+", 색상: "+color);
	}
	/*
	public void calcArea() {	
	}
	부모클래스의 final메소드는 오버라이딩 할 수 없음!*/
}
