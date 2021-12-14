package com.sist.vo;

public class GoodsVo {
	private int no;
	private String name;
	private int qty;
	private int price;
	public GoodsVo(int no, String name, int qty, int price) {
		super();
		this.no = no;
		this.name = name;
		this.qty = qty;
		this.price = price;
	}
	public GoodsVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Goods [no=" + no + ", name=" + name + ", qty=" + qty + ", price=" + price + "]";
	}
	
	
	
}
