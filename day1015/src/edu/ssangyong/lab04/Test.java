package edu.ssangyong.lab04;

public class Test {

	public static void main(String[] args) {
		GameCharacter g = new Hobbit();
//is a 관계에 있을 때 부모의 참조변수가 자식 클래스의 객체를 참조 가능
		g.getLife(); 
//3번 객체가 메세지를 받으면 자신의 클래스에서 먼저찾고 없으면 부모클래스의 메소드가 동작함
//  	g.getRing(); 
//4번 is a 관계에 있을 때 부모의 참조변수가 자식클래스의 객체를 참조 할 수 있지만 자식클래스에서 새롭게 추가한 메소드를 바로 호출 할 수 없음
//부모클래스에는 생성되지 않은 메소드이기 때문에 부모클래스의 참조변수가 자식클래스의 메소드를 찾을 수 없다
		((Hobbit)g).getRing(); 
//5번 is a 관계에 있을 때 부모의 참조변수가 자식클래스의 객체를 참조 할 때 
//호출하려면 Hobbit클래스로 참조변수변환하여 Hobbit클래스의 메소드를 호출
		/*
		GameCharacter arr[] = new GameCharacter[6];
		arr[0] = new Hobbit();
		arr[1] = new Hobbit();
		arr[2] = new Titan();
		arr[3] = new Titan();
		arr[4] = new Sourcerer();
		arr[5] = new Sourcerer();
		*/
		GameCharacter []arr = {
				new Hobbit(),
				new Hobbit(),
				new Titan(),
				new Titan(),
				new Sourcerer(),
				new Sourcerer()
		};
		
		Test.drawAll(arr);
	}
	/*
	public static void drawAll(GameCharacter []arr) {
		for(GameCharacter character : arr) {
			character.draw();
			((Hobbit)Character).getRing();
			
		}
	}
	오류발생 = 배열안에는 호빗, 타이탄, 주술사도 있는데 덮어놓고 호빗으로 형변환했기 때문에 오류발생!
	호빗인지 물어보고 형변환 해야함!
	*/
	public static void drawAll(GameCharacter []arr) {
		for(GameCharacter character : arr) {
			character.draw();
			if(character instanceof Hobbit) {
			((Hobbit)character).getRing();
			}
		}
	}
	
	/*
	public static void drawAll(Object[] obj) {
		for(int i=0;i<obj.length;i++) {
			if(obj[i] instanceof Hobbit) { 
				((Hobbit)obj[i]).draw();	//형변환
			}else if(obj[i] instanceof Titan) { 
				((Titan)obj[i]).draw();			//형변환
			}else if(obj[i] instanceof Sourcerer) {	
				((Sourcerer)obj[i]).draw();			//형변환
			}	
		}		
	}
	*/
	
}


