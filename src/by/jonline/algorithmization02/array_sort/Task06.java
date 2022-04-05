package by.jonline.algorithmization02.array_sort;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

/**
 * 2 Algorithmization Одномерные массивы. Сортировки. Задание 6<br/>
 * <b>Сортировка Шелла.</b> Дана последовательность чисел <i>a<sub>1</sub>,
 * a<sub>2</sub>, ..., a<sub>n</sub></i>. Требуется упорядочить его по
 * возрастанию. Делается это следующим образом: сравниваются два соседних
 * элемента <i>a<sub>i</sub> и a<sub>i+1</sub></i>. <br/>Если
 * <i>a<sub>i</sub>&leq;a<sub>i+1</sub></i>, то продвигаются на один элемент
 * вперед. Если <i>a<sub>i</sub>&gt;a<sub>i+1</sub></i>, то производится
 * перестановка и сдвигаются на один элемент назад. Составить алгоритм этой
 * сортировки.
 * 
 * @author tsyhanok.aa
 *
 */
public class Task06 {

	public static void sortShell(int[] array) {
		
		int step;
		int temp;
		
		if(Objects.isNull(array) || array.length < 2) {
			return;
		}
		
		//Donald Shell step O(n2)
		step = array.length / 2;
		
		while (step > 0) {
			for (int i = step; i < array.length; i++) {
				int j = i;
				while (j >= step && array[j] < array[j - step]) {
					temp = array[j-step];
					array[j - step] = array[j];
					array[j] = temp;
					j = j - step;
				}
			}
			step = step / 2;
		}
		
	}
	
	/**
	 * Method checks if array is sorted ascending 
	 * @param array
	 * @return true if array is sorted ascending, otherwise returns false
	 */
	private static boolean checkSortedAscending (int[] array) {
		for (int i = 0; i < array.length-1; i++) {
			if (array[i+1]<array[i]) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr;

		arr = new int[] {-197, -16871, 190874, -15, 67,-249, 158, 1239, 168,15, 12, 1, 6, 60, 0,  1449, 100};
		
		System.out.println("Test 1 random values");
		sortShell(arr);
		System.out.println("Is array sorted ascending: "+checkSortedAscending(arr));
		System.out.println(Arrays.toString(arr));

		System.out.println("Test 2 Values ordered descending");
		arr = new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		sortShell(arr);
		System.out.println("Is array sorted ascending: "+checkSortedAscending(arr));
		System.out.println(Arrays.toString(arr));

		System.out.println("Test 3 Empty array");
		arr = new int[] {};
		System.out.println("Is array sorted ascending: "+checkSortedAscending(arr));
		sortShell(arr);
		System.out.println(Arrays.toString(arr));

		System.out.println("Test 4 Array is null");
		arr = null;
		sortShell(arr);
		System.out.println(Arrays.toString(arr));
		
		System.out.println("Test 5 Big random array");
		arr = new int[1000000];
		Random rnd = new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rnd.nextInt(2000000) - 1000000; 
		}
		long startTime = System.currentTimeMillis();
		sortShell(arr);
		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		System.out.println("SelectionSort for 1M integer :  " + elapsedTime + " ms");
		System.out.println("Is array sorted ascending: "+checkSortedAscending(arr));
		
	}

}
