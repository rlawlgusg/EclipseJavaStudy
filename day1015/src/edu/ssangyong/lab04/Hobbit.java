package edu.ssangyong.lab04;

public class Hobbit extends GameCharacter {

	@Override
	public void draw() {
		System.out.println("호빗을 그립니다.");
	}

	public void getRing() {
		System.out.println("GameCharacter()의 getRing()");
	}
	
}
