package by.jonline.algorithmization02.multidimensional_array;

import java.util.Arrays;
import java.util.Objects;

/**
 * 2 Algorithmization Массивы массивов. Задание 6.<br/>
 * 
 * Сформировать квадратную матрицу порядка n по заданному образцу (n - четное):
 * <table>
 * <tr><td>1<td/><td>1<td/><td>1<td/><td>...<td/><td>1<td/><td>1<td/><td>1<td/><tr/>
 * <tr><td>0<td/><td>1<td/><td>1<td/><td>...<td/><td>1<td/><td>1<td/><td>0<td/><tr/>
 * <tr><td>0<td/><td>0<td/><td>1<td/><td>...<td/><td>1<td/><td>0<td/><td>0<td/><tr/>
 * <tr><td>...<td/><td>...<td/><td>...<td/><td>...<td/><td>...<td/><td>...<td/><td>...<td/><tr/>
 * <tr><td>0<td/><td>1<td/><td>1<td/><td>...<td/><td>1<td/><td>1<td/><td>0<td/><tr/>
 * <tr><td>1<td/><td>1<td/><td>1<td/><td>...<td/><td>1<td/><td>1<td/><td>1<td/><tr/>
 * <table/>
 * 
 * @author tsyhanok.aa
 */
public class Task6 {

	/**
	 * Method creates square matrix of order n, which elements are equal to 1
	 * and elements on the left and right of diagonals are zeros.   
	 * @param n positive even number, an order of matrix to be created
	 * @return created matrix
	 */
	public static int[][] createMatrix(int n) {
		int[][] matrix;

		if (n < 2 || n % 2 != 0) {
			System.err.println("Wrong n=" + n + " it has to be positive even number.");
			return null;
		}

		matrix = new int[n][n];

		//create top half of the matrix
		for (int row = 0; row < matrix.length/2; row++) {
			for (int col = 0; col < matrix.length; col++) {
				// elements before and after diagonal elements are set zeros
				// row = number of elements to be set zero 
				if (col < row || col > n-1-row ) {
					matrix[row][col] = 0;
				} else {
					matrix[row][col] = 1;
				}
			}
		}
		//mirror bottom half of the matrix
		for (int row = 0; row < matrix.length/2; row++) {
			matrix[n-1-row] = matrix[row];
		}

		return matrix;
	}
	
	/**
	 * Convenience method to print matrix to console
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
		System.out.println("Test 1. n=4");
		printMatrix(createMatrix(4));

		System.out.println("Test 2. n=-10");
		printMatrix(createMatrix(-10));
		
		System.out.println("Test 3. n=6");
		printMatrix(createMatrix(6));
		
		System.out.println("Test 4. n=0");
		printMatrix(createMatrix(0));

	}

}
