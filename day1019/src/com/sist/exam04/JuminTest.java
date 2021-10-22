package com.sist.exam04;
import java.util.Scanner;
public class JuminTest {
//오류 ㅜ
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jumin = "111111-1111111";
		int sum = 0;

		int []arr = {2,3,4,5,6,7,8,9,2,3,4,5};//12자리
		int []juminarr = new int [13]; //에서 주민번호 끝자리ㅣ빼야함
		Scanner sc = new Scanner(System.in);
		System.out.println("-를 포함하여 주민번호를 입력하세요");
		jumin = sc.next();
		
		if(jumin.length() != 14) {
			System.out.println("주민번호의 자리수가 틀렸습니다");
		}else {
			if(jumin.charAt(7)=='1' || jumin.charAt(7) =='2' || jumin.charAt(7) =='3'|| jumin.charAt(7) =='4') {
				for(int i=0;i<juminarr.length-1;i++) {
					jumin = jumin.replace("-", ""); //replace 대체 
					jumin.trim();
					juminarr[i] = Integer.parseInt((jumin).substring(i));
					sum += juminarr[i]*arr[i];
				}
				juminarr[12] = 11-(sum%11);
				if(juminarr[12] == (11-(sum%11))%10) { //10은 0, 11은 1로표기
					System.out.println("검증된 주민번호입니다!!!!!!!!!!!!!!");
				}else {
					System.out.println("위조된 주민번호");
				}			
			}else {
				System.out.println("잘못된 주민번호 입니다");
			}
		}
		
		
		
	
		
		
		
	}

}
