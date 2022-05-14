package by.jonline.algorithmization02.method_decomposition;

import java.util.Arrays;
import java.util.Objects;

/**
 * 2 Algorithmization Одномерные массивы. Декомпозиция с использованием методов
 * (подпрограммы). Задание 12<br/>
 * Даны натуральные числа K и N. Написать метод (методы) для формирования
 * массива A, элементами которого являются числа, сумма цифр кторых равна K и
 * которые не больше N.
 * 
 * @author Aliaxandr Tsyhanok shurius@gmail.com
 *
 */
public class Task12 {

	/**
	 * Method creates array of numbers being less than n and having sum of its
	 * digits equal to k
	 * 
	 * @param k positive integer
	 * @param n positive integer
	 * @return array
	 */
	public static int[] makeArray(int k, int n) {
		int[] array;
		int arrSize = 10;
		int numOfElements = 0;
		array = new int[arrSize];
		int i = 1;

		if (k <= 0 || n <= 0) {
			System.out.println("Arguments have to be non-negative integers.");
			return null;
		}

		while (i < n) {
			if (sumOfDigits(i) == k) {
				array[numOfElements] = i;
				numOfElements++;
				if (arrSize <= numOfElements) {
					array = resizeArray(array);
					arrSize = array.length;
				}
			}
			i++;
		}
		return resizeArray(array, numOfElements);
	}

	/**
	 * Doubles the size of the array
	 * 
	 * @param arr
	 * @return returns the array with doubled size
	 */
	private static int[] resizeArray(int[] arr) {
		int[] newArr = new int[arr.length * 2];
		for (int i = 0; i < arr.length; i++) {
			newArr[i] = arr[i];
		}
		return newArr;
	}

	/**
	 * Resize the array to specified size
	 * 
	 * @param arr
	 * @param size
	 * @return array with length equal to size variable
	 */
	private static int[] resizeArray(int[] arr, int size) {
		int[] newArr = new int[size];

		if (Objects.isNull(arr)) {
			return null;
		}

		for (int i = 0; i < arr.length && i < size; i++) {
			newArr[i] = arr[i];
		}

		return newArr;
	}

	/**
	 * Method calculates sum of digits in the number
	 * 
	 * @param n
	 * @return sum of digits
	 */
	private static int sumOfDigits(int n) {
		int sum = 0;
		int tmp = n * Integer.signum(n);
		while (tmp > 0) {
			sum += tmp % 10;
			tmp = tmp / 10;
		}

		return sum;
	}

	public static void main(String[] args) {
		int n, k;
		int[] a;

		n = 234;
		k = 12;

		System.out.println("Test. Array of numbers having sum of digits k and are less than n");
		System.out.println(String.format("k = %d, n = %d", k, n));
		a = makeArray(k, n);
		System.out.println(Arrays.toString(a));

		n = 500;
		k = 20;

		System.out.println("Test. Array of numbers having sum of digits k and are less than n");
		System.out.println(String.format("k = %d, n = %d", k, n));
		a = makeArray(k, n);
		System.out.println(Arrays.toString(a));

		n = -500;
		k = 20;

		System.out.println("Test. Array of numbers having sum of digits k and are less than n");
		System.out.println(String.format("k = %d, n = %d", k, n));
		a = makeArray(k, n);
		System.out.println(Arrays.toString(a));
	}
}
