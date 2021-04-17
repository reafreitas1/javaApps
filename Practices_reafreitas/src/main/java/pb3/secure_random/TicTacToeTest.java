package pb3.secure_random;

import java.security.SecureRandom;
import java.util.Scanner;

public class TicTacToeTest {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Welcome to TicTacToe!");
		System.out.print("How many players: (1 or 2): ");

		Game game = new Game(scanner.nextInt());
		game.start();
	}
}

class Game {

	private Scanner scanner = new Scanner(System.in);
	private int numberPlayers;
	private TicTacToe game;

	public Game(int numberPlayers) {
		this.numberPlayers = numberPlayers;

	}

	public void start() {
		createEnvironment(numberPlayers);
		game.play();
	}

	private void createEnvironment(int quantity) {
		Player player1;
		Player player2;
		if (numberPlayers == 1) {
			player1 = new Player(askName("Player"), Shape.X);
			player2 = new Computer("Computer", Shape.O);
		} else {
			player1 = new Player(askName("Player 1"), Shape.X);
			player2 = new Player(askName("Player 2"), Shape.O);
		}
		game = new TicTacToe(player1, player2);
	}

	private String askName(String player) {
		System.out.printf("%s, please enter your name: ", player);
		return scanner.nextLine();
	}
}

class TicTacToe {

	private Player player1;
	private Player player2;

	private String[][] board;
	private Player activePlayer;

	public TicTacToe(Player player1, Player player2) {
		board = new String[3][3];
		this.player1 = player1;
		this.player2 = player2;
		resetBoard();
	}

	public void play() {
		Scanner scanner = new Scanner(System.in);

		boolean finished = false;

		do {
			changePlayer();
			if (activePlayer.getName().equals("Computer")) {
				int square = ((Computer) activePlayer).getSquare(board);
				placeMark(square);
			} else {
				int square;
				boolean repeat;
				do {
					repeat = false;
					System.out.printf("%s choose a square number (0 for help): ", activePlayer.getName());
					square = scanner.nextInt();

					if (square == 0) {
						printBoard(true);
						repeat = true;
					}

					if (!placeMark(square))
						repeat = true;

				} while (repeat);
			}

			printBoard(false);

			if (checkWin()) {
				System.out.printf("%s has won the game.", activePlayer.getName());
				finished = true;
			}

			if (isBoardFull()) {
				System.out.println("No one has won the game");
				finished = true;
			}

		} while (!finished);
		scanner.close();
	}

	public void resetBoard() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = " ";
			}
		}
	}

	private void changePlayer() {
		if (activePlayer == null) {
			SecureRandom random = new SecureRandom();
			int number = random.nextInt(2) + 1;
			if (number == 1)
				activePlayer = player1;
			else
				activePlayer = player2;
		} else {
			if (activePlayer == player1)
				activePlayer = player2;
			else
				activePlayer = player1;
		}
	}

	private boolean placeMark(int square) {
		switch (square) {
		case 1:
			return checkMark(0, 0);
		case 2:
			return checkMark(0, 1);
		case 3:
			return checkMark(0, 2);
		case 4:
			return checkMark(1, 0);
		case 5:
			return checkMark(1, 1);
		case 6:
			return checkMark(1, 2);
		case 7:
			return checkMark(2, 0);
		case 8:
			return checkMark(2, 1);
		case 9:
			return checkMark(2, 2);
		default:
			return false;
		}
	}

	private boolean checkMark(int row, int col) {
		if (board[row][col].equals(" ")) {
			board[row][col] = activePlayer.getShape();
			return true;
		}
		return false;
	}

	private boolean checkWin() {
		if (checkRowsForWin() || checkColumnsForWin() || checkDiagonalsForWin())
			return true;
		return false;
	}

	private boolean checkValues(String s1, String s2, String s3) {
		if (s1.equals(" ") || s2.equals(" ") || s3.equals(" "))
			return false;
		return (s1.equals(s2)) && (s2.equals(s3) && s1.equals(s3));
	}

	private boolean checkRowsForWin() {
		for (int i = 0; i < 3; i++) {
			if (checkValues(board[i][0], board[i][1], board[i][2])) {
				return true;
			}
		}
		return false;
	}

	// Loop through columns and see if any are winners.
	private boolean checkColumnsForWin() {
		for (int i = 0; i < 3; i++) {
			if (checkValues(board[0][i], board[1][i], board[2][i])) {
				return true;
			}
		}
		return false;
	}

	// Check the two diagonals to see if either is a win. Return true if either
	// wins.
	private boolean checkDiagonalsForWin() {
		return ((checkValues(board[0][0], board[1][1], board[2][2]) == true)
				|| (checkValues(board[0][2], board[1][1], board[2][0]) == true));
	}

	public boolean isBoardFull() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j].equals(" ")) {
					return false;
				}
			}
		}
		return true;
	}

	public void printBoard(boolean help) {
		System.out.println();
		int count = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (j == board[i].length - 1) {
					System.out.printf(" %s %n", help ? ++count : board[i][j] == null ? " " : board[i][j]);
				} else {
					System.out.printf(" %s |", help ? ++count : board[i][j] == null ? " " : board[i][j]);
				}
			}
			if (i == board.length - 1) {
				System.out.println();
			} else {
				System.out.println("____________");
			}
		}
	}
}

class Computer extends Player {

	private String[][] board;
	private boolean firstPlay;

	public Computer(String name, Shape shape) {
		super(name, shape);
		firstPlay = true;
	}

	public int getSquare(String[][] board) {
		this.board = board;
		return studyBoard();
	}

	private int studyBoard() {

		// FirstMove - Comp is first play random empty square, else center
		if (firstPlay) {
			return playFirstMove();
		}

		// Try win
		int row = finishRow(false);
		if (row != -1) {
			System.out.println("Possible row " + row);
			return row;
		} else {
			System.out.println("No possible row");
		}

		int col = finishColumn(false);
		if (col != -1) {
			System.out.println("Possible column " + col);
			return col;
		} else {
			System.out.println("No possible column");
		}

		int dia = finishDiagonal(false);
		if (dia != -1) {
			System.out.println("Possible diagonal " + dia);
			return dia;
		} else {
			System.out.println("No possible diagonal");
		}

		System.out.println("No possible win, trying to block");

		// Try block
		row = finishRow(true);
		if (row != -1) {
			System.out.println("block in row " + row);
			return row;
		} else {
			System.out.println("No block in row");
		}

		col = finishColumn(true);
		if (col != -1) {
			System.out.println("block in column " + col);
			return col;
		} else {
			System.out.println("No block in column");
		}

		// Play middle
		if (board[1][1] == " ")
			return 5;

		// Play Opposite Corner

		// Play Empty corner
		int emptyCorner = playEmptyCorner();
		if (emptyCorner != -1)
			return emptyCorner;

		// Play side

		System.out.println("Confused");

		Scanner scanner = new Scanner(System.in);
		System.out.println("No possible moves, please help: ");
		return scanner.nextInt();
	}

	private int playFirstMove() {
		firstPlay = false;
		if (isBoardEmpty()) {
			return playEmptyCorner();
		} else {
			return 5;
		}
	}

	private int playEmptyCorner() {
		SecureRandom random = new SecureRandom();
		int number = random.nextInt(4) + 1;
		switch (number) {
		case 1:
			if (board[0][0].equals(" "))
				return 1;
		case 2:
			if (board[0][2].equals(" "))
				return 3;
		case 3:
			if (board[2][0].equals(" "))
				return 7;
		case 4:
			if (board[2][2].equals(" "))
				return 9;
		default:
			return -1;
		}
	}

	private int finishRow(boolean block) {
		String shape = "";
		if (block) {
			if (getShape().equals(Shape.O.name()))
				shape = Shape.X.name();
			else {
				shape = Shape.O.name();
			}
		} else {
			shape = getShape();
		}

		for (int i = 0; i < 3; i++) {
			String str = "";
			str = str + board[i][0];
			str = str + board[i][1];
			str = str + board[i][2];

			int value = 0;
			if (i == 1)
				value = 3;
			if (value == 2)
				value = 6;
//			System.out.println(str + shape);
			if (str.equals(" " + shape + shape)) {
				System.out.println("1:" + (1 + value));
				return block ? (1 + value) : 1 + value;
			}

			if (str.equals(shape + " " + shape)) {
				System.out.println("2:" + (2 + value));
				return block ? (2 + value) : 2 + value;
			}
				
			if (str.equals(shape + shape + " ")) {
				System.out.println("3:" + (3 + value));
				return block ? (3 + value) : 3 + value;
			}
				
		}
		return -1;
	}

	private int finishColumn(boolean block) {
		String shape = "";
		if (block) {
			if (getShape().equals(Shape.O.name()))
				shape = Shape.X.name();
			else {
				shape = Shape.O.name();
			}
		} else {
			shape = getShape();
		}

		for (int i = 0; i < 3; i++) {
			String str = "";
			str = str + board[0][i];
			str = str + board[1][i];
			str = str + board[2][i];

			int value = 0;
			if (i == 1)
				value = 3;
			if (value == 2)
				value = 6;
			
			System.out.println(str + shape);
			if (str.equals(" " + shape + shape)) {
				System.out.println("1:" + (1 + value));
				return block ? (1 + i) : (1 + value);
			}
				
			if (str.equals(shape + " " + shape)) {
				System.out.println("2:" + (2 + value));
				return block ? (4 + i) : 2 + value;
			}
				
			if (str.equals(shape + shape + " ")) {
				System.out.println("3:" + (3 + value));
				return block ? (7 + i) : (3 + value);
			}
		}
		return -1;
	}

	private int finishDiagonal(boolean block) {
		String shape = "";
		if (block) {
			if (getShape().equals(Shape.O.name()))
				shape = Shape.X.name();
			else {
				shape = Shape.O.name();
			}
		} else {
			shape = getShape();
		}
		String str = "";
		str = str + board[0][0];
		str = str + board[1][1];
		str = str + board[2][2];

		if (str.equals(" " + shape + shape))
			return 1;
		if (str.equals(shape + " " + shape))
			return 5;
		if (str.equals(shape + shape + " "))
			return 9;

		str = "";
		str = str + board[0][2];
		str = str + board[1][1];
		str = str + board[2][0];

		if (str.equals(" " + shape + shape))
			return 3;
		if (str.equals(shape + " " + shape))
			return 5;
		if (str.equals(shape + shape + " "))
			return 7;

		return -1;
	}

	public boolean isBoardEmpty() {
		boolean empty = true;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j].equals(" "))
					empty = true;
				else {
					empty = false;
					break;
				}
			}
			if (!empty)
				break;
		}
		System.out.println("Board is empty: " + empty);
		return empty;
	}
}

class Player {

	private String name;
	private Shape shape;

	public Player(String name, Shape shape) {
		super();
		this.name = name;
		this.shape = shape;
	}

	public String getName() {
		return name;
	}

	public String getShape() {
		return shape.name();
	}
}

enum Shape {
	X, O
}