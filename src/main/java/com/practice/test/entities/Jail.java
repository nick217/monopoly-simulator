package com.practice.test.entities;

public class Jail implements Cell {

	@Override
	public void performCellAction(Bank bank, Player player) {

		player.deductMoney(150);
		bank.addMoney(150);
	}

}
