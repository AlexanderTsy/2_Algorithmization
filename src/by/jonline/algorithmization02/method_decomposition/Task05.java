package by.jonline.algorithmization02.method_decomposition;

import java.util.Objects;

/**
 * 2 Algorithmization Одномерные массивы. Декомпозиция с использованием методов
 * (подпрограммы). Задание 5<br/>
 * Составить программу, которая в массиве A[N] находит второе по величине число
 * (вывести на печать число, которое меньше максимального элемента массива, но
 * больше всех других элементов).
 * 
 * @author tsyhanok.aa
 *
 */
public class Task05 {
	public static void printSecondLargestNumber(int[] a) {

		if (Objects.isNull(a)) {
			System.out.println("Array is null. Nothing to print.");
			return;
		}

		if (a.length == 0) {
			System.out.println("Array has no elements. Nothing to print.");
			return;
		}

		if (a.length == 1) {
			System.out.println("Array has only one element. Can't find second largest element.");
			return;
		}

		Integer secondLargest = secondLargestNumber(a);

		if (!Objects.isNull(secondLargest)) {
			System.out.println(secondLargest);
		}
	}

	private static Integer secondLargestNumber(int[] a) {
		int max = Integer.MIN_VALUE;
		int secondMax = Integer.MIN_VALUE;

		for (int i = 0; i < a.length; i++) {
			if (a[i] > max) {
				secondMax = max;
				max = a[i];
			}
			if (a[i] > secondMax && a[i] < max) {
				secondMax = a[i];
			}
		}

		if (max == secondMax) {
			System.out.println("No different numbers. Can't find second largest number.");
			return null;
		}

		return secondMax;

	}

	public static void main(String[] args) {
		int[] arr;

		arr = new int[] { -100, 90, 3, 88, 1903, -1324234, 12, 444 };

		System.out.println("Test 1. Normal operation. 444 expected.");
		printSecondLargestNumber(arr);

		arr = new int[] { -100, 90, 3, 88, 1903, 1903, -1324234, 12, 444 };

		System.out.println("Test 2. Max number occures more than once. 444 expected.");
		printSecondLargestNumber(arr);

		arr = null;
		System.out.println("Test 3. Array is null.");
		printSecondLargestNumber(arr);

		arr = new int[] {};
		System.out.println("Test 4. Array is empty.");
		printSecondLargestNumber(arr);

		arr = new int[] { 1 };
		System.out.println("Test 5. Array has one element.");
		printSecondLargestNumber(arr);
		
		arr = new int[] { 1, 1 };
		System.out.println("Test 6. Array has equal elements.");
		printSecondLargestNumber(arr);
	}
}
