package com.sist.exam01;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class WordCountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String data;
		System.out.print("문장을 입력하세요:");
		data = sc.nextLine();//공백문자도 입력받기 위하여 nextLine사용
		//System.out.println(data);
		StringTokenizer st = new StringTokenizer(data);
		//입력문장을 공백문자로 분리
		TreeMap<String, Integer> map = new TreeMap<String, Integer>();
		//단어를 key로 하고 빈도수를 value로 하여 저장하기 위한 map을 생성 
		while(st.hasMoreElements()) { //입력문장으로 부터 분리한 단어만큼 반복 
			String word = st.nextToken(); //분리한 단어를 하나씩 꺼집어 내어옴 
			Integer cnt = map.get(word);//map으로 부터 단어의 빈도수를 꺼집어내옴 있으면 1 없으면 null
			if(cnt == null) { //만약에 그 단어가 map에 없다면 
				map.put(word, 1); //빈도수를 1로 설정하여 map에 추가 
			}else { //그렇지 않다면(이미 그 단어가 map에 있다면)
				map.put(word, cnt+1); //그 빈도수에 +1한 값으로 다시 설정
			}
		}
		
		//System.out.println(map);
	
		//map에 있는 모든 key목록을 set으로 반환함
		//map에 있는 자료만큼 반복수행하기 위해서 map의 모든 키 목록을 읽어옴 
		Set<String> KeyList = map.keySet();
		//set자체에는 반복수행 하기 위한 기능이 없음...그래서
		//set의 자료를 하나씩 꺼집어 내어 오기 위하여 Iterator로 만들어야함
		Iterator<String> iter = KeyList.iterator();
		
		while(iter.hasNext()) { 
		//단어별 빈도수가 담겨 있는 map의 key목록을 담고있는 iterateor의 데이터가 있는 만큼 반복실행
			String word = iter.next(); //iterator로부터 데이터를 꺼내오면 단어임 그 단어는 map의 key
			int cnt = map.get(word); //map으로부터 그 단어(key)의 빈도수(value)를 꺼내옴 
			System.out.printf("%20s %d\n",word,cnt); //출력 
		}
	}

}
