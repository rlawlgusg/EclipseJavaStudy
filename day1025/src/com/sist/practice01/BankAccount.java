package com.sist.practice01;

public class BankAccount {
	
	double balance;
	
	public double deposit(double amount) {
		balance += amount;
		return balance;
	}
	
	public double withdraw(double amount) throws NegativeBalanceException{
		if(amount > balance ) {
			throw new NegativeBalanceException("���� �ݾ��� �ܾ׺��� Ů�ϴ�");
		}
		balance -= amount;
		return balance;
		
	}
	
	
}
