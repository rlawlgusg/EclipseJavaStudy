package com.sist.game;

public class CardGame02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//CardDeck 객체를 생성함
		//생성자에 의해서 52개의 카드가 생성됌 
		CardDeck deck = new CardDeck();
		//카드를 골고루 섞어줌
		deck.shuffle();
		//카드게임을 할 경기자를 두명 생성함
		Player p1 = new Player();
		Player p2 = new Player();
		
		for(int i=1;i<=7;i++) {
			p1.getCard(deck.deal());
			p2.getCard(deck.deal());
		}
		
		//첫번째 사람이 카드를 출력줌
		p1.showCards();
		//두번째 사람이 카드를 출력줌
		p2.showCards();
			
		
		int n1 = p1.pairProcess("Player1");
		int n2 = p2.pairProcess("Player2");
		
		if(n1==n2) {
			System.out.println("비겼습니다");
		}else if(n1 > n2) {
			System.out.println("Player1이 이겼습니다");
		}else {
			System.out.println("Player2가 이겼습니다");
		}
	
	
	}

}
