package com.sist.exam01;

public class BankAccount {
	private int balance;
	
	public void deposit(int amount) {
		balance += amount;
		System.out.printf("%d원을 입금하여 잔액이 %d원이 되었습니다\n",amount,balance);
	}
	
	public void withdraw(int amount) throws NegativeBalanceException {
		if(amount>balance) {
			throw new NegativeBalanceException("잔액이 부족합니다");
		}
		balance -= amount;
		System.out.printf("%d원을 출금하여 잔액이 %d원이 되었습니다\n",amount,balance);
	}
}
