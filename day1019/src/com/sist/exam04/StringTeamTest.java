package com.sist.exam04;
import java.util.Scanner;

import com.sist.eaxm03.Person;
public class StringTeamTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String email; 
		String text;
		String passward1;
		String passward2 = "1234567";
		Scanner sc = new Scanner(System.in);
		System.out.println("아이디를 입력하세요");
		email = sc.next();
		
		System.out.println(email.substring(0,(email.indexOf('@'))));
		//
		System.out.println("영문의 문장을 입력하세요");
		text = sc.next();
		int cnt = 0;
		for(int i=0 ; i<text.length() ; i++) {
			if(text.charAt(i) == 'o') {
					cnt++;
			}
		}
		System.out.println(cnt);
		
		System.out.println("아이디를 입력하세요");
		email = sc.next();
		System.out.println("비밀번호를 입력하세요");
		passward1 = sc.next();
		
		if(passward1.equals(passward2)) {
			System.out.println("올바른 암호 입니다");
		}else {
			System.out.println("암호가 올바르지 않습니다");
		}
		
		
	}

}
//팀 아이디만 추출
//영문의 문장 입력받아 소문자 o 개수
//아이디와 비밀번호 입력받아 로그인위한 프로그램 작성
