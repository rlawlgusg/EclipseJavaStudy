package com.sist.exam14;

import java.util.Date;

public class HelloTime extends Thread {
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
				
			try {
				while(true) {
				Date date = new Date();
				System.out.println(date +" 안녕하세요");
				Thread.sleep(1000); //1000 = 1초
				}
				}catch(Exception e) {}
	}
	
	
	
	
	
}
