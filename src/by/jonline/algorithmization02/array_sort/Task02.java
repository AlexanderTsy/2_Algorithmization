package by.jonline.algorithmization02.array_sort;

import java.util.Arrays;
import java.util.Objects;

/**
 * 2 Algorithmization Одномерные массивы. Сортировки. Задание 2<br/>
 * Даны две последовательности a<sub>1</sub> &leq; a<sub>2</sub> &leq; ... &leq; a<sub>n</sub>
 * и b<sub>1</sub> &leq; b<sub>2</sub> &leq; ... &leq; b<sub>m</sub>.
 * Образовать из них новую последовательность чисел так, чтобы она тоже была неубывающей.
 * <i>Примечение.</i> Дополнительный массив не использовать.
 * 
 * @author tsyhanok.aa
 *
 */
public class Task02 {
	
	public static int[] joinArrays(int[] a, int[] b) {
		int[] result;
		int aCount;
		int bCount;
	
		
		if( Objects.isNull(a) && Objects.isNull(b)) {
			return null;
		}
		
		if( Objects.isNull(a) && !Objects.isNull(b)) {
			return b.clone();
		}
		
		if( !Objects.isNull(a) && Objects.isNull(b)) {
			return a.clone();
		}
		
		try {
			Math.addExact(a.length,b.length);
		} catch (ArithmeticException e) {
			System.err.println("Sum of arrays lengths exceeds maximal index number.");
			return null;
		}
		
		
		
		result = new int[a.length+b.length];
		// Since a and b are non-decreasing sequences
		// if sequence a less than b
		if ( a[a.length-1] <= b[0]) {
			for (int i = 0; i < a.length; i++) {
				result[i] = a[i];
			}
			for (int i = 0; i < b.length; i ++) {
				result[a.length+i] = b[i];
			}
			return result;
		}
		// if sequence b less than a
		if ( b[b.length-1] <= a[0]) {
			for (int i = 0; i < b.length; i++) {
				result[i] = b[i];
			}
			for (int i = 0; i < a.length; i ++) {
				result[b.length+i] = a[i];
			}
			return result;
		}
		
		aCount = 0;
		bCount = 0;
		
		
		// TODO malfunction at the end of arrays - fix.
		for (int i = 0; i < result.length; i++) {
			if(aCount >= a.length) {
				result[i] = b[bCount];
				bCount++;
				continue;
			}
			if(bCount >= b.length) {
				result[i] = a[aCount];
				aCount++;
				continue;
			}
			if(a[aCount] < b[bCount]) {
				result[i] = a[aCount];
				aCount++;
				continue;
			} else {
				result[i] = b[bCount];
				bCount++;
				continue;
			}

		}
		
		return result;
		
	}

	public static void main(String[] args) {
		int[] array1;
		int[] array2;
		int[] result;
		
		System.out.println("Test 1. First array longer");
		array1 = new int[] {1, 20, 21, 23, 30, 40, 50};
		array2 = new int[] {11, 22, 33, 44};
		result = joinArrays(array1, array2);
		System.out.println(Arrays.toString(result));
		
		System.out.println("Test 2. First array shorter");
		array1 = new int[] {11, 22, 33, 44};
		array2 = new int[] {1, 20, 21, 23, 30, 40, 50};
		result = joinArrays(array1, array2);
		System.out.println(Arrays.toString(result));
		
		System.out.println("Test 3. Second array is null");
		array1 = new int[] {11, 22, 33, 44};
		array2 = null;
		result = joinArrays(array1, array2);
		System.out.println(Arrays.toString(result));
		
		System.out.println("Test 4. First array is null");
		array1 = null;
		array2 = new int[] {11, 22, 33, 44};
		result = joinArrays(array1, array2);
		System.out.println(Arrays.toString(result));
		
		System.out.println("Test 5. Two arrays are null");
		array1 = null;
		array2 = null;
		result = joinArrays(array1, array2);
		System.out.println(Arrays.toString(result));

	}

}
