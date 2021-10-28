package com.sist.inputoutput;

import java.io.FileWriter;

public class PrintFileHello {

	public static void main(String[] args) {
		// 나의 이름과 나이를 파일로 기록해 봄
		
		//문자단위의 출력을 위한 writer의 후손중에
		//파일로 출력을 위한 FileWriter를 생성해봄
		try {					
		FileWriter fw = new FileWriter("c:/myData/hello.txt");
		fw.write("나의 이름은 홍길동이고\n");
		fw.write("나이는 20살 입니다.");
		
		//파일의 사용이 끝나면 파일을 닫아주어야 함
		//닫아 주지 않으면 지금 당장 오류가 나지 않을 수 있지만
		//이 파일을 만약에 다른곳에서도 써야한다면 여기서 닫아주지 않으면 다른 곳에서
		//쓸 수 없는 상황이 됌
		fw.close();
		System.out.println("파일을 생성하였습니다");
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		
		
		
	}

}
//프로그램완성 
//너무 일찍 끝나면 바이트단위의 입출력 실험