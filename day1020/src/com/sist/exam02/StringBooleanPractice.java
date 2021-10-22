package com.sist.exam02;
import java.util.Scanner;
public class StringBooleanPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name;
		Scanner sc = new Scanner(System.in);
		System.out.println("ÀÌ¸§À» ÀÔ·ÂÇÏ¼¼¿ä");
		name = sc.next();
		if(name.startsWith("±è")) {
			System.out.println("±è¾¾ÀÔ´Ï´Ù");
		}else {
			System.out.println("±è¾¾°¡ ¾Æ´Õ´Ï´Ù");
		}
	}
}
