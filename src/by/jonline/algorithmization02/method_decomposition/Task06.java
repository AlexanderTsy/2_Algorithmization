package by.jonline.algorithmization02.method_decomposition;

/**
 * 2 Algorithmization Одномерные массивы. Декомпозиция с использованием методов
 * (подпрограммы). Задание 6<br/>
 * Написать метод (методы), проверяющий, являются ли данные три числа вазимно
 * простыми.
 * 
 * @author tsyhanok.aa
 *
 */
public class Task06 {

	/**
	 * Method checks if three integers a,b,c are coprime.
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	public static boolean isCoprimeInt(int a, int b, int c) {
		int gcd;
		gcd = greatestCommonDivisor(a, b);
		if (gcd == 1) {
			gcd = greatestCommonDivisor(a * b, c);
			if (gcd == 1) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Method calculates greatest common divisor of two integers
	 * using Euclid's algorithm
	 * 
	 * @param a > 0
	 * @param b > 0
	 * @return greatest common divisor
	 */
	private static int greatestCommonDivisor(int a, int b) {
		int tmp;
		
		//abs
		a = Math.abs(a);
		b = Math.abs(b);
		
		//First number have to be greater than second
		if (a < b) {
			tmp = a;
			a = b;
			b = tmp;
		}
		
		// gcd for 0, if both numbers are equal to zero return 0
		if (b == 0) {
			return a;
		}
		
		//calculating gcd using Euclid's algorithm
		do {
			tmp = b;
			b = a % b;
			a = tmp;
		} while (b > 0);
		
		//returning gcd
		return a;
	}
	
	public static void main(String[] args) {
		
		System.out.println("Test 1. {3, 4, 7}: true expected");
		System.out.println(isCoprimeInt(3, 4, 7));
		
		System.out.println("Test 2. {3, 4, 8}: false expected");
		System.out.println(isCoprimeInt(3, 4, 8));
		
		System.out.println("Test 3. {-3, 4, 7}. true expected");
		System.out.println(isCoprimeInt(-3, 4, 7));
		
		System.out.println("Test 4. {0, 4, 7}. false expected");
		System.out.println(isCoprimeInt(0, 4, 7));
	}

}
