package com.sist.inputoutput;

import java.io.FileReader;

public class ReadFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//아까 생성한 c:/myData/hello.text파일의 내용을 읽어 들여
		//화면에 출력해 봄
		try {
			FileReader fr = new FileReader("c:/myData/hello.txt");
			int ch;
			
			while((ch=fr.read()) != -1) {
			System.out.print((char)ch);
			}
			fr.close();
			}catch(Exception e) {
				System.out.println("예외발생:"+e.getMessage());
			}
		
	}

}
