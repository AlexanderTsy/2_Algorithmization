package by.jonline.algorithmization02.multidimensional_array;

import java.util.Arrays;
import java.util.Objects;

/**
 * 2 Algorithmization Массивы массивов. Задание 9<br/>
 * Задана матрица неотрицательных чисел. Посчитать сумму элементов в каждом
 * столбце. Определить, какой столбец содержит максимальную сумму.
 * 
 * @author tsyhanok.aa
 *
 */
public class Task9 {

	public static long[] sumByColumn(int[][] matrix) {
		long[] result;

		// check null or empty array
		if (Objects.isNull(matrix) || matrix.length == 0) {
			System.err.println("Null or empty array");
			return null;
		}

		// check if it is a matrix
		if (!isMatrix(matrix)) {
			System.err.println("Not a matrix. Rows are not of the same length");
			return null;
		}

		result = new long[matrix[0].length];
		for (int i = 0; i < result.length; i++) {
			result[i] = 0;
		}

		//
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[0].length; col++) {
				if (matrix[row][col] < 0) {
					System.err.println("Negative array elements. Returning null");
					return null;
				}
				result[col] += matrix[row][col];
			}
		}

		return result;
	}

	/**
	 * Method finds index of column with maximal sum
	 * 
	 * @param array result of sumByColumn
	 * @return 0-based index of column with maximal sum
	 */
	public static int indexOfMaxSum(long[] array) {
		long maxVal = 0;
		int index = 0;

		// check null or empty array
		if (Objects.isNull(array) || array.length == 0) {
			System.err.println("Null or empty array. Check sumByColumn has been calculated.");
			return -1;
		}

		for (int i = 0; i < array.length; i++) {
			if (array[i] > maxVal) {
				maxVal = array[i];
				index = i;
			}
		}

		return index;
	}

	/**
	 * Method checks if array is matrix
	 * 
	 * @param array
	 * @return true if all rows are of the same size
	 */
	private static boolean isMatrix(int[][] array) {
		int rowLength;
		// check all the rows are of the same length
		rowLength = array[0].length;
		for (int i = 1; i < array.length; i++) {
			if (array[i].length != rowLength) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		long[] sumArr;
		
		// Test array 1. Matrix
		int[][] arr1 = { 	{ 1, 6, 100, 0 },
							{ 2, 0, 2, 50 },
							{ 3, 10, 2, 0 } };
		// Test array 2. null
		int[][] arr2 = null;
		
		sumArr = sumByColumn(arr1);
		System.out.println("Test 1. Sum array:"+Arrays.toString(sumArr)+" index at max="+indexOfMaxSum(sumArr)+" 0-based index");
		System.out.println("Test 2. Array is null");
		sumArr = sumByColumn(arr2);
	}

}
