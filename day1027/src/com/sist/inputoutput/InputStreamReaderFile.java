package com.sist.inputoutput;

import java.io.FileInputStream;


public class InputStreamReaderFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
		FileInputStream f = new FileInputStream("c:/myData/hello.txt");
			byte[] b = new byte[f.available()];
			int ch = f.read(b);
			
			
			while((ch=f.read()) != -1) {
				System.out.print((char)ch);
				}
			
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		
		
	}

}
