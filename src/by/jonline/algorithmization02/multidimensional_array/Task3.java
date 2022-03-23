package by.jonline.algorithmization02.multidimensional_array;

/**
 * 2 Algorithmization Массивы массивов. Задание 2.<br/>
 * Дана матрица. Вывести k-ю строку и p-й столбец матрицы.
 * 
 * @author tsyhanok.aa
 *
 */
public class Task3 {

	/**
	 * Method prints k row of a matrix.
	 * @param array
	 * @param k is 1-based index of row
	 */
	public static void printRow(int[][] array, int k) {
		if (isEmptyArray(array)) {
			System.err.println("Empty array. Nothing to output");
			return;
		}
		if (!isMatrix(array)) {
			System.err.println("Array is not a matrix. Rows are not the same length.");
			return;
		}
		
		if (k > array[0].length) {
			System.err.println("Row number k="+k+" is bigger than number of rows");
			return;
		}
		
		for (int i = 0; i < array[0].length; i++) {
			System.out.print(array[k-1][i]+" ");
		}
		System.out.println();
	}
	
	/**
	 * Method prints p row of a matrix.
	 * @param array
	 * @param p is 1-based index of column
	 */
	public static void printColumn(int[][] array, int p) {
		if (isEmptyArray(array)) {
			System.err.println("Empty array. Nothing to output");
			return;
		}
		if (!isMatrix(array)) {
			System.err.println("Array is not a matrix. Rows are not the same length.");
			return;
		}
		
		if (p > array.length) {
			System.err.println("Column number p="+p+" is bigger than number of columns");
			return;
		}
		
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i][p-1]+" ");
		}
		System.out.println();
	}
	
	/**
	 * Method checks for empty array
	 * @param array
	 * @return true if array is empty, false if not empty
	 */
	private static boolean isEmptyArray(int[][] array) {
		// check empty array
		if (array.length == 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * Method checks if array is matrix
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
		// Test arrays
		int[][] arr1 = {
				{ 1, 2, 4, 10}, 
				{ 1, 2, 3, 4},
				{ 1, 2, 3, 1},
				{ 1, 2, 4, 4}
				};
		
		//not matrix
		int[][] arr2 = {
				{ 5, 2, 4, 10, 12, 5 }, 
				{ 1, 2, 3, 4, 5 },
				{ 1, 2, 4, 1, 2, 5 }
				};
		
		//empty array
		int[][] arr3 = {};
		
		System.out.println("Test 1. Print k=1 row of arr1");
		printRow(arr1, 1);
		
		System.out.println("Test 2. Print k=5 row of arr1 having 4 rows");
		printRow(arr1, 5);

		System.out.println("Test 3. Print k=2 row of arr2. Not matrix");
		printRow(arr2, 2);
		
		System.out.println("Test 4. Print k=2 row of arr3. Empty array");
		printRow(arr3, 2);
		
		System.out.println("Test 5. Print p=2 column of arr1");
		printColumn(arr1, 2);
		
		System.out.println("Test 6. Print p=5 column of arr1 having 4 columns");
		printColumn(arr1, 5);
		
		System.out.println("Test 7. Print p=2 row of arr3. Empty array");
		printColumn(arr3, 2);
	}

}
