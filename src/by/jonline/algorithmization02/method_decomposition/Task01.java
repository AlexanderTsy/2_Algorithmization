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
	
	//Least common multiple
	/**
	 * Method calculates least common multiple of integers a and b
	 * @param a
	 * @param b
	 * @return least common multiple or 0 if a and/or b equals 0
	 */
	public static long leastCommonMultiple(int a, int b) {
		if (a == 0 || b == 0) {
			return 0;
		}
		
		return a*b/greatestCommonDivisor(a, b);
	}
	
	//Lowest common denominator
	/**
	 * Method calculates greatest common divisor of integers a and b
	 * @param a
	 * @param b
	 * @return
	 */
	public static long greatestCommonDivisor(int a, int b) {
		int i = 2;
		int result = 1;
		
		if (a == 0 || b == 0) {
			return 0;
		}
		
		while (i< a/2 || i< b/2) {
			if (a % i == 0 && b % i == 0) {
				a = a/i;
				b = b/i;
				result *= i;
			} else {
				i++;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int a;
		int b;
		
		a = 9;
		b = 27;
		System.out.println(String.format("Test 1. For %d and %d", a, b));
		System.out.println("GCD="+greatestCommonDivisor(a, b));
		System.out.println("LCM="+leastCommonMultiple(a, b));
		
		a = 45;
		b = 180;
		
		System.out.println(String.format("Test 2. For %d and %d", a, b));
		System.out.println("GCD="+greatestCommonDivisor(a, b));
		System.out.println("LCM="+leastCommonMultiple(a, b));
		
		a = 0;
		b = 180;
		
		System.out.println(String.format("Test 3. For %d and %d", a, b));
		System.out.println("GCD="+greatestCommonDivisor(a, b));
		System.out.println("LCM="+leastCommonMultiple(a, b));
		
		a = 13;
		b = 7;
		
		System.out.println(String.format("Test 3. For %d and %d", a, b));
		System.out.println("GCD="+greatestCommonDivisor(a, b));
		System.out.println("LCM="+leastCommonMultiple(a, b));
	}
}
