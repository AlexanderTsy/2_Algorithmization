package by.jonline.algorithmization02.single_dimension_array;

import java.util.Scanner;

public class Task1 {
	/*
	 * 2. Algorithmization Одномерные массивы. Задание 1 В массив A[N] занесены
	 * натуральные числа. Найти сумму тех элементов, которые кратны данному К.
	 */

	/*
	 * Метод вычисляет сумму элементов массива, кратных K
	 */
	public static long sumOfMultipleToK(int[] arr, int k) {
		long sum = 0;
		long previousSum = 0;
		for (int i = 0; i < arr.length; i++) {
			// Проверка входных данных
			if (arr[i] <= 0) {
				// возможно лучше выбросить исключение, System.out и System.err не синхронизированы
				System.err.println("В массиве есть элементы не натуральные числа A["+i+"]="+arr[i]);
				return 0;
			}
			// Числа будут кратными k, если остаток от деления равен 0.
			if (arr[i] % k == 0) {
				sum += arr[i];
			}
			// проверка переполнения типа long
			if (sum < previousSum) {
				System.err.println("Переполнение типа long");
				return 0;
			} else {
				previousSum = sum;
			}
		}
		return sum;
	}
	
	/*
	 * Метод запрашивает положительное число типа int с клавиатуры
	 */
	private static int getPositiveInt(String message) {
		@SuppressWarnings("resource") // не закрываем сканер, использующий System.in
		Scanner scanner = new Scanner(System.in);
		
		int k = 0;

		// Получим число К > 0
		do {
			System.out.println(message);
			while (!scanner.hasNextInt()) {
				scanner.next();
				System.out.println(message);
			}
			k = scanner.nextInt();
		} while (k <= 0);
		
		return k;
	}
	
	public static void main(String[] args) {
		int k; // переменная К
		long sum; // искомая сумма
		
		// Тестовый массив 1
		int[] a1 = { 1, 3, -65, 43, 78, 121, 44, 125, 748, 11, 67 };
		// Тестовый массив 2
		int[] a2 = { 1, 3, Integer.MAX_VALUE-1, Integer.MAX_VALUE-1, Integer.MAX_VALUE-1, Integer.MAX_VALUE-1, Integer.MAX_VALUE-1, 125, 748, 11, 67 };
		
		
		System.out.println("Тестовый массив 1");
		
		k = getPositiveInt("Введите положительное целое k >>");
		
		// вычислим сумму элементов кратных К
		sum = sumOfMultipleToK(a1, k);
		System.out.println("Сумма элементов массива A[N] кратных К=" + k + " равна: " + sum);
		
		System.out.println("Тестовый массив 2");
		
		k = getPositiveInt("Введите положительное целое k >>");
		
		// вычислим сумму элементов кратных К
		sum = sumOfMultipleToK(a2, k);
		System.out.println("Сумма элементов массива A[N] кратных К=" + k + " равна: " + sum);
	}

}
