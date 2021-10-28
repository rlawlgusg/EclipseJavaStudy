package com.sist.exam13;

import com.sist.exam11.CountDown;
import com.sist.exam12.CountDownEvent;

public class CountDownEventTest02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountDown countDown = new CountDown();
		CountDownEvent countDown02 = new CountDownEvent(2,"연결 장치 분리!");
		
		Thread thread = new Thread(countDown);
		Thread thread2 = new Thread(countDown02);
		//new Thread.start();
		thread.start();
		thread2.start();
		//발사 
		

	}

}
