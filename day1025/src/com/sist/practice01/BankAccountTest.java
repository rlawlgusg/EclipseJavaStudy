package com.sist.practice01;

public class BankAccountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		double balance = 0;
		BankAccount b = new BankAccount();
		balance = b.deposit(1000);
		balance = b.withdraw(1100);
		System.out.println("����ݾ�: "+balance);
		}catch(NegativeBalanceException n) {
			System.out.println("���ܹ߻�: "+n.getMessage());
		}
	}
}
