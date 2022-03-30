package by.jonline.algorithmization02.array_sort;

import java.util.Arrays;
import java.util.Objects;

/**
 * 2 Algorithmization Одномерные массивы. Сортировки. Задание 5<br/>
 * <b>Сортировка вставками.</b> Дана последовательность чисел a<sub>1</sub>,
 * a<sub>2</sub>, ..., a<sub>n</sub>. Требуется переставить числа в порядке
 * возрастания. Делается это следующим образом. Пусть a<sub>1</sub>,
 * a<sub>2</sub>, ..., a<sub>i</sub> - упорядоченная последовательность, т.е.
 * a<sub>1</sub> &leq; a<sub>2</sub> &leq; ... &leq; a<sub>n</sub>. Берется
 * следующее число a<sub>i+1</sub> и вставляется в последовательность так, чтобы
 * новая последовательность была также возрастающей. Процесс производится до тех
 * пор, пока все элементы от i + 1 до n не будут перебраны. <i>Примечание.</i>
 * Место помещения очередного элемента в отсортированную часть производить с
 * помощью двоичного поиска. Двоичный поиск оформить в виде отдельной функции.
 * 
 * @author tsyhanok.aa
 *
 */
public class Task05 {

	/**
	 * Method performs insertion sort. Each value is inserted into result array
	 * depending on its value. Insertion position is found using binary search.
	 * @param array
	 * @return sorted array
	 */
	public static int[] insertionSort(int[] array) {
		if(Objects.isNull(array)) {
			return null;
		}
		
		int[] result = new int[0];
		int insertAt;
		
		for(int i = 0; i < array.length; i++) {
			insertAt = binarySearch(array[i],result);
			result = insertValueAt(insertAt, array[i],result);
		}
		
		return result;
	}
	
	/**
	 * Method inserts a value at given index into array 
	 * @param index of insertion
	 * @param value to be inserted
	 * @param array for insertion
	 * @return array with inserted value
	 */
	private static int[] insertValueAt(int index, int value, int[] array) {
		int[] result = new int[array.length+1];
		for (int i = 0; i < result.length; i++) {
			if(i < index) {
				result[i] = array[i];
			} else if (index == i) {
				result[i] = value;
			} else {
				result[i] = array[i-1];
			}
		}
		return result;
	}

	public static int binarySearch(int search, int[] array) {
		int midPoint;
		int start;
		int finish;
		
		if(Objects.isNull(array) || Objects.isNull(search)) {
			System.err.println("Null objects");
			return 0;
		}
		if(array.length == 0) {
			return 0;
		}
		
		start = 0;
		finish = array.length - 1;
		midPoint = (start + finish)/2;
		
		while (start <= finish) {
			if(search <= array[start]) {
				return start;
			}
			if(search >= array[finish]) {
				return finish+1;
			}
			if(search < array[midPoint]) {
				finish = midPoint - 1;
			} else if (search == array[midPoint]) {
				return midPoint;
			} else {
				start = midPoint + 1;
			}
			midPoint = (start + finish)/2;
		}
		return midPoint;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr;

		System.out.println("Test binarySearch");
		arr = new int[] { 0, 1, 3, 5 };
		System.out.println(binarySearch(1, arr));

		arr = new int[] { 15, 12, 1, 6, 60, 0, -15, 67, 100 };
		System.out.println("Test 1 random values");
		System.out.println(Arrays.toString(insertionSort(arr)));

		System.out.println("Test 2 Values ordered descending");
		arr = new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		System.out.println(Arrays.toString(insertionSort(arr)));

		System.out.println("Test 3 Empty array");
		arr = new int[] {};
		System.out.println(Arrays.toString(insertionSort(arr)));

		System.out.println("Test 4 Array is null");
		arr = null;
		System.out.println(Arrays.toString(insertionSort(arr)));
	}

}
