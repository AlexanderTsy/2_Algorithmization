package by.jonline.algorithmization02.method_decomposition;

import java.util.Arrays;
import java.util.Objects;

/**
 * 2 Algorithmization Одномерные массивы. Декомпозиция с использованием методов
 * (подпрограммы). Задание 4<br/>
 * На плоскости заданы своими координатами n точек. Написать метод (методы),
 * определяющие между какими из пар точек самое большое расстояние.
 * <i>Указание.</i> Координаты точек занести в массив.
 * 
 * @author tsyhanok.aa
 *
 */
public class Task04 {

	/**
	 * Method calculates distance between two points on surface
	 * 
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @return distance
	 */
	private static double distance(double x1, double y1, double x2, double y2) {
		return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
	}

	/**
	 * Method finds numbers of points in input array of Cartesian coordinates
	 * 
	 * @param points double[][] array of points given by Cartesian x,y coordinates
	 * @return int[] pair of numbers of points with maximum distance
	 */
	public static int[] pointsWithMaximumDistance(double[][] points) {
		double maxDistance = 0;
		double distance = 0;
		int pt1number = 0;
		int pt2number = 1;

		if (Objects.isNull(points)) {
			System.err.println("Input array is null");
			return null;
		}

		if (points.length < 2) {
			System.err.println("There should be at least two points in the array");
			return null;
		}

		for (int i = 0; i < points.length - 1; i++) {
			if (points[i].length < 2) {
				System.err.println("Wrong array size i=" + i + " " + Arrays.toString(points[i]));
				continue;
			}
			for (int j = i + 1; j < points.length; j++) {
				if (j == points.length - 1 && points[j].length < 2) {
					System.err.println("Wrong array size i=" + j + " " + Arrays.toString(points[j]));
					continue;
				}
				distance = distance(points[i][0], points[i][1], points[j][0], points[j][1]);
				if (distance > maxDistance) {
					pt1number = i;
					pt2number = j;
					maxDistance = distance;
				}
			}
		}
		return new int[] { pt1number, pt2number };
	}

	public static void main(String[] args) {
		double[][] points;

		System.out.println("Test 1. Normal operation.");
		points = new double[][] { { 0, 0 }, { 1, 1 }, { 3, 4 }, { 10, 10 } };
		System.out.println(Arrays.toString(pointsWithMaximumDistance(points)));

		System.out.println("Test 2. Wrong input array size.");
		points = new double[][] { { 0 }, { 1, 1 }, { 3, 4 }, { 10 } };
		System.out.println(Arrays.toString(pointsWithMaximumDistance(points)));

		System.out.println("Test 3. One point array.");
		points = new double[][] { { 1, 3 } };
		System.out.println(Arrays.toString(pointsWithMaximumDistance(points)));

		System.out.println("Test 4. Null array.");
		points = null;
		System.out.println(Arrays.toString(pointsWithMaximumDistance(points)));
	}
}
