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

	public static void insertionSort(int[] array) {
		
	}
	
	public static int binarySearch(int search, int[] array) {
		int result;
		int midPoint;
		int[] left_arr;
		int[] right_arr;
		
		if(Objects.isNull(array) || Objects.isNull(search)) {
			System.err.println("Null objects");
			return 0;
		}
		if(array.length == 0) {
			return 0;
		}
		
		midPoint = (array.length-1)/2;
		while (midPoint > 0 && midPoint < array.length) {
			if(search < array[midPoint]) {
				midPoint = midPoint/2;
			} else {
				midPoint += midPoint/2;
			}
		}
		
		
		return midPoint;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr;

		arr = new int[] { 15, 12, 1, 6, 60, 0, -15, 67, 100 };
		System.out.println("Test 1 random values");
		insertionSort(arr);
		System.out.println(Arrays.toString(arr));

		System.out.println("Test 2 Values ordered descending");
		arr = new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		insertionSort(arr);
		System.out.println(Arrays.toString(arr));

		System.out.println("Test 3 Empty array");
		arr = new int[] {};
		insertionSort(arr);
		System.out.println(Arrays.toString(arr));

		System.out.println("Test 4 Array is null");
		arr = null;
		insertionSort(arr);
		System.out.println(Arrays.toString(arr));
	}

}
