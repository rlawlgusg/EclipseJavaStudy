package com.sist.exam01;

class Animal{
	
}

class Lion extends Animal{
	
}

class Tiger extends Animal{
	
}


public class Cage {
	private Object animal;
	
	public Object getAnimal() {
		return animal;
	}

	public void setAnimal(Object animal) {
		this.animal = animal;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cage cage = new Cage();
		cage.setAnimal(new Lion());
		//Lion lion = cage.getAnimal();
		// Lion�� Object�� ��Ӱ��迡 ������ 
		//�ڽ��� ���������� �θ�ü�� ������ ���� ���� 
		
		//�����ϰ� �Ϸ��� �ڽ�Ŭ���������� ��ȯ�� ������ �� ����
		//Lion lion = (Lion)cage.getAnimal();
		
		//Tiger tiger = (Tiger)cage.getAnimal();
		//cage�� Lion�� �ְ� �����ö��� Tiger�� ��ȯ >>������ ������ �߻� X
		//����ÿ� ���� �߻� 
		/*
		  Exception in thread "main" java.lang.ClassCastException: class com.sist.exam01.
		  Lion cannot be cast to class com.sist.exam01.Tiger (com.sist.exam01.Lion and com.sist.exam01.
		  Tiger are in unnamed module of loader 'app')
		  at com.sist.exam01.Cage.main(Cage.java:40)

		 */
		
		
		
		
	}

}
