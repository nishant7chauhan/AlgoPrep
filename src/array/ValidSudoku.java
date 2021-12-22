package array;

import java.util.HashSet;
import java.util.Set;

/**
 * Write code for Sudoku Validator in most optimal time and space complexity 
 * @author nishantchauhan
 * exponential or constant if 9X9
 */



public class ValidSudoku {

	public static boolean isValidSudoku(char[][] board) {

		Set seen = new HashSet();

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				char number = board[i][j];
				if (number != '.') {

					if (!seen.add(number + " in row " + i) || !seen.add(number + " in col " + j)
							|| !seen.add(number + " in box " + i / 3 + "-" + j / 3)) {
						return false;
					}
				}
			}
		}

		return true;

	}

	public static void main(String[] args) {
		char board[][] = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

		System.out.print(isValidSudoku(board) ? "YES\n" : "NO\n");
	}
}
