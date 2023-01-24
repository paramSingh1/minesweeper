package minesweeper;

import java.util.Arrays;
import java.util.Random;

public class Main {
	static boolean activeGame = false;

	public static void main(String[] args) {
		GameState.welcome(activeGame);
		Grid.board();
		GameState.playGame();
		
		
	}


}
