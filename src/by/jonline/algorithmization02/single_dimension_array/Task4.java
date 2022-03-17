package by.jonline.algorithmization02.single_dimension_array;

import java.util.Arrays;

public class Task4 {
	/*
	 * 4. Algorithmization Одномерные массивы. Задание 4 Даны действительные числа
	 * a1, a2, ..., an. Поменять местами наибольший и наименьший элементы.
	 */
	
	//зададим тестовый массив элементов a1, a2, ..., an
	private static double[] a = {1.654, 132009.00, 9121580, 6547, 567, -119680, 0, 65480.564098};

	public static void main(String[] args) {
		//инициализируем минимальный и максимальный элементы
		double min = a[0];
		double max = a[0];
		// позиции мин и макс элементов
		int posAtMin=0;
		int posAtMax=0;
		
		// найдем минимальное и максимальное число
		for (int i = 1; i < a.length; i++) {
			if (a[i]>max) {
				max=a[i];
				posAtMax=i;
			}
			if (a[i]<min) {
				min=a[i];
				posAtMin=i;
			}
		}
		
		// поменяем минимальный и максимальный элементы местами
		a[posAtMax]=min;
		a[posAtMin]=max;

		//Выведем измененный массив
		System.out.println(Arrays.toString(a));
	}

}
