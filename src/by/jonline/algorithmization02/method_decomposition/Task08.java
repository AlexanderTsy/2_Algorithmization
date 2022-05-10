package by.jonline.algorithmization02.method_decomposition;

import java.util.Objects;

/**
 * 2 Algorithmization Одномерные массивы. Декомпозиция с использованием методов
 * (подпрограммы). Задание 8<br/>
 * Задан массив D. Определить следующие суммы: D[1]+D[2]+D[3]; D[3]+D[4]+D[5];
 * D[4]+D[5]+D[6]. <i>Пояснение.</i> Составить метод (методы) для вычисления
 * суммы трех последовательно расположенных элементов массива с номерами от k до
 * m.
 * 
 * @author tsyhanok.aa
 *
 */
public class Task08 {

	private static double sumElementsFromTo(double[] d, int k, int m) {
		double sum = 0;
		
		if (Objects.isNull(d)) {
			System.out.println("Array is null.");
		}
		
		if (d.length == 0) {
			System.out.println("Array is empty.");
		}
		
		if (k < 0 || k > d.length) {
			System.out.println("Array index is out of bounds.");
		}
		
		if (m < 0 || m > d.length) {
			System.out.println("Array index is out of bounds.");
		}
		
		for (int i = k; i <= m; i++) {
			sum += d[i];
		}
		
		return sum;
	}
	
	public static double sumThreeElements(double[] d, int k) {
		return sumElementsFromTo(d, k, k+2);
	}
	
	public static void main(String[] args) {
		
		double[] d; 
		
		System.out.println("Test sumElementsFromTo");
		d = new double[] {22, 1, 2.15, -2.15, 0.124, 4, 99.15};
		System.out.println(sumElementsFromTo(d, 1, 3));
		
		System.out.println("Test sumThreeElements. D[1]+D[2]+D[3]");
		System.out.println(sumThreeElements(d, 1));
		System.out.println("Test sumThreeElements. D[3]+D[4]+D[5]");
		System.out.println(sumThreeElements(d, 3));
		System.out.println("Test sumThreeElements. D[4]+D[5]+D[6]");
		System.out.println(sumThreeElements(d, 4));
	}

}
