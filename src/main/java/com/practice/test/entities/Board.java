package com.practice.test.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {

	List<Cell> cells;
	List<Player> players;
	Map<Player, Integer> playerPositionOnBoard;

	public Board(String cellString, Player player1, Player player2) {
		setUpCells(cellString);
		players = new ArrayList<>();
		playerPositionOnBoard = new HashMap<>();
		players.add(player1);
		playerPositionOnBoard.put(player1, 0);

		players.add(player2);
		playerPositionOnBoard.put(player2, 0);

	}

	public void addPlayer(Player player) {

		players.add(player);
		playerPositionOnBoard.put(player, 0);
	}

	private void setUpCells(String cellString) {
		cells = new ArrayList<>();
		cells.add(new EmptyCell());
		String cellArgs[] = cellString.split(",");
		for (int i = 0; i < cellArgs.length; i++) {
			switch (CellType.valueOf(cellArgs[i])) {
			case J:
				cells.add(new Jail());
				break;
			case L:
				cells.add(new Lottery());
				break;
			case H:
				cells.add(new Hotel());
				break;
			case E:
				cells.add(new EmptyCell());

			}
		}
	}

	public void play(String diceRolls) {
		Bank bank = Bank.getInstance();

		String diceArgs[] = diceRolls.split(",");

		int turns = diceArgs.length / players.size();
		int moveNumber = 0;
		for (int i = 0; i < turns; i++) {
			for (Player p : players) {
				int diceValue = Integer.parseInt(diceArgs[moveNumber]);
				moveNumber++;

				int playerPosition = playerPositionOnBoard.get(p);
				playerPosition = calcCellPosition(playerPosition, diceValue);

				playerPositionOnBoard.put(p, playerPosition);

				Cell currentCell = cells.get(playerPosition);

				currentCell.performCellAction(bank, p);

			}
		}
		for (Player p : players) {
			System.out.println(p);
		}
		System.out.println("Balance at Bank: " + bank.getBalance());
		System.out.println();
	}

	private int calcCellPosition(int currentCell, int diceValue) {
		int numberOfCells = cells.size() - 1;
		int newPosition = currentCell + diceValue;

		if (newPosition > numberOfCells) {
			newPosition -= numberOfCells;

		}
		return newPosition;
	}
}
