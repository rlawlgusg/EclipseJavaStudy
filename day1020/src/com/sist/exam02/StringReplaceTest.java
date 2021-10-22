package com.sist.exam02;
import java.util.Scanner;
public class StringReplaceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String n;
		Scanner sc = new Scanner(System.in);
		System.out.println("문자열을 입력하시오");
		n = sc.next();
		System.out.println(n.replace("hello","안녕"));
	}

	

}
