package com.sist.game;

import java.util.ArrayList;
import java.util.HashMap;

public class Player {
	
	//������ �ϴ� ����ڰ� CardDeck�� ���� ī�带 �ϳ��� �����ͼ� ���� ����Ʈ�� ����
	private ArrayList<Card> list = new ArrayList<Card>();
	
	//ī�带 �Ű������� �޾Ƽ� ���� list�� ����
	public void getCard(Card card) {
		list.add(card);
	}
	//��������� �Ǻ��Ͽ�
	//���� �̰���� ó���Ϸ���
	//������� ���ڸ� ��ȯ�Ϸ�����
	//���ڰ� 2~10������ Integer.parseInt()�ϸ� ������ ����� �ִµ� ��������
	//�׷��� ī���� ���ڰ� "Jack",'Queen","King","Ace"�̷��͵��� Integer.parseInt�� ����
	//�׷��� "2"�� key�� �ϰ� 2�� value�� �ϴ� map�� ���� �޿� �����
	//"Jack"�̶�� key���� 11�̶�� value�� ���� 
	public int isOnePair() {
		//ī���� ���ڸ� map�� key����
		String []number = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
		//map�� �����
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		//"2"�� ���� value�� ���� 2�� �� �׸��� 1�� ������ų���� 
		int value =2;
		//ī���� ���� �迭��ŭ �ݺ�����
		for(int i=0;i<number.length;i++) {
			map.put(number[i], value++);//map�� key�� ī���� ���ڷ�, value�� 2���� 1�������� ��
		}
		
		int n = 0;
		for(int i=0;i<list.size();i++) {
			for(int j=i+1;j<list.size();j++) {
				//i��° ī���� ���ڿ� j��° ī���� ���ڰ� �������� �Ǻ�
				if(list.get(i).getNumber().equals(list.get(j).getNumber())) {
					//������ ī���� ����(���ڿ�)�� �ش��ϴ� ������ �����κ��� �̾ƿ� 
					n = map.get(list.get(i).getNumber());
					return n;
				
				}
			}
		}
		return n;
		
	}
	
	//���� ī�带 ��� �����
	public void showCards() {
		System.out.println(list);
	}
	



}
