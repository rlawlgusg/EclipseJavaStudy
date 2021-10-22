package com.sist.exam06;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//컴퓨터하고 사용자하고 가위,바위,보 게임을 하는 프로그램을 작성
		//컴퓨터가 가위,바위,보 중에 하나를 자동으로 제비뽑기하도록 해야함
		//그리고 사용자한테 가위,바위,보 중에 하나를 입력받도록 해야함 
		Scanner sc = new Scanner(System.in);
		//0:가위, 1:바위, 2:보 
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(0, "가위");
		map.put(1, "바위");
		map.put(2, "보");
		
		//난수만들기
		Random r = new Random();
		int com = r.nextInt(3);
		
		System.out.println("0:가위 1:바위 2:보");
		System.out.print("선택하세요");
		int user = sc.nextInt();
		
		System.out.println("컴퓨터는 "+map.get(com)+"를 내었습니다");
		System.out.println("당신은 "+map.get(user)+"를 내었습니다");
		
		if(com == user) {
			System.out.println("가위바위보에서 비겼습니다!");
		}
		else if(user == 0 && com == 2 || user == 1 && com ==0 ||user == 2 && com == 1) {
			System.out.println("당신이 이겼습니다");
		}else {
			System.out.println("컴퓨터가 이겼습니다");
		}
			
			
	}

}
