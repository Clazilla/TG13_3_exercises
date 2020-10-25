package sudoku;

import java.util.Scanner;

public class SudokuSolver {

	static int sudoku[][] = { { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 } };

	public static void main(String[] args) {
		
		Scanner sc = new Scanner("");

		// gridOutput();

		for (int i = 0; i < sudoku.length; i++) {
			for (int j = 0; j < sudoku.length; j++) {
				if (sudoku[i][j] == 0) {
					for (int k = 1; k <= 9; k++) {
						boolean isValid = checkTheNumber(k, j);
						if (isValid == true) {
							sudoku[i][j] = k;
							System.out.print(k);
						}
					}
				}
			}
		}

		gridOutput();

	}

	private static boolean checkTheNumber(int number, int column) {
		for (int i = 0; i < 9; i++) {
			// check if the number is already in the column or row
			if (sudoku[column][i] == number || sudoku[i][column] == number) {
				return false;
			}
		}
		return true;
	}

	private static void gridOutput() {
		// Sudokugrid output
		for (int i = 0; i < 9; i++) {
			if (i % 3 == 0) {
				System.out.print("-------------------------------" + "\n");
			}
			for (int j = 0; j < 9; j++) {
				if (j % 3 == 0) {
					System.out.print("|");
				}
				System.out.print("\s" + sudoku[i][j] + "\s");
				if (j == 8) {
					System.out.print("|" + "\n");
				}
			}
		}
		System.out.println("-------------------------------");

		// --------------------------------------------------------------
	}

}
