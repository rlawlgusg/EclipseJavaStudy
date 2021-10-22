package com.sist.eaxm03;

class Person{
	private String name;
	private int age;
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
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Person() {
		super();
	}
	
}


public class StringTestPerson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person []arr = {
				new Person("tiger",20),
				new Person("lion",21),
				new Person("Tiger",23),
				new Person(" Tiger ",23),
				new Person("kim",25)
		};
		//이름이 tiger인 사람이 모두 몇명인지 조사해봄...
		int cnt = 0;
		for(Person p : arr) {
			if(p.getName().trim().equalsIgnoreCase("tiger"))
					cnt++;
		}
		System.out.println(cnt);
	
	
	}

	
	
}
