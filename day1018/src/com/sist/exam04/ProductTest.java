package com.sist.exam04;

public class ProductTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Product product = new Product("에어프라이기", 300000);
		System.out.println(product);
		System.out.println(product.getPrice());
		
		DiscountProduct discountProduct = new DiscountProduct("에어프라이기", 300000, 0.1);
		System.out.println(discountProduct);
		System.out.println(discountProduct.getPrice());
		
	}

}
