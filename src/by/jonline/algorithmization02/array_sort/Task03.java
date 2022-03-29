package by.jonline.algorithmization02.array_sort;

import java.util.Arrays;
import java.util.Objects;

/**
 * 2 Algorithmization Одномерные массивы. Сортировки. Задание 3<br/>
 * Сортировка выбором. Дана последовательность чисел a<sub>1</sub> &leq;
 * a<sub>2</sub> &leq; ... &leq; a<sub>n</sub>. Требуется переставить 
 * элементы так, чтобы они были расположены по убыванию. Для этого в 
 * массиве, начиная с первого, выбирается наибольший элемент и ставится
 * на первое место, а первый - на место наибольшего. Затем, начиная со
 * второго, эта процедура повторяется. Написать алгоритм сортировки
 * выбором.
 * 
 * @author tsyhanok.aa
 *
 */
public class Task03 {

	/**
	 * Method sorts array descending using selection sort algorithm
	 * @param array 
	 */
	public static void sortSelectionAlgorithmDescending(int[] array) {
		int temp;
		if (Objects.isNull(array)) {
			return;
		}
		
		for (int i = 0; i < array.length; i++) {
			for (int j = i+1; j < array.length; j++) {
				if(array[i] < array[j]) {
					temp = array[j];
					array[j] = array[i];
					array[i] = temp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr;
		
		arr = new int[] {15,12,1,6,60,0,-15,67,100};
		System.out.println("Test 1 random values");
		sortSelectionAlgorithmDescending(arr);
		System.out.println(Arrays.toString(arr));
		
		System.out.println("Test 2 Values ordered ascending");
		arr = new int[] {1,2,3,4,5,6,7,8,9};
		sortSelectionAlgorithmDescending(arr);
		System.out.println(Arrays.toString(arr));
		
		System.out.println("Test 3 Empty array");		
		arr = new int[] {};
		sortSelectionAlgorithmDescending(arr);
		System.out.println(Arrays.toString(arr));
		
		System.out.println("Test 4 Array is null");
		arr = null;
		sortSelectionAlgorithmDescending(arr);
		System.out.println(Arrays.toString(arr));
	}

}
