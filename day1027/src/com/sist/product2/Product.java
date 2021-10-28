package com.sist.product2;

import java.util.Random;

//생산자와 소비자가 공유할 제품클래스를 만듬 
public class Product {
	
	//생산되는 제품을 임의의 정수
	int number;
	
	//제품을 새로 생산하였는지 소비하였는지 판별하기 위한 변수
	//생산자가 새로운 제품을 생산하면 true를 설정
	//소비자가 제품을 소비하면 false를 설정
	public boolean isNew = false;
	
	
	//생산자가 사용할 새로운 제품을 생성하는 메소드 정의
	//생산자가 제품을 생산하고 있는 동안에는 소비자가 접근할 수 없도록 하기 위하여 임계영역으로 설정
	public synchronized void makeNumber() {
		Random r = new Random();
		number = r.nextInt(100);  //새로운 제품 생산
		System.out.println("생산자가 새로운 제품 생성함"+number);
	}
	
	//소비자가 사용할 제품을 소비하기 위한 메소드를 정의
	public synchronized int getNumber() {
		
		System.out.println("소비자가 제품 소비함"+number); //소비자가 제품을 소비함
		return number;
	}
	
	
	
	
	
	
}
