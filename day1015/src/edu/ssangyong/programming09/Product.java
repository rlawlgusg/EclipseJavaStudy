package edu.ssangyong.programming09;
public class Product {
	protected String name;
	protected int price;
	
	public double getPrice(){
		return price;
	}

	public Product() {
		super();
	}

	public Product(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return "[�̸� : " + name + ", ���� : " + price + "]";
	}
	
	
}
