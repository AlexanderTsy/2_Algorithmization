package by.jonline.algorithmization02.single_dimension_array;

import java.util.Arrays;

public class Task2 {
	/*
	 * 2. Algorithmization Одномерные массивы. Задание 2 Дана последовательность
	 * действительных чисел a1, a2, ..., an Заменить все ее члены, большие данного
	 * Z, этим числом. Подсчитать количество замен.
	 */
	
	/** 
	 * Метод изменяет передаваемый массив <b>arr</b>, в котором все элементы больше <b>z</b> заменяются этим числом 
	 * @param arr изменяемый массив
	 * @param z число
	 * @return возвращает число замен 
	 */
	public static int replaceGreaterThanZandCalcReplacements(double[] arr, final double z) {
		int replacementCount = 0;
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > z) {
				arr[i] = z;
				replacementCount++;
			}
		}
		
		return replacementCount;
	}

	public static void main(String[] args) {
		int count; // количество замен
		// последовательность действительных чисел
		double[] sequence = { 125.12, -0.15, 9.126, -0.167890, -1.129, 12, 998, 94.1689 };
		// число z
		double z = 11.12;
		
		System.out.println("Исходный массив");
		System.out.println(Arrays.toString(sequence));
		System.out.println("Число z="+z);
		count = replaceGreaterThanZandCalcReplacements(sequence, z);
		
		System.out.println("Измененный массив:");
		System.out.println(Arrays.toString(sequence));
		System.out.println("Количество произведенных замен: " + count);
	}

}
