package com.sist.exam04;

import java.util.Date;

public class System_CurrentTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long data = System.currentTimeMillis();
		
		System.out.println(data);
		//1634715380082
		//1634715412935
		
		//날짜를 위한 용도로도 사용하지만
		//난수만들기 용도로도 사용함
		Date today = new Date(data);
		
		//long data2 = 1634715380082;
		//자바는 정수형의 값이 오면 무조건 int로 취급해요 그래서 int의 범위를 넘었다고 에러가남
		//정수형값에 long을 표시하기 위하여 접미사 l을 붙임
		long data2 = 1634715380082l;
		Date date = new Date(data2);
		
		System.out.printf("지금시간:%d시 %d분 %d초",today.getHours(),today.getMinutes(),today.getSeconds());)
		System.out.printf("아까시간:%d시 %d분 %d초",date.getHours(),date.getMinutes(),date.getSeconds());
	}

}
