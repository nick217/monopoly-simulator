package com.practice.test.entities;

public class Lottery implements Cell {

	@Override
	public void performCellAction(Bank bank, Player player) {
		bank.deductMoney(200);
		player.addMoney(200);

	}

}
