package by.jonline.algorithmization02.single_dimension_array;

import java.util.Scanner;

/**
 * 5. Algorithmization Одномерные массивы. Задание 5 Даны целые числа a1, a2,
 * ..., an. Вывести на печать только те числа, для которых ai>i.
 * 
 * @author tsyhanok.aa
 * 
 */
public class Task5 {

	// метод выводит в стандартный вывод числа, значение которых больше их номера
	public static void printGreaterThanI(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] > i) {
				System.out.println(array[i]);
			}
		}
	}

	// метод запрашивает ввести целое число с сообщением message
	private static int enterIntFromConsole(String message) {

		@SuppressWarnings("resource") // не закрываем сканер, использующий System.in
		Scanner scanner = new Scanner(System.in);

		System.out.print(message);
		while (!scanner.hasNextInt()) {
			System.out.print(message);
			scanner.next();
		}
		return scanner.nextInt();
	}

	// метод для генерации массива целых чисел
	// размер массива length, числа в пределах min, max
	private static int[] generateArray(int length, int min, int max) {
		int[] arr = new int[length];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = getRandomNumber(min, max);
		}

		return arr;
	}

	// метод для генерации целых чисел в границах min, max
	private static int getRandomNumber(int min, int max) {
		return (int) ((Math.random() * (max - min)) + min);
	}

	public static void main(String[] args) {
		int arrayLength;
		int minVal;
		int maxVal;
		int[] arr;

		// запросим тестовые данные
		arrayLength = enterIntFromConsole("Введите размер массива");
		minVal = enterIntFromConsole("Введите минимум для генерации числа");
		maxVal = enterIntFromConsole("Введите максимум для генерации числа");

		// сгенерируем тестовый массив
		arr = generateArray(arrayLength, minVal, maxVal);

		// выведем числа для которых ai>i
		printGreaterThanI(arr);

	}

}
