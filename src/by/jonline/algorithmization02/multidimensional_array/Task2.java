package by.jonline.algorithmization02.multidimensional_array;

/**
 * 2 Algorithmization Массивы массивов. Задание 2.<br/>
 * Дана квадратная матрица. Вывести на экран элементы, стоящие на диагонали.
 * 
 * @author tsyhanok.aa
 *
 */
public class Task2 {

	/**
	 * Method prints diagonal elements of matrix
	 * @param array
	 */
	public static void printDiagonalElements(int[][] array) {
		int matrixSize;

		// check empty array
		if (array.length == 0) {
			System.err.println("Empty array. Nothing to output.");
			return;
		}

		// check array is square
		matrixSize = array[0].length;
		for (int i = 0; i < matrixSize; i++) {
			if (array[i].length != matrixSize) {
				System.err.println("This is not square matrix");
				return;
			}
		}

		// print diagonal elements
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i][i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// Test matrices
		// Test arrays
		int[][] arr1 = {
				{ 1, 2, 4, 10}, 
				{ 1, 2, 3, 4},
				{ 1, 2, 3, 1},
				{ 1, 2, 4, 4}
				};
		
		int[][] arr2 = {
				{ 5, 2, 4, 10, 12, 5 }, 
				{ 1, 2, 3, 4, 5 },
				{ 1, 2, 4, 1, 2, 5 }
				};
		
		int[][] arr3 = {};
		
		System.out.println("Test1. Expected output 1 2 3 4");
		printDiagonalElements(arr1);
		
		System.out.println("Test2. Not square matrix");
		printDiagonalElements(arr2);
		
		System.out.println("Test3. Empty array");
		printDiagonalElements(arr3);
	}

}
