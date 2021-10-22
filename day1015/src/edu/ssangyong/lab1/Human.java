package edu.ssangyong.lab1;

public abstract class Human {
	//1번
	protected String name;
	protected int age; 
	public String addr;
	//12번  private : 자손클래스인 Student에서 접근불가
	//     protected : 자식클래스인 Student에서 접근가능
	//      public : 어디서나 접근가능 
	//2번
	public Human() {
		System.out.println("부모클래스의 기본생성자 입니다");
	}
	public Human(String name, int age) {
		this.name = name;
		this.age = age;
		System.out.println("부모클래스의 매개변수 있는 생성자 입니다");
	}
	//3번
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	//4번
	public String toString() {
		return "이름 : "+ name + ", 나이 : " + age + "세";
	}
	//5번
	public static void main(String []args) {
	/*
		Human human1 = new Human("춘향", 18);
		Human human2 = new Human("몽룡", 21);
		Human human3 = new Human("사또", 50);
		
		System.out.println(human1);
		System.out.println(human2);
		System.out.println(human3);	
	추상클래스의 객체는 생성할 수 없어요! */
	}
	public abstract String getProfession(); //추상메소드
	
}
	
