package com.sist.eaxm03;
import java.util.Scanner;

public class StringPractice02 {
	public static void main(String []args) {
	Scanner sc = new Scanner(System.in);
	String passward1;
	String passward2;
	
	System.out.println("암호를 입력하세요");
	passward1 = sc.next();
	System.out.println("암호확인을 입력하세요");
	passward2 = sc.next();
	
	if(passward1.equals(passward2) && passward1.length() >=8 && passward1.length() <=12) {
			System.out.println("올바른 암호 입니다");
	}else {
		System.out.println("암호의 길이를 8자이상 12자이하로 만들어주세요!");
	}
	
	}
}
