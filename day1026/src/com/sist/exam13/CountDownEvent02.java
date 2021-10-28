package com.sist.exam13;

public class CountDownEvent02 implements Runnable {

		private int delay;
		private String msg;
			
		public CountDownEvent02 (int delay, String msg) {		
			this.delay = delay*1000;
			this.msg = msg;
		}
		
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(delay);
			System.out.println("น฿ป็");
		}catch(Exception e) {}	
		System.out.println(msg);
		
	}

}
