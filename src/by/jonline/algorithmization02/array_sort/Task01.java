package by.jonline.algorithmization02.array_sort;

import java.util.Arrays;
import java.util.Objects;

/**
 * 2 Algorithmization Одномерные массивы. Сортировки. Задание 1<br/>
 * Заданы два одномерных массива с различным количеством элементов и натуральное
 * число k. Объединить их в один массив, включив второй массив между k-м и
 * (k+1)-м элементами первого, при этом не используя дополнительный массив.
 * 
 * @author tsyhanok.aa
 *
 */
public class Task01 {

	/**
	 * Method returns result of insertion of array2 in array1 between k and k+1 elements 
	 * 
	 * @param array1 
	 * @param array2
	 * @param k at this index array2 is inserted in array1 
	 * @return joined array
	 */
	public static int[] insertArray(int[] array1, int[] array2, int k) {
		int[] result;
		
		if( Objects.isNull(array1)) {
			System.err.println("Array1 is null");
			return null;
		}
		
		if( Objects.isNull(array2) ) {
			return array1.clone();
		}
		
		try {
			Math.addExact(array1.length,array2.length);
		} catch (ArithmeticException e) {
			System.err.println("Sum of arrays lengths exceeds maximal index number.");
			return null;
		}
		
		if (k < 0) {
			System.err.println("Index value is negetive k="+k);
			return null;
		}
		
		if (k > array1.length - 1) {
			System.err.println("Index value is out of bounds k="+k);
			return null;
		}
		
		result = new int[array1.length+array2.length];
		for (int i = 0; i <= k; i++) {
			result[i] = array1[i];
		}
		for (int i = 0; i < array2.length; i++) {
			result[k+1+i] = array2[i];
		}
		for (int i = k+1; i < array1.length; i++) {
			result[array2.length+i] = array1[i];
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int[] array1;
		int[] array2;
		int[] result;
		
		System.out.println("Test 1. Normal operation");
		array1 = new int[] {1, 2, 3, 4, 5, 6, 7};
		array2 = new int[] {11, 22, 33, 44};
		result = insertArray(array1, array2, 2);
		System.out.println(Arrays.toString(result));
		
		System.out.println("Test 2. Second array is null");
		array2 = null;
		result = insertArray(array1, array2, 2);
		System.out.println(Arrays.toString(result));
		
		System.out.println("Test 3. First array is null");
		array1 = null;
		array2 = new int[] {11, 22, 33, 44};
		result = insertArray(array1, array2, 2);
		System.out.println(Arrays.toString(result));
		
		System.out.println("Test 4. k is out of bounds");
		array1 = new int[] {1, 2, 3, 4, 5, 6, 7};
		array2 = new int[] {11, 22, 33, 44};
		result = insertArray(array1, array2, 12);
		System.out.println(Arrays.toString(result));
		
	}

}
