package by.jonline.algorithmization02.array_sort;

import java.util.Arrays;
import java.util.Objects;

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
	 * Finds places to insert elements of b into a so that
	 * sequence remains ascending
	 * @param a
	 * @param b
	 * @return numbers of places to insert
	 */
	public static int[] placesToInsertElements(int[] a, int[] b) {
		int[] result;
		int aNum;
		int bNum;
		
		if(Objects.isNull(a)) {
			System.err.println("Array a is null");
			return null;
		}
		if(Objects.isNull(b)) {
			System.err.println("Array b is null");
			return null;
		}
		if(!checkSortedAscending(a)) {
			System.err.println("Array a is not ascending");
			return null;
		}
		if(!checkSortedAscending(b)) {
			System.err.println("Array b is not ascending");
			return null;
		}
		
		//
		result = new int[b.length];
		aNum = 0;
		bNum = 0;
		
		while (aNum < a.length) {
			while (bNum < b.length && b[bNum] < a[aNum]) {
				result[bNum] = aNum;
				bNum++;
			}
			aNum++;
		}
		
		return result;
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
		
		System.out.println("Test 1 Two arrays");
		a = new int[] { 1, 12, 24, 36, 65, 80, 100, 200, 300 };
		b = new int[] { 5, 13, 17, 20, 68, 80, 120, 201, 299 };
		System.out.println(Arrays.toString(placesToInsertElements(a, b)));
		
		System.out.println("Test 2 Null + array");
		a = null;
		b = new int[] { 5, 13, 17, 20, 68, 80, 120, 201, 299 };
		System.out.println(Arrays.toString(placesToInsertElements(a, b)));
		
		System.out.println("Test 3 Two unsorted arrays");
		a = new int[] { 100, 200, 300, 1, 12, 24, 36, 65, 80 };
		b = new int[] { 5, 13, 17, 20, 68, 80, 120, 201, 299 };
		System.out.println(Arrays.toString(placesToInsertElements(a, b)));
		
		System.out.println("Test 4 Zero length array a");
		a = new int[] {  };
		b = new int[] { 5, 13, 17, 20, 68, 80, 120, 201, 299 };
		System.out.println(Arrays.toString(placesToInsertElements(a, b)));
		
		System.out.println("Test 5 Zero length array b");
		a = new int[] { 1, 12, 24, 36, 65, 80, 100, 200, 300 };
		b = new int[] {  };
		System.out.println(Arrays.toString(placesToInsertElements(a, b)));
		
	}

	

}
