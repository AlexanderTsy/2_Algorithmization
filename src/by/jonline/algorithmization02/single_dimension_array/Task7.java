package by.jonline.algorithmization02.single_dimension_array;

/**
 * 4. Algorithmization Одномерные массивы. Задание 7<br/>
 * Даны действительные числа a1, a2, ..., an.<br/>
 * Найти max(a1 + a2n, a2 + a2n-1, ..., an + an+1)
 * 
 * @author tsyhanok.aa
 *
 */
public class Task7 {

	/**
	 * Method finds maximum of pair's sums
	 * @param a
	 * 		double[] array of real numbers
	 * @return
	 * 		max(a<sub>1</sub> + a<sub>2n</sub>, a<sub>2</sub> + a<sub>2n-1</sub>, ..., a<sub>n</sub> + a<sub>n+1</sub>)
	 */
	public static double maxSumOfPair(double[] a) {
		double result;
		int n;
		double[] arrayOfSums;
		
		// check array length is even
		if (a.length%2 == 1) {
			System.err.println("Array length is odd, have to be even.");
			return 0;
		}
		
		n = a.length/2;
		arrayOfSums = new double[n];
		
		// Sum pairs of elements
		for (int i = 0; i < n; i++) {
			arrayOfSums[i] = a[i]+a[a.length-1-i];
		}
		
		result = arrayOfSums[0];
		
		for (int i = 0; i < arrayOfSums.length; i++) {
			if (arrayOfSums[i] > result) {
				result = arrayOfSums[i];
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		//Test array 1
		double[] arr1 = {1, 2, 6, 1, 2, 1};
		
		//Test array 2
		double[] arr2 = {0, 1, 2, 6, 1, 2, 1};
		
		System.out.println("Result for arr1 = "+maxSumOfPair(arr1));
		System.out.println("Result for arr2 = "+maxSumOfPair(arr2));

	}

}
