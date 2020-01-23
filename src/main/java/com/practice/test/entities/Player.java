package com.practice.test.entities;

public class Player {

	private int money;
	private int assetValue;

	public Player() {
		money = 1000;
		assetValue = 0;
	}

	public void deductMoney(int amount) {

		money -= amount;

	}

	public void addMoney(int amount) {
		money += amount;
	}

	public void increaseAssetValueBy(int amount) {
		assetValue += amount;
	}

	public int getAssetValue() {
		return assetValue;
	}

	public boolean hasRequiredMoney(int amount) {
		return amount <= money ? true : false;
	}

	@Override
	public String toString() {
		return "Player [money=" + money + ", assetValue=" + assetValue + "]";
	}

}
