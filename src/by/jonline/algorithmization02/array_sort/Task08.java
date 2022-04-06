package by.jonline.algorithmization02.array_sort;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

/**
 * 2 Algorithmization Одномерные массивы. Сортировки. Задание 8<br/>
 * Даны дроби <sup>p1</sup> &#8260; <sub>q1</sub>, <sup>p2</sup> &#8260;
 * <sub>q2</sub>, ..., <sup>pn</sup> &#8260; <sub>qn</sub> (<i>p<sub>i</sub>,
 * q<sub>i</sub></i> - натуральные). Составить программу, которая приводит эти
 * дроби к общему знаменателю и упорядочивает их в порядке возрастания.
 * 
 * @author tsyhanok.aa
 *
 */
public class Task08 {

	//  Task requires using single dimension arrays
	/**
	 * Method finds and sets lowest common denominator to set of fractions stored as two arrays.
	 * Set of fractions is sorted ascending.
	 * @param p array of numerators
	 * @param q array of denominators
	 */
	public static long[][] bringToLowestCommonDenominatorAndOrderAscending (int[] p, int[]q) {
		int [] fraction;
		long [] numerators;
		long lowestCommonDenominator;
		//p array of numerators
		//q array of denominators
		if( Objects.isNull(p) || Objects.isNull(q) || p.length == 0 || q.length == 0 || p.length != q.length ) {
			System.err.println("Arrays are either null, or not equal length. Check input arrays.");
			return null;
		}
		
		//Find Lowest Common Denominator
		
		for (int i = 0; i < q.length; i++) {
			fraction = simplifyFraction(p[i], q[i]);
			p[i] = fraction[0];
			q[i] = fraction[1];
		}
		
		numerators = new long[p.length];
		lowestCommonDenominator = lowestCommonDenominator(q);
		for (int i = 0; i < q.length; i++) {
			numerators[i] = p[i] == 0 ? 0 : lowestCommonDenominator / p[i];
		}
		
		//Sort sequence of fractions
		int i = 0;
		
		while (i < p.length) {
			//insertion sort of fractions
			
			i++;
		}
		
		long[][] result = {numerators, {lowestCommonDenominator}};
		return result;

	}
	
	private static int[] simplifyFraction(int p, int q) {
		int[] result = new int[2];
		
		int i = 2;
		while (i < p/2) {
			while (p%i == 0 && q%i == 0) {
				p = p/i;
				q = q/i;
			}
			i++;
		}
		result[0] = p;
		result[1] = q;
		return result;
	}
	
	private static long lowestCommonDenominator(int[] q) {
		int i = 1;
		for (int j = 0; j < q.length; j++) {
			if (i%q[j] != 0) {
				i *= q[j];
			}
		}
		return i;
	}
	
	/**
	 * Generates array of random integers of size n within range &plusmn;n
	 * @param n
	 * @param maxNumber TODO
	 * @return array of random integers
	 */
	private static int[] getRandomIntArrayOfSize(int n, int maxNumber) {
		int[] a = new int[n];
		Random rnd = new Random();
		for (int i = 0; i < a.length; i++) {
			a[i] = rnd.nextInt(maxNumber)+1; 
		}
		return a;
	}
	
	private static boolean checkSortedAscending (int[] p, int[] q) {
		if( Objects.isNull(p) || Objects.isNull(q) || p.length == 0 || q.length == 0 || p.length != q.length ) {
			System.err.println("Arrays are either null, or not equal length. Check input arrays.");
			return false;
		}
		
		for (int i = 0; i < p.length-1; i++) {
			if ((double) p[i+1]/q[i+1]<(double) p[i]/q[i]) {
				return false;
			}
		}
		return true;
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
		// Tests.
		int[] p; //numerators
		int[] q; //denominators
		long[][] result;
		int n = 10;
		
		System.out.println("Test 1 Two big random arrays");
		p = getRandomIntArrayOfSize(n, 20);
		q = getRandomIntArrayOfSize(n, 10);
		
		for (int i = 0; i < p.length; i++) {
			System.out.println(p[i]+"/"+q[i] + "=" + Arrays.toString(simplifyFraction(p[i], q[i])));
		}
		
		result = bringToLowestCommonDenominatorAndOrderAscending(p, q);
		for (int i = 0; i < result[0].length; i++) {
			System.out.println(result[0][i]+"/"+result[1][0]);
		}
	}

}
