package minesweeper;

import java.util.Random;

public class Grid {
	
	static int[][] grid = new int [10][10];
	//Boolean array values are false by default.
	static boolean[][] revealedGrid = new boolean[10][10];
	


	public static void printBoard() {
//		for(int i=0; i<rows.length;i++) {
//			System.out.printf("%s  | %d \n",Arrays.toString(rows[i]), i+1);
//		}
		for(int i =0; i<grid.length;i++) {

			for(int j = 0; j<grid[i].length;j++) {
				if(revealedGrid[i][j] && grid[i][j] != -1) {
					System.out.printf(" %s ",grid[i][j]);
					
				}else if(!revealedGrid[i][j]) {
					if(grid[i][j]== -1 ||grid[i][j]== 0 ) {
						System.out.printf("[x]",grid[i][j]);
					}else if(grid[i][j]>0) {
						System.out.printf(" %s ",grid[i][j]);
					}
					
				}
				
//				System.out.printf(" %s ",revealedGrid[i][j]);
			}
			System.out.printf("| %d \n \n",i+1);
		}
		System.out.println();
		for(int i=0; i<grid.length;i++) {
			System.out.printf(" - ");
		}
		System.out.println("");
		for(int i=0; i<grid.length;i++) {
			System.out.printf(" %d ", i+1);
		}
		
	}
	
	public static void placeMines() {
		int mines = 0;
		while(mines <10) {
			Random randomNum = new Random();
			Random randomNum2 = new Random();
			
			int randomRow = randomNum.nextInt(10);
			int randomCol = randomNum2.nextInt(10);
			//If the random co-ord already has a mine, generate new coordinates.
			if(grid[randomRow][randomCol] == -1) {
				randomRow = randomNum.nextInt(10);
				randomCol = randomNum2.nextInt(10);
				grid[randomRow][randomCol] = -1;
				}
			grid[randomRow][randomCol] = -1;
			mines++;
		}
	}
	public static void board(){
		grid = new int [10][10];
		revealedGrid = new boolean[10][10];
		placeMines();
		printBoard();
	}
	
	
}
