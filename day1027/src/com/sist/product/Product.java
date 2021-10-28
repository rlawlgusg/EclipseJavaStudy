package com.sist.product;

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
		
		//새로운제품(정수)를 생산하기 전에 소비가 일어나지 않는 동안 대기상태로 있도록 함
		//소비자가 제품을 소비하고 isNew에 false를 설정하고 notify로 깨워주면 반복문을 탈출
		while(isNew == true) { 
			try{
				wait();
			}catch(Exception e) {}
		}
		//새로운 제품(정수)은 난수로 만들어 봄
		Random r = new Random();
		number = r.nextInt(100);  //새로운 제품 생산
		System.out.println("생산자가 새로운 제품 생성함"+number);
		isNew = true;			  //새로운 제품이 생산되었다는 표시로 isNew를 true로 설정
		notify();				  //대기중인 쓰레드(소비자)를 깨워줌 
	}
	
	//소비자가 사용할 제품을 소비하기 위한 메소드를 정의
	public synchronized void getNumber() {
		
		//생산자가 새로운 제품을 생산할 때 까지 대기상태로 있도록 함(새로운 제품을 생산하지 않는 동안)
		//생산자가 새로운 제품을 생산하고 isNew에 true를 담고 notify로 깨워주면 반복문 탈출
		while(isNew == false) {
			try{
				wait();
			}catch(Exception e) {}
		}
		
		
		System.out.println("소비자가 제품 소비함"+number); //소비자가 제품을 소비함
		isNew = false;//소비자가 제품을 소비하였다는 표시로 isNew에 false를 저장함
		notify();	  //대기중인 생산자를 깨워줌
	//	return number;
	}
	
	
	
	
	
	
}
