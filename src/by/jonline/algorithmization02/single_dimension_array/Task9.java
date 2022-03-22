package by.jonline.algorithmization02.single_dimension_array;

/**
 * 4. Algorithmization Одномерные массивы. Задание 9<br/>
 * В массиве целых чисел с количеством элементов n найти наиболее часто
 * встречающееся число. Если таких чисел несколько, то определить наименьшее из
 * них.
 * 
 * @author tsyhanok.aa
 *
 */
public class Task9 {

	/**
	 * Method minimalMostFrequentNumber
	 * @param array
	 * @return minimum of most frequently occurring numbers in the array.
	 */
	public static int minimalMostFrequentNumber(int[] array) {
		// array storing how frequent are elements starting from this
		int[] frequncyArray = new int[array.length]; 
		int maxFrequency; // counter for maximum frequency of elements
		int result;
		
		if(array.length == 0) {
			// it's better to throw exception here
			System.err.println("Array has zero length.");
			return 0;
		}
		
		// compare each element with the rest of elements
		// store frequency relatively to the rest 
		maxFrequency = 1;
		for (int i = 0; i < array.length; i++) {
			frequncyArray[i]=1;
			for (int j=i+1; j < array.length; j++) {
				if(array[i] == array[j]) {
					frequncyArray[i]++;
					if (frequncyArray[i] > maxFrequency ) {
						maxFrequency = frequncyArray[i];
					}
				}
			}
		}
		
		result = Integer.MAX_VALUE;
		for (int i = 0; i < array.length; i++) {
			// check if it is one of most frequent element
			if (frequncyArray[i] == maxFrequency) {
				// check for minimal value
				if (array[i] < result) {
					result = array[i];
				}
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		// Test arrays
		int[] arr1 = {1, 1, 2, 2, 33, 3123, 1230, -12};
		int[] arr2 = {};
		int[] arr3 = {Integer.MIN_VALUE, Integer.MIN_VALUE, 2, 2, 33, 3123, 1230, -12};
		int[] arr4 = {14890, 14890, 2, 2, 33, 33, 120, 120};

		System.out.println("Test 1. Expected output: 1. Actual output: "+minimalMostFrequentNumber(arr1));
		
		System.out.println("Test 2. arr2[] Expected output: 0 Error zero length message. Actual output: "+minimalMostFrequentNumber(arr2));
		
		System.out.println("Test 3. Expected output: -2147483648. Actual output: "+minimalMostFrequentNumber(arr3));
		
		System.out.println("Test 4. Expected output: 2. Actual output: "+minimalMostFrequentNumber(arr4));
	}

}
