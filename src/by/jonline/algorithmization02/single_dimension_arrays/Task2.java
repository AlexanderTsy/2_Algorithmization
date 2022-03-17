package by.jonline.algorithmization02.single_dimension_arrays;

import java.util.Arrays;

public class Task2 {
	/*
	 * 2. Algorithmization Одномерные массивы. Задание 2 Дана последовательность
	 * действительных чисел a1, a2, ..., an Заменить все ее члены, большие данного
	 * Z, этим числом. Подсчитать количество замен.
	 */

	// последовательность действительных чисел
	private static double[] sequence = { 125.12, -0.15, 9.126, -0.167890, -1.129, 12, 998, 94.1689 };
	private static double z = 11.12;
	private static int count = 0;

	public static void main(String[] args) {

		System.out.println("Исходный массив");
		System.out.println(Arrays.toString(sequence));

		for (int i = 0; i < sequence.length; i++) {
			if (sequence[i] > z) {
				sequence[i] = z;
				count++;
			}
		}
		System.out.println("Измененный массив:");
		System.out.println(Arrays.toString(sequence));
		System.out.println("Количество произведенных замен: " + count);
	}

}
