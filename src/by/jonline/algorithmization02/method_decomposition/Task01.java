package by.jonline.algorithmization02.method_decomposition;

/**
 * 2 Algorithmization Одномерные массивы. Декомпозиция с использованием методов
 * (подпрограммы). Задание 1<br/>
 * Написать метод (методы) для нахождения общего делителя и наименьшего общего
 * кратного двух натуральных чисел: <i>(НОК(A,B)=AB/НОД(A,B))</i>
 * 
 * @author tsyhanok.aa
 *
 */
public class Task01 {

	// Least common multiple
	/**
	 * Method calculates least common multiple of integers a and b
	 * 
	 * @param a > 0
	 * @param b > 0
	 * @return least common multiple or 0 if either a or b are less than or equal to
	 *         0
	 */
	public static int leastCommonMultiple(int a, int b) {
		if (a <= 0 || b <= 0) {
			return 0;
		}

		return a * b / greatestCommonDivisor(a, b);
	}

	// Lowest common denominator
	/**
	 * Method calculates greatest common divisor of integers a and b
	 * using Euclid's algorithm
	 * 
	 * @param a > 0
	 * @param b > 0
	 * @return greatest common divisor or 0 if either a or b are less than or equal
	 *         to 0
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
		int a;
		int b;

		a = 9;
		b = 27;
		System.out.println(String.format("Test 1. For %d and %d", a, b));
		System.out.println("GCD=" + greatestCommonDivisor(a, b));
		System.out.println("LCM=" + leastCommonMultiple(a, b));

		a = 180;
		b = 45;

		System.out.println(String.format("Test 2. For %d and %d", a, b));
		System.out.println("GCD=" + greatestCommonDivisor(a, b));
		System.out.println("LCM=" + leastCommonMultiple(a, b));

		a = 0;
		b = 180;

		System.out.println(String.format("Test 3. For %d and %d", a, b));
		System.out.println("GCD=" + greatestCommonDivisor(a, b));
		System.out.println("LCM=" + leastCommonMultiple(a, b));

		a = -10;
		b = -10;

		System.out.println(String.format("Test 4. For %d and %d", a, b));
		System.out.println("GCD=" + greatestCommonDivisor(a, b));
		System.out.println("LCM=" + leastCommonMultiple(a, b));
	}
}
