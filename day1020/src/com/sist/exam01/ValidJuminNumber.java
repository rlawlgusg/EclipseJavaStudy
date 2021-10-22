package com.sist.exam01;
import java.util.Scanner;
public class ValidJuminNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jumin;
		Scanner sc = new Scanner(System.in);
		System.out.println("주민번호를 입력하세요(하이픈을 입력하세요)");
		jumin = sc.next();
		
		int[]n = {2,3,4,5,6,7,0,8,9,2,3,4,5};
		//인덱스가 6번째는 계산에 참여하지 않음!
		//문자열의 길이는 14자 
		//반복실행해야하는 인덱스는 12
		int sum = 0;
		for(int i=0;i<jumin.length()-1;i++) {
			if(i != 6) {
			sum += Integer.parseInt(jumin.charAt(i)+"")*n[i]; //+""하면 문자열이 된다!
			}
		}
		
		sum = sum%11;
		sum = 11-sum;
		if(sum == 10) {
			sum = 0;
		}
		if(sum == 11) {
			sum = 1;
		}
		
		int ck = Integer.parseInt(jumin.charAt(13)+""); 
		// charAt은 바로 형변환 불가 +""을 붙여 문자열을 만들어 String으로 만들고서야 가능 
		//charAt의 결과는 char임.. char를 문자열(String)으로 만들기 위하여 빈문자 ""으로 더해줌 
		if(sum == ck) {
			System.out.println("올바른 주민번호 입니다");
		}else {
			System.out.println("올바른 주민번호가 아닙니다");
		}
		
		
	}

}
