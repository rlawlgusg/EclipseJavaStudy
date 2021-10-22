package com.sist.eaxm03;
import java.util.Scanner;
public class StringPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String email;
		int index;
		Scanner sc = new Scanner(System.in);
		System.out.println("이메일을 입력하시오");
		email = sc.next();
		
		if(email.indexOf('@') == -1) {
			System.out.println("올바른 이메일이 아닙니다");
		}else{
			System.out.println("올바른 이메일 입니다");
		}
	}

}
