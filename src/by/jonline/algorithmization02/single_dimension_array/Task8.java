package by.jonline.algorithmization02.single_dimension_array;

import java.util.Arrays;

/**
 * 4. Algorithmization Одномерные массивы. Задание 7<br/>
 * Дана последовательность целых чисел a<sub>1</sub>, a<sub>2</sub>,...,
 * a<sub>n</sub>. Образовать новую последовательность, выбросив из исходной те
 * члены, которые равны min(a<sub>1</sub>, a<sub>2</sub>,..., a<sub>n</sub>)
 * 
 * @author tsyhanok.aa
 *
 */
public class Task8 {

	/**
	 * Method searches for minimum in the array and returns new array without
	 * elements equal to minimum
	 * 
	 * @param array
	 * @return array without elements equal to minimum
	 */
	public static int[] arrayWithoutMinElements(int[] array) {
		int j; // counter variable
		int min;
		int countMin; // count min elements to initialize new array
		int[] result;

		// returning empty array for empty array input
		if (array.length == 0) {
			return new int[0];
		}

		// find value of minimum element
		min = minA(array);

		// count number of elements equal to min 
		countMin = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == min) {
				countMin++;
			}
		}
		
		// check zero size new array
		if(array.length - countMin == 0) {
			return new int[0];
		}

		// initialize result array
		result = new int[array.length - countMin];
		j = 0;

		// fill new array
		for (int i = 0; i < array.length; i++) {
			if (array[i] > min) {
				result[j] = array[i];
				j++;
			}
		}

		return result;
	}

	/**
	 * Convenience method finds minimum value of the array
	 * 
	 * @param array
	 * @return array's minimum
	 */
	private static int minA(int[] array) {
		int min;

		if (array.length == 0) {
			System.err.println("Array length is zero");
		}

		min = array[0];

		for (int i = 1; i < array.length; i++) {
			if (array[i] < min) {
				min = array[i];
			}
		}

		return min;
	}

	public static void main(String[] args) {
		// declare variables
		int[] arr1 = { 1, 1, 1, 2, 3 };
		int[] arr2 = new int[0];
		int[] arr3 = { -Integer.MAX_VALUE, 1, 2, Integer.MAX_VALUE };
		int[] arr4 = { 1, 1, 1 };

		// Test using arrays
		System.out.println("Test 1. Expected output [2, 3]");
		System.out.println(Arrays.toString(arrayWithoutMinElements(arr1)));

		System.out.println("Test 2. Empty array. Expected output []");
		System.out.println(Arrays.toString(arrayWithoutMinElements(arr2)));

		System.out.println("Test 3. Max integer. Expected output [1, 2, 2147483647]");
		System.out.println(Arrays.toString(arrayWithoutMinElements(arr3)));
		
		System.out.println("Test 4. Equal elements. Expected output []");
		System.out.println(Arrays.toString(arrayWithoutMinElements(arr4)));
	}

}
