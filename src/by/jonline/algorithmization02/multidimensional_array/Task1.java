package by.jonline.algorithmization02.multidimensional_array;

/**
 * 2 Algorithmization Массивы массивов. Задание 1.<br/>
 * Дана матрица. Вывести на экран все нечетные столбцы, у которых первый элемент
 * больше последнего.
 * 
 * @author tsyhanok.aa
 *
 */
public class Task1 {

	/**
	 * Method prints to console odd-numbered columns having first element greater
	 * than last one.
	 * 
	 * @param array
	 */
	public static void printColumns1stGreaterLast(int[][] array) {
		int rowLength;
		int columnLength;
		// check for empty array
		if (array.length == 0) {
			System.err.println("Empty array. Nothing to output");
			return;
		}
		
		// check all the rows are of the same length
		rowLength = array[0].length;
		for (int i = 1; i < array.length; i++) {
			if (array[i].length != rowLength) {
				System.err.println("Wrong array. Rows are not the same length.");
				return;
			}
		}

		//print columns
		columnLength = array.length;
		for (int row = 0; row < columnLength; row++) {
			for (int i = 0; i < rowLength; i++) {
				// check odd-number column, columns in matrix start with 1
				// so i have to be even
				if (i % 2 == 0) {
					// check first element in column is greater than last one
					if (array[0][i] > array[columnLength - 1][i]) {
						// store columns to new array
						System.out.print(array[row][i] + "\t");
					}
				}
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {
		// Test arrays
		int[][] arr1 = {
				{ 5, 2, 4, 10, 12, 5 }, 
				{ 1, 2, 3, 4, 5, 6 },
				{ 1, 2, 4, 1, 2, 5 }
				};
		
		int[][] arr2 = {
				{ 5, 2, 4, 10, 12, 5 }, 
				{ 1, 2, 3, 4, 5 },
				{ 1, 2, 4, 1, 2, 5 }
				};
		
		int[][] arr3 = {};

		System.out.println("Test 1");
		printColumns1stGreaterLast(arr1);
		
		System.out.println("Test 2. Not consistent matrix.");
		printColumns1stGreaterLast(arr2);
		
		System.out.println("Test 3. Empty array.");
		printColumns1stGreaterLast(arr3);
	}

}
