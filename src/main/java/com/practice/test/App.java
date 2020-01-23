package com.practice.test;

import com.practice.test.entities.Board;
import com.practice.test.entities.Player;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		Player player1 = new Player();
		Player player2 = new Player();

		Board board = new Board("J,H,L,H,E,L,H,L,H,J", player1, player2);
		Player player3 = new Player();

		board.addPlayer(player3);

		//board.play("2,2,1,4,4,2,4,4,2,2,2,1,4,4,2,4,4,2,2,2,1");
		board.play("2,2,1,4,2,3,4,1,3,2,2,7,4,7,2,4,4,2,2,2,2");

	}
}
