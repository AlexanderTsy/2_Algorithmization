package by.jonline.algorithmization02.multidimensional_array;

import java.util.Arrays;
import java.util.Objects;

/**
 * 2 Algorithmization Массивы массивов. Задание 8<br/>
 * В числовой матрице поменять местами два любых столбца, т.е. все элементы
 * одного столбца поставить на соответствующие им позиции другого, а элеменнты
 * второго переместить в первый. Номера столбцов вводит пользователь с
 * клавиатуры.
 * 
 * @author tsyhanok.aa
 *
 */
public class Task8 {

	/**
	 * Method swaps i and j columns
	 * 
	 * @param i      number of column
	 * @param j      number of column
	 * @param matrix
	 */
	public static void changeColumns(int i, int j, int[][] matrix) {
		int iValue; // for storing swapping values

		if (i < 0 || j < 0) {
			System.err.println("Negative index");
			return;
		}

		// check null or empty array
		// OR is lazy so it will work
		if (Objects.isNull(matrix) || matrix.length == 0) {
			System.err.println("Null or empty array");
			return;
		}

		if (!isMatrix(matrix)) {
			System.err.println("Not a matrix. Rows are not of the same length");
			return;
		}

		if (i > matrix[0].length || j > matrix[0].length) {
			System.err.println("Index out of bounds.");
			return;
		}

		for (int row = 0; row < matrix.length; row++) {
			iValue = matrix[row][i];
			matrix[row][i] = matrix[row][j];
			matrix[row][j] = iValue;
		}
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
		
		//Test array 1. Matrix
		int[][] arr1= {
				{1,0,2,0},
				{1,0,2,0},	
				{1,0,2,0}
		};
		//Test array 2. Not a matrix
				int[][] arr2= {
						{1,0,2},
						{1,0,2,0},	
						{1,0,2,0}
				};
		
		System.out.println("Test 1. Expected column 2s, column 0s, column 1s, column 0s");
		changeColumns(0, 2, arr1);
		printMatrix(arr1);
		
		System.out.println("Test 2. Expected Not a matrix error");
		changeColumns(0, 2, arr2);
		
		System.out.println("Test 3. Expected Index out of bounds error");
		changeColumns(0, 5, arr1);
		
		System.out.println("Test 4. Expected Negative index error");
		changeColumns(0, -5, arr1);
		
		arr2 = null;
		System.out.println("Test 5. Expected Null or empty array error");
		changeColumns(0, 2, arr2);
	}

}
