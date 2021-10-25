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
		
		if(p1.isOnePair() !=0) {
			System.out.println("player1은 원페어 입니다 "+ p1.isOnePair());
		}else {
			System.out.println("player1은 원페어가 아닙니다");
		}
		if(p2.isOnePair() !=0) {
			System.out.println("player2은 원페어 입니다 "+ p2.isOnePair());
		}else {
			System.out.println("player2은 원페어가 아닙니다");
		}
		
		p1.flush();
		p1.showCards();
		
	
	}

}
