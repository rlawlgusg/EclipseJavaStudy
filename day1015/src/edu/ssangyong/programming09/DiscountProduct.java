package edu.ssangyong.programming09;

public class DiscountProduct extends Product {	
	int discount=0;//할인율 
	@Override
	public double getPrice() {	
		return super.getPrice()-getPrice()*discount*0.01;
	}
	
	public DiscountProduct() {
		super();
	}
	
	public DiscountProduct(String name, int price, int discount) {
		super(name, price);
		this.discount = discount;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "할인율 : " + discount + ", 이름 : " + name + ", 가격 : " + getPrice() + "]";
	}
	
	public static void main(String []args) {
		Product p1 = new Product("toothbrush", 3000);
//에러	Product p2 = new Product("toothbrush", 3000, 15);
		System.out.println(p1.getPrice());
		
	}
}
