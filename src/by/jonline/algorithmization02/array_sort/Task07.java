package by.jonline.algorithmization02.array_sort;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

/**
 * 2 Algorithmization Одномерные массивы. Сортировки. Задание 7<br/>
 * Пусть даны две неубывающие последовательности действительных чисел 
 * <i>a<sub>1</sub>&leq;a<sub>2</sub>&leq;...&leq;a<sub>n</sub> и 
 * b<sub>1</sub>&leq;b<sub>2</sub>&leq;...&leq;b<sub>m</sub></i>.
 * Требуется указать те места, на которые нужно вставлять элементы 
 * последовательности <i>b<sub>1</sub>&leq;b<sub>2</sub>&leq;...
 * &leq;b<sub>m</sub></i> в первую последовательность так, чтобы
 * новая последовательность оставалась возрастающей. 
 * 
 * @author tsyhanok.aa
 *
 */
public class Task07 {

	/**
	 * Merges two ascending sequences into one ascending sequence
	 * @param a
	 * @param b
	 * @return resulting sequence
	 */
	public static int[] mergeTwoSequences(int[] a, int[] b) {
		int[] result;
		int aNum; //counter for array a
		int bNum; //counter for array b
		
		if(Objects.isNull(a) || a.length == 0) {
			return b;
		}
		
		if(Objects.isNull(b) || b.length == 0) {
			return a;
		}
		
		result = new int[a.length + b.length];
		aNum = 0;
		bNum = 0;
		
		while (aNum < a.length || bNum < b.length) {
			//check sequence a is ascending
			if (aNum < a.length && aNum > 1 && (a[aNum] < a[aNum - 1])) {
				System.err.println("Sequence a is not ascending");
				return null;
			}
			//check sequence b is ascending
			if (bNum < b.length && bNum > 1 && (b[bNum] < b[bNum - 1])) {
				System.err.println("Sequence b is not ascending");
				return null;
			}
			
			//if a fully placed to result, inserting b elements
			if (aNum == a.length) {
				result[aNum + bNum] = b[bNum++];
				continue;
			}
			//if b fully placed to result, inserting a elements
			if (bNum == b.length) {
				result[aNum + bNum] = a[aNum++];
				continue;
			}
			
			if (a[aNum] < b[bNum]) {
				result[aNum + bNum] = a[aNum++];
				continue;
			}
			if (a[aNum] >= b[bNum]) {
				result[aNum + bNum] = b[bNum++];
				continue;
			}
		}
		
		return result;
	}
	
	/**
	 * Generates array of random integers of size n within range &plusmn;n
	 * @param n
	 * @return array of random integers
	 */
	private static int[] getRandomIntArrayOfSize(int n) {
		int[] a = new int[n];
		Random rnd = new Random();
		for (int i = 0; i < a.length; i++) {
			a[i] = rnd.nextInt(2*n) - n; 
		}
		return a;
	}
	
	/**
	 * Method checks if array is sorted ascending 
	 * @param array
	 * @return true if array is sorted ascending, otherwise returns false
	 */
	private static boolean checkSortedAscending (int[] array) {
		if(Objects.isNull(array)) {
			return false;
		}
		
		for (int i = 0; i < array.length-1; i++) {
			if (array[i+1]<array[i]) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		// Tests.
		int[] a;
		int[] b;
		int[] result;
		
		System.out.println("Test 1 Two big random arrays");
		a = getRandomIntArrayOfSize(1000000);
		b = getRandomIntArrayOfSize(1000000);
		Arrays.sort(a);
		Arrays.sort(b);
		
		long startTime = System.currentTimeMillis();
		result = mergeTwoSequences(a, b);
		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		
		System.out.println("Merging two 1M integer[] :  " + elapsedTime + " ms");
		System.out.println("Is array sorted ascending: "+checkSortedAscending(result));
		System.out.println("Sum of initial array lengths is equal to resulting array length: " + ((a.length+b.length)==result.length));
		
		System.out.println("Test 2 Two arrays");
		a = new int[] { 1, 12, 24, 36, 65, 80, 100, 200, 300 };
		b = new int[] { 5, 13, 17, 20, 68, 80, 120, 201, 299 };
		result = mergeTwoSequences(a, b);
		System.out.println("Is array sorted ascending: "+checkSortedAscending(result));
		System.out.println(Arrays.toString(result));
		System.out.println("Sum of initial array lengths is equal to resulting array length: " + ((a.length+b.length)==result.length));
		
		System.out.println("Test 3 Null + array");
		a = null;
		b = new int[] { 5, 13, 17, 20, 68, 80, 120, 201, 299 };
		result = mergeTwoSequences(a, b);
		System.out.println("Is array sorted ascending: "+checkSortedAscending(result));
		System.out.println(Arrays.toString(result));
		
		System.out.println("Test 4 Two unsorted arrays");
		a = new int[] { 100, 200, 300, 1, 12, 24, 36, 65, 80 };
		b = new int[] { 5, 13, 17, 20, 68, 80, 120, 201, 299 };
		result = mergeTwoSequences(a, b);
		System.out.println("Is array sorted ascending: "+checkSortedAscending(result));
		System.out.println(Arrays.toString(result));
	}

	

}
