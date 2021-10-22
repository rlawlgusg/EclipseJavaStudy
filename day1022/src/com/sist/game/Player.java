package com.sist.game;

import java.util.ArrayList;
import java.util.HashMap;

public class Player {
	
	//게임을 하는 경기자가 CardDeck로 부터 카드를 하나씩 가져와서 담을 리스트를 만듬
	private ArrayList<Card> list = new ArrayList<Card>();
	
	//카드를 매개변수로 받아서 나의 list에 담음
	public void getCard(Card card) {
		list.add(card);
	}
	//원페어인지 판별하여
	//누가 이겼는지 처리하려면
	//원페어인 숫자를 반환하려고함
	//숫자가 2~10까지는 Integer.parseInt()하면 정수로 만들어 주는데 문제없음
	//그런데 카드의 숫자가 "Jack",'Queen","King","Ace"이런것들은 Integer.parseInt로 못함
	//그래서 "2"를 key로 하고 2를 value로 하는 map을 만듬 쭈욱 만들면
	//"Jack"이라는 key에서 11이라는 value를 담음 
	public int isOnePair() {
		//카드의 숫자를 map의 key로함
		String []number = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
		//map을 만들고
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		//"2"에 대한 value를 숫자 2로 함 그리고 1씩 증가시킬거임 
		int value =2;
		//카드의 숫자 배열만큼 반복실행
		for(int i=0;i<number.length;i++) {
			map.put(number[i], value++);//map에 key는 카드의 숫자로, value는 2부터 1씩증가한 값
		}
		
		int n = 0;
		for(int i=0;i<list.size();i++) {
			for(int j=i+1;j<list.size();j++) {
				//i번째 카드의 숫자와 j번째 카드의 숫자가 동일한지 판별
				if(list.get(i).getNumber().equals(list.get(j).getNumber())) {
					//동일한 카드의 숫자(문자열)에 해당하는 정수를 맵으로부터 뽑아옴 
					n = map.get(list.get(i).getNumber());
					return n;
				
				}
			}
		}
		return n;
		
	}
	
	//나의 카드를 모두 출력함
	public void showCards() {
		System.out.println(list);
	}
	



}
