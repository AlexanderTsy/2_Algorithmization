/**
 * 
 */
package by.jonline.algorithmization02.multidimensional_array;

import java.util.Arrays;
import java.util.Objects;

/**
 * 2 Algorithmization Массивы массивов. Задание 11<br/>
 * Матрицу 10х20 заполнить случайными числами от 0 до 15. Вывести на экран саму
 * матрицу и номера строк, в которых число 5 встречается три и более раз.
 * 
 * @author tsyhanok.aa
 *
 */
public class Task11 {
	private static int[][] matrix  = new int[10][20];
	private static int[] rowNumbersWith5MoreEq3Times;
	private static boolean isMatrixFilled = false;
	
	
	/**
	 * Method fills class variable matrix[10][20] with random values within range [0;15]
	 * 
	 * @return created matrix
	 */
	public static void fillMatrix() {
		
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[0].length; col++) {
				matrix[row][col] = (int) Math.round(Math.random()*15);
			}
		}
		isMatrixFilled = true;
		fillRowNumbersWith5MoreEqThan3Times();
	}
	
	/**
	 * Method fills array of row numbers where 5 occurs more than 3 times 
	 */
	private static void fillRowNumbersWith5MoreEqThan3Times() {
		int count5MoreEq3Times;
		int count5;
		int col;
		int[] rowNumbers = new int[20];
		
		if (!isMatrixFilled) {
			// It's better to throw exception
			System.err.println("Error. Call to fill row numbers with 5 occuring more than 3 times. Matrix hasn't been filled.");
			return;
		}
		
		count5MoreEq3Times = 0;
		for (int row = 0; row < matrix.length; row++) {
			count5 = 0;
			col = 0;
			while (count5 < 3 && col < matrix[0].length) {
				if (matrix[row][col] == 5) {
					count5++;
					if (count5 >= 3) {
						rowNumbers[count5MoreEq3Times] = row;
						count5MoreEq3Times++;
						break;
					}
				}
				col++;
			}
		}
		
		rowNumbersWith5MoreEq3Times = new int[count5MoreEq3Times];
		for (int i = 0; i < rowNumbersWith5MoreEq3Times.length; i++) {
			rowNumbersWith5MoreEq3Times[i] = rowNumbers[i];
		}
	}
	
	/**
	 * Convenience method to print matrix to console
	 * 
	 * @param matrix
	 */
	private static void printMatrix(int[][] matrix) {
		if (!isMatrixFilled) {
			// It's better to throw exception
			System.err.println("Error. Matrix hasn't been filled.");
			return;
		}
		
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
		//Test
		fillMatrix();
		System.out.println("Matrix");
		printMatrix(matrix);
		System.out.println("Numbers of row with 5 occuring 3 and more times: \n"+Arrays.toString(rowNumbersWith5MoreEq3Times));
	}

}
