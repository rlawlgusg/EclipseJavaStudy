package com.sist.game;

public class CardGame02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//CardDeck ��ü�� ������
		//�����ڿ� ���ؼ� 52���� ī�尡 ������ 
		CardDeck deck = new CardDeck();
		//ī�带 ���� ������
		deck.shuffle();
		//ī������� �� ����ڸ� �θ� ������
		Player p1 = new Player();
		Player p2 = new Player();
		
		for(int i=1;i<=7;i++) {
			p1.getCard(deck.deal());
			p2.getCard(deck.deal());
		}
		
		//ù��° ����� ī�带 �����
		p1.showCards();
		//�ι�° ����� ī�带 �����
		p2.showCards();
			
		
		int n1 = p1.pairProcess("Player1");
		int n2 = p2.pairProcess("Player2");
		
		if(n1==n2) {
			System.out.println("�����ϴ�");
		}else if(n1 > n2) {
			System.out.println("Player1�� �̰���ϴ�");
		}else {
			System.out.println("Player2�� �̰���ϴ�");
		}
	
	
	}

}
