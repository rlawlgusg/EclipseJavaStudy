package com.sist.product2;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//제품객체를 생성함
		Product product = new Product();
		
		
		//생산자쓰레드객체를 생성함
		Producer producer = new Producer(product);
		
		
		//소비자쓰레드객체를 생성함
		Consumer consumer = new Consumer(product);
		
		
		
		//생산자와 소비자를 가동함
		producer.start();
		consumer.start();
		
	
		
		
		
		
	}

}
