package edu.ssangyong.lab1;

public abstract class Human {
	//1��
	protected String name;
	protected int age; 
	public String addr;
	//12��  private : �ڼ�Ŭ������ Student���� ���ٺҰ�
	//     protected : �ڽ�Ŭ������ Student���� ���ٰ���
	//      public : ��𼭳� ���ٰ��� 
	//2��
	public Human() {
		System.out.println("�θ�Ŭ������ �⺻������ �Դϴ�");
	}
	public Human(String name, int age) {
		this.name = name;
		this.age = age;
		System.out.println("�θ�Ŭ������ �Ű����� �ִ� ������ �Դϴ�");
	}
	//3��
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
	//4��
	public String toString() {
		return "�̸� : "+ name + ", ���� : " + age + "��";
	}
	//5��
	public static void main(String []args) {
	/*
		Human human1 = new Human("����", 18);
		Human human2 = new Human("����", 21);
		Human human3 = new Human("���", 50);
		
		System.out.println(human1);
		System.out.println(human2);
		System.out.println(human3);	
	�߻�Ŭ������ ��ü�� ������ �� �����! */
	}
	public abstract String getProfession(); //�߻�޼ҵ�
	
}
	
