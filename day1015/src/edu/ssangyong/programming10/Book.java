package edu.ssangyong.programming10;

import java.util.Objects;

public class Book {
	protected String number;
	protected String title;
	protected String author;
	protected int fee;
	
	public Book() {}

	public Book(String number, String title, String author) {
		this.number = number;
		this.title = title;
		this.author = author;
	}
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
//�� ����� Member ��ü�� Object �ڷ����� ���� obj�� ���� -> ������
//Member ��ü�� Object �ڷ��� ������ ����Ǹ�
//->���� ������ ��� ����
//->������ Member ��ü�� ����ȯ �ʿ�
//->(�ڽ��ڷ���Ŭ����)�θ��ڷ�������
//instanceof������ : ����ȯ�� �������� Ȯ�����ִ� ������, ����ȯ �ϱ� ���� ������ ���, ������� boolean��(true/false)
	
	@Override
	public boolean equals(Object obj) {
		boolean result=false; 
		if (obj instanceof Book) { 
	       Book b = (Book)obj; 
	       if(number.equals(b.number)) { 
	         result = true;
	       }
		} 
	     return result;
	}
	//equals()�� �������̵� �ϸ� hashCode()�� �������̵� �ؾ��Ѵ�?
	public int hashCode() {
		return Objects.hash(number, title, author);
	}
	
	public int getLateFees(int latedate) {
		return fee*latedate; 
	}
	
	
}