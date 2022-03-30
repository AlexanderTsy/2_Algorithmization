package by.jonline.algorithmization02.array_sort;

import java.util.Arrays;
import java.util.Objects;

/**
 * 2 Algorithmization Одномерные массивы. Сортировки. Задание 6<br/>
 * <b>Сортировка Шелла.</b> Дана последовательность чисел <i>a<sub>1</sub>,
 * a<sub>2</sub>, ..., a<sub>n</sub></i>. Требуется упорядочить его по
 * возрастанию. Делается это следующим образом: сравниваются два соседних
 * элемента <i>a<sub>i</sub> и a<sub>i+1</sub></i>. <br/>Если
 * <i>a<sub>i</sub>&leq;a<sub>i+1</sub></i>, то продвигоются на один элемент
 * вперед. Если <i>a<sub>i</sub>&gt;a<sub>i+1</sub></i>, то производится
 * перестановка и сдвигаются на один элемент назад. Составить алгоритм этой
 * сортировки.
 * 
 * @author tsyhanok.aa
 *
 */
public class Task06 {

	public static void sortShell(int[] array) {
		boolean hasSwapped = true;
		int temp;
		int currentValue;
		
		if(Objects.isNull(array) || array.length < 2) {
			return;
		}
		
		//insertion sort
		for (int i = 1; i < array.length; i++) {
			currentValue = array[i];
			
			int j= i-1;
			while (j >= 0 && array[j] > currentValue) {
				array[j+1] = array[j];
				j--;
			}
			array[j + 1] = currentValue;
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr;

		arr = new int[] { 15, 12, 1, 6, 60, 0, -15, 67, 100 };
		System.out.println("Test 1 random values");
		sortShell(arr);
		System.out.println(Arrays.toString(arr));

		System.out.println("Test 2 Values ordered descending");
		arr = new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		sortShell(arr);
		System.out.println(Arrays.toString(arr));

		System.out.println("Test 3 Empty array");
		arr = new int[] {};
		sortShell(arr);
		System.out.println(Arrays.toString(arr));

		System.out.println("Test 4 Array is null");
		arr = null;
		sortShell(arr);
		System.out.println(Arrays.toString(arr));

	}

}
