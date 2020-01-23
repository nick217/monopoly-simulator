package com.practice.test.entities;

public class Bank {

	private static Bank instance = new Bank();

	private int balance;

	private Bank() {
		balance = 5000;
	}

	public static Bank getInstance() {
		return instance;
	}

	public int getBalance() {
		return balance;
	}

	public void addMoney(int amount) {
		balance += amount;
	}

	public void deductMoney(int amount) {
		balance -= amount;
	}

}
