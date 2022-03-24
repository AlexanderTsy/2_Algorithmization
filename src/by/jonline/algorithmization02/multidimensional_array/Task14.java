package by.jonline.algorithmization02.multidimensional_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * 2 Algorithmization Массивы массивов. Задание 14<br/>
 * Сформировать случайную матрицу m x n, состоящую из нулей и единиц, причем в
 * каждом столбце число единиц равно номеру столбца.
 * 
 * @author tsyhanok.aa
 *
 */
public class Task14 {

	/**
	 * Generates randomly valued matrix m x n consisting of 0 and 1, each column
	 * holding number of 1s being equal to 1-based column index.
	 * 
	 * @param m number of rows
	 * @param n number of columns
	 * @return generated matrix
	 */
	public static int[][] generateMatrix(int m, int n) {
		int[][] matrix;
		// numbers of rows to choose from when randomly setting value to 1
		ArrayList<Integer> rowNumbers;
		int randomNum;

		if (m <= 0 || n <= 0) {
			System.err.println("Negative matrix dimensions. Returning null");
			return null;
		}
		
		if (m < n) {
			System.err.println("Number of rows is less than number of columns. Can not generate matrix.");
			return null;
		}

		matrix = new int[m][n];
		for (int col = 0; col < matrix[0].length; col++) {
			rowNumbers = new ArrayList<Integer>();
			for (int i = 0; i < matrix.length; i++) {
				rowNumbers.add(i);
			}
			// fill column with 1, quantity of 1s equals to an index of the column
			// 1-based column index for matrix
			for (int i = 0; i < col+1; i++) {
				// randomNum specifies which of the rest row numbers will be taken to fill array
				// element with 1
				randomNum = (int) Math.round(Math.random() * (rowNumbers.size()-1));
				matrix[rowNumbers.get(randomNum)][col] = 1;
				rowNumbers.remove(randomNum);
			}
		}
		return matrix;
	}

	/**
	 * Convenience method to print matrix to console
	 * 
	 * @param matrix
	 */
	private static void printMatrix(int[][] matrix) {

		if (Objects.isNull(matrix)) {
			System.err.println("Array is null. Nothing to output");
			return;
		}

		if (matrix.length == 0) {
			System.err.println("Empty array. Nothing to output");
			return;
		}
		for (int i = 0; i < matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
	}

	public static void main(String[] args) {
		int[][] m;
		
		// Test 1. m < n
		System.out.println("Test 1. m < n");
		m = generateMatrix(10, 20);
		printMatrix(m);
		
		// Test 2.
		System.out.println("Test 2. Normal operation");
		m = generateMatrix(10, 10);
		printMatrix(m);
	}

}
