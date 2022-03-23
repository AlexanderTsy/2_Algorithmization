package by.jonline.algorithmization02.multidimensional_array;

import java.util.Arrays;
import java.util.Objects;

/**
 * 2 Algorithmization Массивы массивов. Задание 4.<br/>
 * Сформировать квадратную матрицу порядка n по заданному образцу (n - четное)
 * <table>
 * <tr><td>1<td/><td>2<td/><td>3<td/><td>...<td/><td>n<td/><tr/>
 * <tr><td>n<td/><td>n-1<td/><td>n-2<td/><td>...<td/><td>1<td/><tr/>
 * <tr><td>1<td/><td>2<td/><td>3<td/><td>...<td/><td>n<td/><tr/>
 * <tr><td>n<td/><td>n-1<td/><td>n-2<td/><td>...<td/><td>1<td/><tr/>
 * <tr><td>...<td/><td>...<td/><td>...<td/><td>...<td/><td>...<td/><tr/>
 * <tr><td>n<td/><td>n-1<td/><td>n-2<td/><td>...<td/><td>1<td/><tr/>
 * <table/>
 * 
 * @author tsyhanok.aa
 *
 */
public class Task4 {

	/**
	 * Creates square matrix of even order n<br/>
	 * odd rows 1, 2, ..., n<br/>
	 * even rows n, n-1, ..., 1
	 * @param n
	 * @return created matrix
	 */
	public static int[][] createSquareMatrixOrderN(int n) {
		int[][] matrix;
		int[] matrixOddRow;
		int[] matrixEvenRow;
		
		if (n < 2 || n % 2 != 0) {
			System.err.println("Wrong n="+n+" it has to be positive even number.");
			return null;
		}
		
		matrix = new int[n][n];
		matrixOddRow = new int[n];
		matrixEvenRow = new int[n];
		
		for (int i = 0; i < n; i++) {
			matrixOddRow[i] = i+1;
			matrixEvenRow[i] = n-i;
		}
		
		for (int i = 0; i < n; i++) {
			if ((i+1) % 2 == 1) {
				matrix[i] = matrixOddRow;
			} else {
				matrix[i] = matrixEvenRow;
			}
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
		printMatrix(createSquareMatrixOrderN(4));

		System.out.println("Test 2. n=-10");
		printMatrix(createSquareMatrixOrderN(-10));
		
		System.out.println("Test 3. n=6");
		printMatrix(createSquareMatrixOrderN(6));
		
		System.out.println("Test 4. n=0");
		printMatrix(createSquareMatrixOrderN(0));
	}

}
