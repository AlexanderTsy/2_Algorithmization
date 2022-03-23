package by.jonline.algorithmization02.multidimensional_array;

import static java.lang.Math.pow;
import static java.lang.Math.sin;

import java.util.Arrays;
import java.util.Objects;

/**
 * 2 Algorithmization Массивы массивов. Задание 7<br/>
 * Сформировать квадратную матрицу порядка N по правилу: <br/>
 * &emsp;&emsp; A[I,J] = sin((I<sup>2</sup>-J<sup>2</sup>)/N)<br/>
 * и подсчитать количество положительных элементов в ней.
 * 
 * @author tsyhanok.aa
 *
 */
public class Task7 {

	/**
	 * Creates and fills square matrix of order n with values 
	 * A[I,J] = sin((I<sup>2</sup>-J<sup>2</sup>)/N)
	 * @param n order of matrix
	 * @return Object[2] where first element is created matrix double[][] and second element is long count of positive elements
	 */
	public static Object[] createMatrix(final int n){
		Object[] result = new Object[2];
		double[][] matrix;
		double elementValue;
		long count = 0;
		
		if (n < 1) {
			System.err.println("Wrong n=" + n + " it has to be positive number.");
			return null;
		}
		
		matrix = new double[n][n];
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				elementValue = sin((pow(i+1,2)-pow(j+1,2))/n);
				matrix[i][j] = elementValue;
				if (elementValue > 0) {
					count++;
				}
			}
		}
		
		result[0] = matrix;
		result[1] = count;
		return result;
	}
	
	/**
	 * Convenience method to print matrix to console
	 * @param matrix
	 */
	private static void printMatrix(double[][] matrix) {
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
		Object[] result;
		double[][] matrix;
		long count;
		
		
		// Test 1
		System.out.println("Test 1. Matrix order 5");
		result = createMatrix(5);
		matrix = (double[][]) result[0];
		count = (long) result[1];
		printMatrix(matrix);
		System.out.println("Number of positive elements=" + count);
		
		// Test 2
		System.out.println("Test 2. Matrix order 0");
		result = createMatrix(0);
	}

}
