package com.practice.test.entities;

public class Hotel implements Cell {

	Player owner;
	private HotelType hotelType;
	private int value;
	private int rent;

	public Hotel() {
		hotelType = HotelType.Silver;
		value = 200;
		rent = 50;
	}

	public void setOwner(Player player) {
		owner = player;
	}

	public boolean hasOwner() {
		return owner != null ? true : false;
	}

	@Override
	public void performCellAction(Bank bank, Player player) {
		if (this.hasOwner()) {
			if (player == owner) {
				upgradeHotelType(bank);
			} else {
				payRent(bank, player);
			}
		} else {
			if (player.hasRequiredMoney(value)) {
				owner = player;
				player.deductMoney(value);
				bank.addMoney(value);
				player.increaseAssetValueBy(value);
				setRent();
			}

		}
	}

	private void payRent(Bank bank, Player player) {
		player.deductMoney(rent);
		// bank.addMoney(rent);
		owner.addMoney(rent);
	}

	private void upgradeHotelType(Bank bank) {
		int moneyRequiredForUpgrade = getRequiredMoneyForUpgrade();

		if (owner.hasRequiredMoney(moneyRequiredForUpgrade)) {
			owner.deductMoney(moneyRequiredForUpgrade);
			bank.addMoney(moneyRequiredForUpgrade);
			owner.increaseAssetValueBy(moneyRequiredForUpgrade);
			if (hotelType == HotelType.Silver) {
				hotelType = HotelType.Gold;
			} else if (hotelType == HotelType.Gold) {
				hotelType = HotelType.Platinum;
			}
			setRent();
		}

	}

	private int getRequiredMoneyForUpgrade() {
		if (HotelType.Silver == hotelType) {
			return 100;
		} else if (HotelType.Gold == hotelType) {
			return 200;
		} else {
			return 0;
		}
	}

	private void setRent() {

		if (HotelType.Silver == hotelType) {
			rent = 50;
		} else if (HotelType.Gold == hotelType) {
			rent = 150;
		} else {
			rent = 300;
		}

	}
}
