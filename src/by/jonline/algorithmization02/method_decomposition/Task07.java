package by.jonline.algorithmization02.method_decomposition;

/**
 * 2 Algorithmization Одномерные массивы. Декомпозиция с использованием методов
 * (подпрограммы). Задание 7<br/>
 * Написать метод (методы), для вычисления суммы факториалов всех нечетных чисел
 * от 1 до 9.
 * 
 * @author tsyhanok.aa
 *
 */
public class Task07 {

	public static int summOddFactorials1To9() {
		int sum = 0;
		for (int i = 1; i <= 9; i = i + 2) {
			sum += factorial(i);
		}
		return sum;
	}

	private static int factorial(int n) {
		int p = 1;
		for (int i = 2; i <= n; i++) {
			p *= i;
		}

		return p;
	}

	public static void main(String[] args) {
		System.out.println("Testing factorial");
		System.out.println("3! = 6 actual result=" + factorial(3));
		System.out.println("5! = 120 actual result=" + factorial(5));
		System.out.println("9! = 362880 actual result=" + factorial(9));
		System.out.println("Testing summOddFactorials1To9. Expected result=368047");
		System.out.println(summOddFactorials1To9());
	}
}
