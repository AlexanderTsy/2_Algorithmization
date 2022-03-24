/**
 * 
 */
package by.jonline.algorithmization02.multidimensional_array;

import java.util.Arrays;
import java.util.Objects;

/**
 * 2 Algorithmization Массивы массивов. Задание 10<br/>
 * Найти положительные элементы главной диагонали квадратной матрицы.
 * 
 * @author tsyhanok.aa
 *
 */
public class Task10 {
	
	/**
	 * Method finds positive elements of the main diagonal of a squareMatrix.
	 * 
	 * @param squareMatrix
	 * @return array of positive elements of the main diagonal
	 */
	public static int[] getPositiveDiagonalElements(int[][] squareMatrix) {
		int matrixOrder;
		int positiveCount;
		int[] result;
		
		//check null or empty array
		if (Objects.isNull(squareMatrix) || squareMatrix.length == 0) {
			System.err.println("Array is null or empty.");
			return null;
		}
		
		matrixOrder = squareMatrix.length;
		//check matrix is square
		for (int i = 0; i < squareMatrix.length; i++) {
			if (Objects.isNull(squareMatrix[i]) || squareMatrix[i].length != matrixOrder) {
				System.err.println("Array is not a square matrix.");
				return null;
			}
		}
		
		positiveCount = 0;
		for (int i = 0; i < squareMatrix.length; i++) {
			if ( squareMatrix[i][i] > 0 ) {
				positiveCount++;
			}
		}
		
		result = new int[positiveCount];
		positiveCount = 0;
		for (int i = 0; i < squareMatrix.length; i++) {
			if ( squareMatrix[i][i] > 0 ) {
				result[positiveCount] = squareMatrix[i][i];
				positiveCount++;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		// Tests
		int[][] arr1 = {	{1, 2, 0, 10, 5},
							{1, 2, 0, 10, 5},
							{1, 2, -10, 10, 5},
							{1, 2, 0, -2, 5},
							{1, 2, 0, 10, 5}						
		};
		
		int[][] arr2 = {	{1, 2, 0, 10, 5},
							{1, 2, 0, 10, 5},
							null,
							{1, 2, 0, -2, 5},
							{1, 2, 0, 10, 5}						
};
		
		int[][] arr3 = {	{1, 2, 0, 10},
				{1, 2, 0, 10, 5},
				{1, 2, -10, 10, 5},
				{1, 2, 0, -2, 5},
				{1, 2, 0, 10, 5}						
};
		
		int[][] arr4 = null;
		
		int[][] arr5 = new int[0][0];
		
		System.out.println("Test 1. Expected result [1, 2, 5]");
		System.out.println(Arrays.toString(getPositiveDiagonalElements(arr1)));
		
		System.out.println("Test 2. Not a square matrix. Return null");
		System.out.println(Arrays.toString(getPositiveDiagonalElements(arr2)));
		
		System.out.println("Test 3. Not a square matrix. Return null");
		System.out.println(Arrays.toString(getPositiveDiagonalElements(arr3)));
		
		System.out.println("Test 4. Null or empty array. Return null");
		System.out.println(Arrays.toString(getPositiveDiagonalElements(arr4)));
		
		System.out.println("Test 5. Null or empty array. Return null");
		System.out.println(Arrays.toString(getPositiveDiagonalElements(arr5)));
	}

}
