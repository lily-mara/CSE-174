// TicTacToeGame
// Nate Mara
// 2013-11-21
// a simple TicTacToe game that
// repeats

import java.util.Scanner;

public class TicTacToeGame {
	public static void main(String[] args) {
		// infinate loop will keep repeating games until user
		// sends interrupt
		while (true) {
			TicTacToe board = new TicTacToe();
			System.out.println("New Game!");
			System.out.println(board.toString());
			gameLoop(board);
			checkWinner(board);
		}
	}

	// prompts the users for a space to which to move until the 
	// user provides a valid position
	public static void gameLoop(TicTacToe board) {
		while (board.getStatus() == TicTacToe.IN_PROGRESS) {
			promptProcess('X', board);
			if (board.getStatus() == TicTacToe.IN_PROGRESS)
				promptProcess('O', board);
		}
	}

	// prompts the user for a position and returns an int array
	// of length 2 containing row and col
	public static int[] promptPlayer(char player) {
		Scanner in = new Scanner(System.in);

		System.out.print("Please enter coordinates separated by a space for player " + player + ": ");
		int row = in.nextInt();
		int col = in.nextInt();

		int[] pos = {col, row};

		return pos;
	}

	// returns true if the move passed as argument is valid,
	// false otherwise.
	public static boolean checkMove(int[] pos, TicTacToe board) {
		int row = pos[0];
		int col = pos[1];

		return (row<3 && col<3) && (board.isEmpty(row, col));
	}

	// makes the move given as an argument and shows the board 
	// after move is made
	public static void makeMove(int [] pos, TicTacToe board,
		char inPlayer) {

		int row = pos[0];
		int col = pos[1];
		int outPlayer;

		if (inPlayer == 'X')
			outPlayer = Cell.X;
		else
			outPlayer = Cell.O;
			
		board.makeMove(outPlayer, row, col);
	}

	// takes a char representing player as an arg, prompts user
	// for move until they give legal move, then makes move
	public static void promptProcess(char player,
		       	TicTacToe board) {

			int[] move = promptPlayer(player);
			while (!checkMove(move, board)) {
				System.out.println("Sorry, you have entered an illegal space."); 
				move = promptPlayer(player);
			}
			makeMove(move, board, player);
			System.out.println(board.toString());
	}

	// prints the winner of the game, or if it is tie game
	public static void checkWinner(TicTacToe board) {
		if (board.getStatus() == TicTacToe.X_WINS)
			System.out.println("X has won the game!");
		else if (board.getStatus() == TicTacToe.O_WINS)
			System.out.println("O has won the game!");
		else
			System.out.println("Nobody has won this game, it is a tie!");

	}
}
