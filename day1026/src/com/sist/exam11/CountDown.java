package com.sist.exam11;

public class CountDown implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=20;i>=1;i--) {
			System.out.println(i+"�� ���Դϴ�.");
			try {
				Thread.sleep(1000);
				}catch(Exception e) {}
		}
	}

}
