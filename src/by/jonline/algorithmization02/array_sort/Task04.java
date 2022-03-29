package by.jonline.algorithmization02.array_sort;

import java.util.Arrays;
import java.util.Objects;

/**
 * 2 Algorithmization Одномерные массивы. Сортировки. Задание 4<br/>
 * Сортировка обменами. Дана последовательность чисел a<sub>1</sub> &leq;
 * a<sub>2</sub> &leq; ... &leq; a<sub>n</sub>. Требуется переставить числа в
 * порядке возрастания. Для этого сравниваются два соседних числа a<sub>i</sub>
 * и a<sub>i+1</sub>. Если a<sub>i</sub> > a<sub>i+1</sub>, то делается
 * перестановка. Так продолжается до тех пор, пока все элемены не станут
 * расположены в порядке возрастания. Составить алгоритм сортировки, подсчитывая
 * при этом количество перестановок.
 * 
 * @author tsyhanok.aa
 *
 */
public class Task04 {

	/**
	 * Method bubble sorts array ascending. If element greater than next element,
	 * they are swapped.
	 * 
	 * @param array
	 * @return
	 */
	public static int bubbleSortAscending(int[] array) {
		int swaps = 0;
		int temp;

		if (Objects.isNull(array) || array.length <= 1) {
			return 0;
		}

		// variable i tracks how many elements have been set
		// in ascending order
		for (int i = 0; i < array.length - 1; i++) {
			// every time biggest element is swapped right
			// to the end of array minus number of iterations
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					swaps++;
					temp = array[j + 1];
					array[j + 1] = array[j];
					array[j] = temp;
				}
			}
		}

		return swaps;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr;

		arr = new int[] { 15, 12, 1, 6, 60, 0, -15, 67, 100 };
		System.out.println("Test 1 random values");
		System.out.println("Swaps:" + bubbleSortAscending(arr));
		System.out.println(Arrays.toString(arr));

		System.out.println("Test 2 Values ordered descending");
		arr = new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		System.out.println("Swaps:" + bubbleSortAscending(arr));
		System.out.println(Arrays.toString(arr));

		System.out.println("Test 3 Empty array");
		arr = new int[] {};
		System.out.println("Swaps:" + bubbleSortAscending(arr));
		System.out.println(Arrays.toString(arr));

		System.out.println("Test 4 Array is null");
		arr = null;
		System.out.println("Swaps:" + bubbleSortAscending(arr));
		System.out.println(Arrays.toString(arr));
	}

}
