package by.jonline.algorithmization02.single_dimension_array;

public class Task3 {
	/*
	 * 3. Algorithmization Одномерные массивы. Задание 3 Дан массив действительных
	 * чисел, размерность которого N. Подсчитать, сколько в нем отрицательных,
	 * положительных и нулевых элементов.
	 */

	private static int n = 10000; // размерность массива N
	private static double[] array = new double[n];

	public static void main(String[] args) {
		// Для демонстрации работы алгоритма
		// зададим содержимое массива случайным образом
		for (int i = 0; i < array.length; i++) {
			array[i] = (Math.random() - 0.5) * 10000;
		}

		// Объявим и инициализируем переменные количества элементов
		int countZero = 0; // нули
		int countNegative = 0; // отрицательные
		int countPositive = 0; // положительные

		// подсчитаем количество элементов
		for (int i = 0; i < array.length; i++) {
			if (array[i] < 0) {
				countNegative++;
			} else if (array[i] == 0) {
				countZero++;
			} else {
				countPositive++;
			}
		}
		System.out.println("Количество отрицательных элементов: " + countNegative);
		System.out.println("Количество нулей: " + countZero);
		System.out.println("Количество положительных элементов: " + countPositive);
	}

}
