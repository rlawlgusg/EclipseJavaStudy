package edu.ssangyong.lab04;

public class Test {

	public static void main(String[] args) {
		GameCharacter g = new Hobbit();
//is a ���迡 ���� �� �θ��� ���������� �ڽ� Ŭ������ ��ü�� ���� ����
		g.getLife(); 
//3�� ��ü�� �޼����� ������ �ڽ��� Ŭ�������� ����ã�� ������ �θ�Ŭ������ �޼ҵ尡 ������
//  	g.getRing(); 
//4�� is a ���迡 ���� �� �θ��� ���������� �ڽ�Ŭ������ ��ü�� ���� �� �� ������ �ڽ�Ŭ�������� ���Ӱ� �߰��� �޼ҵ带 �ٷ� ȣ�� �� �� ����
//�θ�Ŭ�������� �������� ���� �޼ҵ��̱� ������ �θ�Ŭ������ ���������� �ڽ�Ŭ������ �޼ҵ带 ã�� �� ����
		((Hobbit)g).getRing(); 
//5�� is a ���迡 ���� �� �θ��� ���������� �ڽ�Ŭ������ ��ü�� ���� �� �� 
//ȣ���Ϸ��� HobbitŬ������ ����������ȯ�Ͽ� HobbitŬ������ �޼ҵ带 ȣ��
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
	�����߻� = �迭�ȿ��� ȣ��, Ÿ��ź, �ּ��絵 �ִµ� ������� ȣ������ ����ȯ�߱� ������ �����߻�!
	ȣ������ ����� ����ȯ �ؾ���!
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
				((Hobbit)obj[i]).draw();	//����ȯ
			}else if(obj[i] instanceof Titan) { 
				((Titan)obj[i]).draw();			//����ȯ
			}else if(obj[i] instanceof Sourcerer) {	
				((Sourcerer)obj[i]).draw();			//����ȯ
			}	
		}		
	}
	*/
	
}


