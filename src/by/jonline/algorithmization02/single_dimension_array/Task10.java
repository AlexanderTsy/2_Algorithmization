package by.jonline.algorithmization02.single_dimension_array;

import java.util.Arrays;

/**
 * 2. Algorithmization Одномерные массивы. Задание 10<br/>
 * Дан целочисленный массив с количеством элементов n. Сжать массив, выбросив из
 * него каждый второй элемент (освободившиеся элементы заполнить нулями).
 * Примечание. Дополнительный массив не использовать.
 * 
 * @author tsyhanok.aa
 *
 */
public class Task10 {

	/**
	 * Method compresses array of integers. Each odd-numbered array element is set to zero.
	 * @param array
	 */
	public static void compressArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if(i%2 == 1) {
				array[i] = 0;
			}
		}
	}
	
	public static void main(String[] args) {
		// Test arrays
		int[] arr1 = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		int[] arr2 = {Integer.MAX_VALUE, Integer.MAX_VALUE, 321, 32432, 3432, 32423, 11355};

		compressArray(arr1);
		compressArray(arr2);
		
		//print compressed arrays
		System.out.println("Test arr1 "+Arrays.toString(arr1));
		System.out.println("Test arr2 "+Arrays.toString(arr2));
	}

}
