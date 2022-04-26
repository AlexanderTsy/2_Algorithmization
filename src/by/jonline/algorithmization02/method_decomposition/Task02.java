/**
 * 
 */
package by.jonline.algorithmization02.method_decomposition;

/**
 * 2 Algorithmization Одномерные массивы. Декомпозиция с использованием методов
 * (подпрограммы). Задание 2<br/>
 * Написать метод (методы) для нахождения наибольшего общего делителя четырех
 * натуральных чисел.
 * 
 * @author tsyhanok.aa
 *
 */
public class Task02 {

	/**
	 * Method calculates greatest common divisor of four non-negative integers
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @param d
	 * @return greatest common divisor
	 */
	public static int greatestCommonDivisor(int a, int b, int c, int d) {
		return greatestCommonDivisor(greatestCommonDivisor(a, b), greatestCommonDivisor(c, d));
	}

	/**
	 * Method calculates greatest common divisor of two non-negative integers
	 * using Euclid's algorithm
	 * 
	 * @param a > 0
	 * @param b > 0
	 * @return greatest common divisor
	 */
	public static int greatestCommonDivisor(int a, int b) {
		int tmp;
		if (a < 0 || b < 0) {
			System.out.println("Numbers have to be positive integer.");
			return 0;
		}
		//First number have to be greater than second
		if (a < b) {
			tmp = a;
			a = b;
			b = tmp;
		}

		if (b == 0) {
			return a;
		}
		
		return greatestCommonDivisor(b, a % b);
	}

	public static void main(String[] args) {

		System.out.println("Test 1. 1 2 3 4");
		System.out.println(greatestCommonDivisor(1, 2, 3, 4));
		
		System.out.println("Test 2. 90 15 30 45");
		System.out.println(greatestCommonDivisor(90, 15, 30, 45));
	}

}
