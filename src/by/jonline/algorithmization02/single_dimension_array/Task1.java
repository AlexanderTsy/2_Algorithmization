package by.jonline.algorithmization02.single_dimension_array;

import java.util.Scanner;

public class Task1 {
	/*
	 * 2. Algorithmization Одномерные массивы. Задание 1 В массив A[N] занесены
	 * натуральные числа. Найти сумму тех элементов, которые кратны данному К.
	 */

	/*
	 * Решение. Запросим значение К с клавиатуры. Числа будут кратными, если остаток
	 * от деления равен 0.
	 */
	public static void main(String[] args) {
		int[] a = { 1, 3, 12, 43, 78, 121, 44, 125, 748, 11, 67 }; // массив A[N]
		int k = 0; // переменная К
		int sum = 0; // искомая сумма

		@SuppressWarnings("resource") // не закрываем сканер, использующий System.in
		Scanner scanner = new Scanner(System.in);

		// Получим число К
		boolean inputOK = false; // если ввод будет верный, К - натуральное число, то присвоим true
		do {
			System.out.println("Введите натуральное число К:");
			if (scanner.hasNextInt()) {
				k = scanner.nextInt();
				if (k > 0) {
					inputOK = true;
				} else {
					System.err.println("Введенное число меньше 0.");
				}
			}
		} while (!inputOK);

		// вычислим сумму элементов кратных К
		for (int i = 0; i < a.length; i++) {
			if (a[i] % k == 0) {
				sum += a[i];
			}
		}

		System.out.println("Сумма элементов массива A[N] кратных К=" + k + " равна: " + sum);
	}

}
