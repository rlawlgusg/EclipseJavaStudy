package com.sist.exam04;
import java.util.Scanner;
import java.util.Date;
public class StringCancerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   Scanner sc = new Scanner(System.in);
		   Date today = new Date();
		   String name;
		   String idnumber;
		   int thisYear = today.getYear()+1900;
		  
		   System.out.println("이름을 입력하세요");
		   name = sc.next();
		   System.out.println("- 포함하여 주민등록번호를 입력하세요");
		   idnumber = sc.next();
		   int age = thisYear- (1900+ Integer.parseInt(idnumber.substring(0, 2))+1);
		   int userYear = 1900+ Integer.parseInt(idnumber.substring(0,2));
		  
		if(thisYear % 2 == userYear % 2 && age >= 40) {
			System.out.println(name +"님," +thisYear+"년도에 무료 암검진 대상자이며");
				if(idnumber.charAt(7) == '1' && age<50) {
					if(age<50) {
					System.out.println("검진항목은 위암, 간암입니다.");
					}else if(age>=50) {
					System.out.println("검진항목은 위암, 간암, 대장암입니다");
					}	
				}
				if(idnumber.charAt(7) == '2') {
					if(age<50) {
					System.out.println("검진항목은 위암, 간암, 유방암, 자궁암 입니다.");
					}else if(age>=50) {
					System.out.println("검진항목은 위암, 간암, 대장암, 유방암, 자궁암 입니다");
				}
		}else {
			System.out.println(name + "님은 무료암검진 대상자가 아닙니다.");
			}	  
		}
	}
}

