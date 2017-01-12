
import java.util.Random;
import java.util.Scanner;

public class Sudoku {

	static Random generator = new Random();
	final static int WIDTH = 9;
	final static int HEIGHT = 9;
	static char sudokuBoard[][] = new char[WIDTH][HEIGHT];
	static char numbers[] = "123456789".toCharArray();

	public static void main(String[] args) {

		prepareSudokuBoard();
		showMenu();
		switch (choseLevel()) {
		case 1:
			generateSudokuBoard(50);
			showBoard();
			break;
		case 2:
			generateSudokuBoard(40);
			showBoard();
			break;
		case 3:
			generateSudokuBoard(30);
			showBoard();
			break;
		case 4:
			generateSudokuBoard(25);
			showBoard();
			break;
		default:
			System.out.println("Program zostal zakonczony");
			break;
		}

	}

	public static void prepareSudokuBoard() {
		for (int i = 0; i < WIDTH; i++) {
			for (int j = 0; j < HEIGHT; j++) {
				sudokuBoard[i][j] = '#';
			}
		}

	}

	public static void showBoard() {
		for (int i = 0; i < WIDTH; i++) {
			for (int j = 0; j < HEIGHT; j++) {
				System.out.print(sudokuBoard[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void showMenu() {
		System.out.println("Dostepne poziomy rozgrywki: ");
		System.out.println("1.Latwy");
		System.out.println("2.Trudny");
		System.out.println("3.Sredni");
		System.out.println("4.Hard");
		System.out.println("5.Zakoncz program");
		System.out.println();

	}

	public static int choseLevel() {
		System.out.println("Wybierz poziom rozgrywki: ");
		Scanner scanner = new Scanner(System.in);
		return scanner.nextInt();
	}

	public static void generateSudokuBoard(int numberOfDraws) {
		Random generator = new Random();
		int x;
		int y;
		char number;

		while (numberOfDraws != 0) {

			x = generator.nextInt(WIDTH);
			y = generator.nextInt(HEIGHT);

			if (sudokuBoard[x][y] == '#') {

				do {
					number = numbers[generator.nextInt(9)];
				} while (!isCompatibileWithSudokuRules(x, y, number));
				sudokuBoard[x][y] = number;
				numberOfDraws--;
			}

		}

	}

	public static boolean isCompatibileWithSudokuRules(int rowNumber, int columnNumber, char number) {
		if (checkRow(rowNumber, number) || checkColumn(columnNumber, number)
				|| checkSquare(rowNumber, columnNumber, number)) {
			return false;
		}
		return true;
	}

	public static boolean checkRow(int rowNumber, char number) {
		for (int i = 0; i < WIDTH; i++) {
			if (sudokuBoard[rowNumber][i] == number) {
				return true;
			}
		}
		return false;
	}

	public static boolean checkColumn(int columnNumber, char number) {
		for (int i = 0; i < HEIGHT; i++) {
			if (sudokuBoard[i][columnNumber] == number) {
				return true;
			}
		}
		return false;
	}

	public static boolean checkSquare(int rowNumber, int columnNumber, char number) {
		int vsquare = rowNumber / 3;
		int hsquare = columnNumber / 3;

		for (int i = vsquare * 3; i < (vsquare * 3 + 3); i++) {
			for (int j = hsquare * 3; j < (hsquare * 3 + 3); j++) {
				if (!(i == rowNumber && j == columnNumber)) {
					if (number == sudokuBoard[i][j]) {
						return true;
					}
				}
			}
		}
		return false;
	}

}
