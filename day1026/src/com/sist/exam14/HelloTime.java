package com.sist.exam14;

import java.util.Date;

public class HelloTime extends Thread {
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
				
			try {
				while(true) {
				Date date = new Date();
				System.out.println(date +" �ȳ��ϼ���");
				Thread.sleep(1000); //1000 = 1��
				}
				}catch(Exception e) {}
	}
	
	
	
	
	
}
