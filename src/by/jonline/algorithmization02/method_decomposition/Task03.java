package by.jonline.algorithmization02.method_decomposition;

/**
 * 2 Algorithmization Одномерные массивы. Декомпозиция с использованием методов
 * (подпрограммы). Задание 3<br/>
 * Вычислить площадь правльного шестиугосльника со стороной a, используя мотод
 * вычисления площади треугольника.
 * 
 * @author tsyhanok.aa
 *
 */
public class Task03 {

	/**
	 * Method calculates area of equilateral triangle
	 * 
	 * @param a
	 * @return area of equilateral triangle with side a or 0 if argument is wrong
	 */
	private static double equilateralTriangleArea(double a) {

		if (a < 0) {
			System.out.println("Side length has to be non-negative");
			return 0;
		}

		return Math.sqrt(3) / 4 * a * a;
	}

	/**
	 * Method calculates area of regular hexagon
	 * 
	 * @param a
	 * @return area of regular hexagon with side a or 0 if argument is wrong
	 */
	public static double regularHexagonArea(double a) {
		if (a < 0) {
			System.out.println("Side length has to be non-negative");
			return 0;
		}

		return equilateralTriangleArea(a) * 6;
	}
	
	public static void main(String[] args) {
		System.out.println("Test 1. Side length a=10");
		System.out.println(regularHexagonArea(10));
		
		System.out.println("Test 2. Side length is negative");
		System.out.println(regularHexagonArea(-10));
		
		System.out.println("Test 3. Side length a=1.316074012952492461");
		System.out.println(regularHexagonArea(1.316074012952492461));
		
	}
}
