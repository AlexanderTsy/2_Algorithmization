package by.jonline.algorithmization02.method_decomposition;

/**
 * 2 Algorithmization Одномерные массивы. Декомпозиция с использованием методов
 * (подпрограммы). Задание 11<br/>
 * Написать метод (методы), определяющий, в каком из данных двух чисел больше цифр.
 * 
 * @author tsyhanok.aa
 *
 */
public class Task11 {
	
	/**
	 * Method compares two long numbers n1 and n2 by number of digits
	 * @param n1
	 * @param n2
	 * @return -1 n1 contains less digits than n2, 0 if equal, 1 if n1 contains more digits than n2
	 */
	public static int compareDigits(long n1, long n2) {
		
		if (n1 == n2) {
			return 0;
		}
		
		return Integer.compare(numberDigitsLength(n1), numberDigitsLength(n2));
	}
	
	
	private static int numberDigitsLength(long n) {
		return Long.toString(abs(n)).length();
	}
	
	/**
	 * Method calculates modulus n
	 * @param n
	 * @return absolute value of n
	 */
	private static long abs(long n) {
		return n * Long.signum(n);
	}
	
	public static void main(String[] args) {
		long n1, n2;
		
		n1 = 12;
		n2 = 12L;
		System.out.println("Test 1. Equal numbers. 0 expected");
		System.out.println(compareDigits(n1, n2));
		
		
		n1 = 922980084984984980L;
		n2 = 10;
		System.out.println("Test 2. n1 longer than n2. 1 expected");
		System.out.println(compareDigits(n1, n2));
		
		n1 = 999999999;
		n2 = 999999999+1;
		System.out.println("Test 3. n1 shorter than n2. -1 expected");
		System.out.println(compareDigits(n1, n2));
		
		n1 = 10;
		n2 = -10;
		System.out.println("Test 4. Positive and negative numbers with same number of digits. 0 expected");
		System.out.println(compareDigits(n1, n2));
	}

}
