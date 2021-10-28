package com.sist.exam11;

public class CountDownTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountDown countDown = new CountDown();
		Thread thread = new Thread(countDown);
		//new Thread.start();
		thread.start();
	}

}
