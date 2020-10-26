package sudoku;

public class SudokuSolver {

	static int sudoku[][] = { { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 } };

	public static void main(String[] args) {
		solve();

		gridOutput();
	}

	private static boolean solve() {
		for (int i = 0; i < sudoku.length; i++) {
			for (int j = 0; j < sudoku.length; j++) {
				if (sudoku[i][j] == 0) {
					for (int k = 1; k <= 9; k++) {
						boolean isValid = checkTheNumber(k, i, j);
						if (isValid == true) {
							sudoku[i][j] = k;
							if (solve() == true) {
								return true;
							}
							sudoku[i][j] = 0;
						}
					}
					return false;
				}
			}
		}
		return true;
	}

	private static boolean checkTheNumber(int number, int row, int column) {
		for (int i = 0; i < 9; i++) {
			// check if the number is already in the column or row
			if (sudoku[row][i] == number || sudoku[i][column] == number) {
				return false;
			}
		}
		// check if the number is already in the small 3x3 area
		column -= column % 3;
		row -= row % 3;

		for (int k = row; k < row + 3; k++) {
			for (int l = column; l < column + 3; l++) {
				if (sudoku[k][l] == number) {
					return false;
				}
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
				System.out.print(" " + sudoku[i][j] + " ");
				if (j == 8) {
					System.out.print("|" + "\n");
				}
			}
		}
		System.out.println("-------------------------------");

		// --------------------------------------------------------------
	}

}
