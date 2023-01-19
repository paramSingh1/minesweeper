package minesweeper;

import java.util.Scanner;

public class GameState {
	static boolean activeGameState = false;
	static Scanner s = new Scanner(System.in);
	static Scanner x = new Scanner(System.in);
	static Scanner y = new Scanner(System.in);
	public int surroundingMines = 0;

	public static Boolean welcome(boolean activeGame) {
		while (!activeGameState) {
			System.out.println("==========================");
			System.out.println(" Welcome to Mine Sweeper! ");
			System.out.println("==========================\n");
			System.out.println("Press Y to start a new game");
			System.out.println("Press N to Exit");
			String selection = s.next();

			if (selection.equalsIgnoreCase("y")) {
				Grid.board();
				activeGameState = true;
				playGame();
				activeGame = true;

			} else if(selection.equalsIgnoreCase("n")) {
				activeGameState = false;
				System.out.println("Good bye");
				System.exit(0);	
			}
				else {
				System.out.println("Press Y to start a new game");
				selection = s.next();

			}
		}
		return false;
	}

	public static void playGame() {
		if (!activeGameState) {
			return;
		} else {
			while (activeGameState) {
				makeSelection();
				if (!activeGameState) {
					System.out.println("Game over!");
					return;
				}
				Grid.printBoard();
			}
		}
	}

	public static boolean makeSelection() {

		if (activeGameState == false) {
			System.out.println("Game over!");
			activeGameState = false;
		}
		System.out.println("\n Enter the x coordinate");
		int first = x.nextInt() - 1;
		System.out.println("Enter the y coordinate");
		int second = y.nextInt() - 1;

		if (Grid.revealedGrid[first][second] == true) {
			System.out.printf("The coordinate [%s][%s] has already been revealed! \n", first + 1, second + 1);
		} else if (Grid.grid[first][second] == -1) {
			Grid.revealedGrid[first][second] = true;
			System.out.println("BOOM !");
			System.out.println("You hit a bomb!");
			activeGameState = false;
		} else if (Grid.grid[first][second] == 0) {
			checkForMines(first, second);

			Grid.revealedGrid[first][second] = true;
			activeGameState = true;

		}
		return activeGameState;
	}

	public static void checkForMines(int i, int j) {
		for (int x = 0; x < Grid.grid[i].length - 1; x++) {
			int surroundingMines = 0;

//	    	System.out.println(surroundingMines);
//	    	//check right
//	    	if(Grid.grid[i][x+1]==-1) {
//		    	Grid.grid[i][x]= ++surroundingMines;
//	    		}
//	    	//check bottom
//	    	if(i!=10 && Grid.grid[Math.min(9, i+1)][x]==-1) {
//	    		Grid.grid[i][x]= ++surroundingMines;
//	    		}
//	    	//check left
//	    	if(j != 0 && Grid.grid[i][Math.max(0, x-1)]==-1) {
//	    		Grid.grid[i][x] = ++surroundingMines;
//	    		
//	    		}
//	    	//check above
//	    	if(i != 0 && Grid.grid[Math.max(0, x-1)][x]==-1) {
//	    		Grid.grid[i][x] = ++surroundingMines;
//	    		
//	    		}
//	    	System.out.println(surroundingMines);
			// check right
			if (j < Grid.grid[i].length - 1 && Grid.grid[i][j + 1] == -1) {
				surroundingMines++;
			}
			// Check bottom
			if (i < Grid.grid.length - 1 && Grid.grid[i + 1][j] == -1) {
				surroundingMines++;
			}
			// check left
			if (j > 0 && Grid.grid[i][j - 1] == -1) {
				surroundingMines++;
			}
			// check above
			if (i > 0 && Grid.grid[i - 1][j] == -1) {
				surroundingMines++;
			}
//	     check bottom-right diagonal
			//need to validate for bounds error using the length for corners
			if (i < Grid.grid.length - 1 && j < Grid.grid[i].length - 1 && Grid.grid[i + 1][j + 1] == -1) {
				surroundingMines++;
			}
			// check top-right diagonal
			if (i > 0 && j < Grid.grid[i].length - 1 && Grid.grid[i - 1][j + 1] == -1) {
				surroundingMines++;
			}
			// Check top-left diagonal
			if (i > 0 && j > 0 && Grid.grid[i - 1][j - 1] == -1) {
				surroundingMines++;
			}
			// check bottom-left diagonal
			if (i < Grid.grid.length - 1 && j > 0 && Grid.grid[i + 1][j - 1] == -1) {
				surroundingMines++;
			}
			Grid.grid[i][j] = surroundingMines;

		}
	}
}
