package by.jonline.algorithmization02.method_decomposition;

import java.util.Arrays;

/**
 * 2 Algorithmization Одномерные массивы. Декомпозиция с использованием методов
 * (подпрограммы). Задание 10<br/>
 * Дано натуральное число N. Написать метод (методы) для формирования массива,
 * элементами которого являются цифры числа N.
 * 
 * @author tsyhanok.aa
 *
 */
public class Task10 {

	/**
	 * Method converts natural number n to array of its digits
	 * @param n
	 * @return byte[] array of digits
	 */
	public static byte[] numberToArrayOfDigits(long n) {
		byte[] digits;
		String nToString;
		
		if (!isNaturalNumber(n)) {
			return null;
		}
		
		nToString = Long.toString(n);
		digits = new byte[nToString.length()];
		
		for (int i = 0; i < digits.length; i++) {
			digits[i] = digitAtPos(nToString, i);
		}
		
		return digits;
	}
	
	/**
	 * Method check if argument is natural number
	 * @param n
	 * @return
	 */
	private static boolean isNaturalNumber(long n) {
		return n > 0;
	}
	
	/**
	 * Method returns digit at position in number
	 * @param numberAsString number converted to string
	 * @param pos position of digit
	 * @return digit at position
	 */
	private static byte digitAtPos (String numberAsString, int pos) {
		return Byte.valueOf(numberAsString.substring(pos, pos+1));
	}
	
	public static void main(String[] args) {
		long n;
		byte[] digits;
		
		System.out.println("Test 1. N = 127498275382350");
		n = 127498275382350L;
		digits = numberToArrayOfDigits(n);
		System.out.println(Arrays.toString(digits));
	}
}
