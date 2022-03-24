package by.jonline.algorithmization02.multidimensional_array;

import java.util.Arrays;
import java.util.Objects;

/**
 * 2 Algorithmization Массивы массивов. Задание 15<br/>
 * Найдите наибольший элемент матрицы и замените все нечетные элементы на него
 * 
 * @author tsyhanok.aa
 *
 */
public class Task15 {

	/**
	 * Method finds maximal value within matrix and assigns this value to every
	 * element which is odd number
	 * 
	 * @param matrix
	 */
	public static void changeOddElementsToMax(int[][] matrix) {
		int maxValue;

		// check null and empty array
		if (Objects.isNull(matrix) || matrix.length == 0) {
			System.err.println("Error. Null or empty array");
			return;
		}
		// check if array is a matrix
		for (int i = 1; i < matrix.length; i++) {
			if (Objects.isNull(matrix[i]) || matrix[i].length != matrix[0].length) {
				System.err.println("Error. Not a matrix. Null row or rows are not of the same length");
				return;
			}
		}

		// find max value
		maxValue = matrix[0][0];
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[0].length; col++) {
				if (matrix[row][col] > maxValue) {
					maxValue = matrix[row][col];
				}
			}
		}

		// assign maxValue to odd elements
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[0].length; col++) {
				if (matrix[row][col] % 2 == 1) {
					matrix[row][col] = maxValue;
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
		// Tests
		int[][] arr1 = { 
				{ 1, 2, 0, 10, 5 }, 
				{ 1, 2, 0, 10, 5 }, 
				{ 1, 2, -10, 10, 5 }, 
				{ 1, 2, 0, -2, 5 },
				{ 1, 2, 0, 10, 5 } };

		int[][] arr2 = { 
				{ 1, 2, 0, 10, 5 }, 
				{ 1, 2, 0, 10, 5 }, 
				null, 
				{ 1, 2, 0, -2, 5 }, 
				{ 1, 2, 0, 10, 5 } };

		int[][] arr3 = { { 1, 2, 0, 10, 3 }, { 1, -100, 0, 100, 5 }, { 1, 2, 0, 10, 4 } };

		int[][] arr4 = null;

		int[][] arr5 = new int[0][0];

		System.out.println("Test 1. Square matrix");
		changeOddElementsToMax(arr1);
		printMatrix(arr1);

		System.out.println("Test 2. Not matrix.");
		changeOddElementsToMax(arr2);

		System.out.println("Test 3. Rectangular matrix.");
		changeOddElementsToMax(arr3);
		printMatrix(arr3);

		System.out.println("Test 4. Null or empty array.");
		changeOddElementsToMax(arr4);

		System.out.println("Test 5. Null or empty array.");
		changeOddElementsToMax(arr5);

	}

}
