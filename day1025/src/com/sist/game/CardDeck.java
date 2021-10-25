package com.sist.game;

import java.util.ArrayList;
import java.util.Collections;

//ī������� ���Ͽ� 52���� ī�带 �׾Ƶΰ� 
//����ڰ� ī�带 �ϳ��� ���� �� �ִ� �޼ҵ带 ���� Ŭ������ ����
public class CardDeck {
	//Card�� ���� �� �ִ� ArrayList�� ����
	private ArrayList<Card> deck = new ArrayList<Card>();
	
	//�����ڿ��� CardDeck�� ��������� deck�� 52���� ī�带 ������ �㵵�� ��
	public CardDeck() {
		String []suit = {"Clubs","Diamonds","Hearts","Spades"}; 
		//ī���� 4������ �迭�� ����
		String []number = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
		//ī����� 13������ �迭�� ���� 
		
		//��ø�ݺ����� �̿��Ͽ� 52���� ī�带 �����Ͽ� deck�� ����..
		for(int i=0;i<suit.length;i++) {//ī���縸ŭ �ݺ���
			for(int j=0;j<number.length;j++) {//ī����ڸ�ŭ �ݺ���
				deck.add(new Card(suit[i],number[j]));
			}	
		}
		/*deck�� ����غ�..
		System.out.println(deck);	
		shuffle();
		System.out.println(deck);
		Card c1 = deal();
		System.out.println(c1);
		System.out.println(deck);
		Card c2 = deal();
		System.out.println(c2);
		System.out.println(deck);*/
	}
	//52���� ī�尡 ������� ���� �� ������ ���ؼ� ī�带 �������� �����ִ� �޼ҵ� ����
	public void shuffle() {
			Collections.shuffle(deck);
	}
	
	//52���� ī�尡 �ִ� deck�κ��� ī�带 �ϳ��� �̾ƿ��� �޼ҵ带 ����
	//�̾ƿ��� deck���� ���������
	//�׻� deck �� ù��° ��Ҹ� �̾ƿ����� �� deck�� 0��° �ε����� ��Ҹ� �̾Ƽ� ����� ��ȯ
	public Card deal() {
		return deck.remove(0); //��ó���� ȣ���ϸ� 52���� ī���߿� 0��°�� ��ȯ 
							   //�ι�° ȣ���ϸ� 51���� ī���߿� 0��°�� ��ȯ
	}
	//ArrayList�� remove�޼ҵ�� 
	//�ε����� ��ġ�� �����͸� �����ϰ� 
	//������ �����͸� ��ȯ�ϴ� �޼ҵ� 
	
}
