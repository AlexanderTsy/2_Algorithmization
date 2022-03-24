package by.jonline.algorithmization02.multidimensional_array;

import java.util.Arrays;
import java.util.Objects;

/**
 * 2 Algorithmization Массивы массивов. Задание 13<br/>
 * Отсортировать столбцы матрицы по возрастанию и убыванию значений элементов.
 * 
 * @author tsyhanok.aa
 *
 */
public class Task13 {

	private static final int ASC = 1;
	private static final int DESC = -1;

	/**
	 * Method sorts matrix columns in specified direction
	 * 
	 * @param matrix
	 * @param direction ASC or DESC
	 */
	public static void sortMatrixColumns(int[][] matrix, int direction) {
		int[] column;

		// check null and empty array
		if (Objects.isNull(matrix) || matrix.length == 0) {
			System.err.println("Error. Call to sortMatrixRows. Null or empty array");
			return;
		}
		// check if array is a matrix
		for (int i = 1; i < matrix.length; i++) {
			if (Objects.isNull(matrix[i]) || matrix[i].length != matrix[0].length) {
				System.err.println("Error. Not a matrix. Null row or rows are not of the same length");
				return;
			}
		}

		column = new int[matrix.length];
		// loop through columns
		for (int col = 0; col < matrix[0].length; col++) {

			// copy values of current matrix column to column variable
			for (int row = 0; row < matrix.length; row++) {
				column[row] = matrix[row][col];
			}
			sortArray(column, direction);
			// copy sorted values to matrix
			for (int row = 0; row < matrix.length; row++) {
				matrix[row][col] = column[row];
			}
		}
	}

	/**
	 * Method sorts array in specified direction
	 * 
	 * @param array
	 * @param direction
	 */
	private static void sortArray(int[] array, int direction) {
		// using bubbleSort for learning purposes
		boolean sorted = false;
		int temp;
		while (!sorted) {
			sorted = true;
			for (int i = 0; i < array.length - 1; i++) {
				if (Integer.compare(array[i], array[i + 1]) == direction) {
					temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
					sorted = false;
				}
			}
		}
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
		// Test array
		int[][] arr1 = { 
				{ 1, 6, 2, 4, -5 }, 
				{ 90, 2, 1, 5, 8 }, 
				{ 1, 432, 12, 5, 0 }, 
				{ 5, 2, 1, 0, 0 },
				{ 6, 1, 12, 5566, 0 } };

		int[][] arr2 = null;

		int[][] arr3 = { { 0, 1 }, null };

		sortMatrixColumns(arr1, ASC);
		System.out.println("Test 1. Matrix rows sorted ascending");
		printMatrix(arr1);

		sortMatrixColumns(arr1, DESC);
		System.out.println("Test 1. Matrix rows sorted descending");
		printMatrix(arr1);

		System.out.println("Test 2. Array is null");
		sortMatrixColumns(arr2, DESC);

		System.out.println("Test 3. Array row is null");
		sortMatrixColumns(arr3, DESC);
	}

}
