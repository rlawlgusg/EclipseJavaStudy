package com.sist.product2;

//소비자를 위한 클래스를 만듬
public class Consumer extends Thread {
	
	//제품을 위한 클래스를 멤버변수로 선언함 
	//이 제품객체는 생산자가 갖고 있는 제품과 동일한 객체임 >서로 제품을 공유자원으로 하고있음
	private Product product;
	
	//소비자객체 생성시에 제품객체를 매개변수로 전달받아 멤버변수에 대입함 
	public Consumer(Product product) {
		this.product = product;
	}
	
	//쓰레드가 해야할 일을 run을 오버라이딩하여 써줌
	public void run() {
		
		//반복실행하여 10개의 제품을 소비하도록 함
		for(int i=1;i<=10;i++) {
			product.getNumber();//제품(정수)를 소비하기 위한 getNumber 메소드를 호출함
			try {
				Thread.sleep(300);
			}catch(Exception e) {}
		}
	}
	
	
	
	
	
	
	
	
}
