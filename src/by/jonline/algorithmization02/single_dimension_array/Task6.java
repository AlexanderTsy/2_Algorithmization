package by.jonline.algorithmization02.single_dimension_array;

/**
 * Algorithmization Одномерные массивы. Задание 6<br/>
 * Задана последовательность N вещественных чисел. Вычислить сумму
 * чисел, порядковые номера которых являются простыми числами.
 * 
 * @author Alexandr Tsyhanok
 */
public class Task6 {

	/**
	 * Method sums values of array elements which numbers are prime numbers
	 * @param array
	 * @return sum of array elements which numbers are prime. 
	 */
	public static double sumValuesByPrimeNumber(double[] array) {
		double sum = 0;
		
		for (int i = 0; i < array.length; i++) {
			if (isPrime(i)) {
				sum += array[i];
			}		
		}
		return sum;
	}

	/**
	 * Method checks if passed integer n is prime number.
	 * @param n positive integer
	 * @return true if {@code n} is prime number,<br/> false if {@code n} is not prime
	 */
	private static boolean isPrime(int n) {
		if (n < 2) {
			return false;
		}
		for (int i = 2; i <= n / 2; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		//testing isPrime method
		System.out.println("Testing. Prime number from 0 to 299");
		for (int i = 0; i < 300; i++) {
			if (isPrime(i)) System.out.print(i+" ");
		}
		System.out.print("\r\n");
		
		//test array
		double arr[] = { 1, 0.894, 123158, 4658408, 14858, -1.48, -456.54678, 45, 0.4848, 12, 8899, 446, 0.468, 0.668 };
		System.out.println("Sum of array elements which numbers are prime.");
		System.out.println("Sum="+sumValuesByPrimeNumber(arr));
		
		//test array 2
		System.out.println("Sum of array elements which numbers are prime. Test2 Overflow");
		double arr1[] = { 0, 1, Double.MAX_VALUE, Double.MAX_VALUE, 123158, 4658408, 14858, -1.48, -456.54678, 45, 0.4848, 12, 8899, 446, 0.468, 0.668 };
		
		System.out.println("Sum="+sumValuesByPrimeNumber(arr1));
	}

	

}
