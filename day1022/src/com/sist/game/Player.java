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
		int pair = 0;
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
	
	public String flush() {
		int flush =0;
		String s = "";
		for(int i=0;i<list.size();i++) {
			for(int j=i;j<list.size()-1;j++) {
				if(list.get(i).getSuit()==(list.get(j+1).getSuit())) { 
					//if(suit[0]==suit[1] && suit[1]==suit[2] &&
					 // suit[2] == suit[3] && suit[3]==suit[4])
					flush++;
					
					if(flush == 5) {
					s = list.get(i).getSuit();//5개부터야 되는데 왜 4개부터 나오지?
					return s;
					}
				}
			}
		}
		return s;
		
		
	}
	
	//나의 카드를 모두 출력함
	public void showCards() {
		System.out.println(list);
	}
	



}

//투페어: 2쌍의 페어,원페어가 2개 존재 
//스트레이트: 숫자가 이어지는 카드 5장 5,4,3,2,A는 낮은 스트레이트 A,K,Q,J,10은 높은 스트레이트...?
//플러쉬: 무늬가 같은 카드 5장 