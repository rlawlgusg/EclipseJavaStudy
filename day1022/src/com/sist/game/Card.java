package com.sist.game;


//카드게임을 위하여 "카드"를 표현하기 위한 클래스를 만듬

public class Card {
	private String suit; //카드모양을 위한 멤버변수
	private String number; //카드숫자를 위한 멤버변수
	public Card(String suit, String number) { 
		//생성시에 카드모양과 카드숫자를 매개변수로 받아 초기화함
		super();
		this.suit = suit;
		this.number = number;
	}
	public Card() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() { //카드의 모양과 숫자를 문자열로 반환
		return "[" + suit + "," + number + "]";
	}
	public String getSuit() {
		return suit;
	}
	public void setSuit(String suit) {
		this.suit = suit;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	
}
