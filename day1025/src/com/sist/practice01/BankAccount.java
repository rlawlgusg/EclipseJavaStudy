package com.sist.practice01;

public class BankAccount {
	
	double balance;
	
	public double deposit(double amount) {
		balance += amount;
		return balance;
	}
	
	public double withdraw(double amount) throws NegativeBalanceException{
		if(amount > balance ) {
			throw new NegativeBalanceException("인출 금액이 잔액보다 큽니다");
		}
		balance -= amount;
		return balance;
		
	}
	
	
}
