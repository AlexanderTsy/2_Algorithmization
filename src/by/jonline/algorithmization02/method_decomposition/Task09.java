package by.jonline.algorithmization02.method_decomposition;

/**
 * 2 Algorithmization Одномерные массивы. Декомпозиция с использованием методов
 * (подпрограммы). Задание 9<br/>
 * Даны числа X, Y, Z, T длины сторон четырехугольника. Написать метод (методы)
 * вычисления его площади, если угол между сторонами длиной X и Y прямой.
 * 
 * XYZT can be convex or concave quadrilateral. Let XYZT be convex quadrilateral
 * for simplicity.
 * 
 * @author tsyhanok.aa
 *
 */
public class Task09 {

	/**
	 * Method calculated area of convex quadrilateral with sides X, Y, Z, T
	 * where X and Y are perpendicular
	 * @param x
	 * @param y
	 * @param z
	 * @param t
	 * @return area of quadrilateral or NaN if fails to calculate
	 */
	public static double areaOfXYZT(double x, double y, double z, double t) {
		double h; // hypotenuse
		
		// side length have to be positive
		if (x <= 0 || y <= 0 || z <= 0 || t <= 0) {
			return Double.NaN;
		}

		/*
		 * area of XYZT equals sum of areas of two triangles one with sides X, Y and
		 * second with sides Z, T the third side for both triangles is hypotenuse of X,
		 * Y
		 */
		h = Math.sqrt(x * x + y * y);

		// case of quadrilateral degenerates to triangle
		if (z + t == h) {
			return 0.5 * x * y;
		}

		// normal case. Concave quadrilateral
		return triangleAreaByHeron(x, y, h) + triangleAreaByHeron(z, t, h);
	}

	/**
	 * Method calculates area of the triangle with sides x, y, z using Heron formula
	 * 
	 * @param x
	 * @param y
	 * @param z
	 * @return area of triangle or NaN if fails to calculate
	 */
	private static double triangleAreaByHeron(double a, double b, double c) {
		double s; // semi-perimeter

		if (!isValidTriangle(a, b, c)) {
			return Double.NaN;
		}

		s = (a + b + c) / 2;

		return Math.sqrt(s * (s - a) * (s - b) * (s - c));
	}

	/**
	 * Method checks if triangle with sides x, y, z exists
	 * 
	 * @param x
	 * @param y
	 * @param z
	 * @return true if triangle exists
	 */
	private static boolean isValidTriangle(double x, double y, double z) {
		// all sides must be positive numbers
		if (x <= 0 || y <= 0 || z <= 0) {
			return false;
		}
		// Check longest side less than sum of shorter sides
		// suppose x longest side
		if (x > y && x > z) {
			if (x >= y + z) {
				return false;
			}
		}
		// suppose y longest side
		if (y > x && y > z) {
			if (y >= x + z) {
				return false;
			}
		}
		// suppose z longest side
		if (z > x && z > y) {
			if (z >= x + y) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		double x, y, z, t;

		System.out.println("Test 1. X=3, Y=4, Z=3, T=4. Expected 12.0");
		x = 3;
		y = 4;
		z = 3;
		t = 4;
		System.out.println(areaOfXYZT(x, y, z, t));

		System.out.println("Test 2. X=3, Y=4, Z=2, T=3. Expected 6.0");
		x = 3;
		y = 4;
		z = 2;
		t = 3;
		System.out.println(areaOfXYZT(x, y, z, t));
		
		System.out.println("Test 3. X=3, Y=4, Z=1, T=3. Expected NaN");
		x = 3;
		y = 4;
		z = 1;
		t = 3;
		System.out.println(areaOfXYZT(x, y, z, t));
		
		System.out.println("Test 4. X=-3, Y=4, Z=2, T=3. Expected NaN");
		x = -3;
		y = 4;
		z = 2;
		t = 3;
		System.out.println(areaOfXYZT(x, y, z, t));
	}
}
