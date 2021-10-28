package com.sist.exam12;

import com.sist.exam11.CountDown;
import com.sist.exam12.CountDownEvent;

public class CountDownEventTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountDown countDown = new CountDown();
		Thread thread = new Thread(countDown);
	
		//new Thread.start();
		thread.start();
		
		

	}

}
