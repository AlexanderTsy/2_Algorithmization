package by.jonline.algorithmization02.array_sort;

import java.math.BigInteger;
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
	public static BigInteger[][] bringToLowestCommonDenominatorAndOrderAscending (int[] p, int[]q) {
		int [] fraction;
		BigInteger [] numerators;
		BigInteger lowestCommonDenominator;
		
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
		
		//insertion sort of fractions
		for (int i = 1; i < p.length; i++) {
			int key = p[i];
			int j = i-1;
		
			while (j >= 0 && p[j] < key) {	
				p[j+1] = p[j];
				j = j - 1;
			}
			p[j + 1] = key;
		}
		
		//calculate numerators for lowest common denominator
		numerators = new BigInteger[p.length];
		lowestCommonDenominator = lowestCommonDenominator(q);
		for (int i = 0; i < q.length; i++) {
			numerators[i] = p[i] == 0 ? BigInteger.ZERO : lowestCommonDenominator.divide(BigInteger.valueOf(p[i]));
		}
		
		BigInteger[][] result = {numerators, {lowestCommonDenominator}};
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
	
	private static BigInteger lowestCommonDenominator(int[] q) {
		BigInteger lowestCD = BigInteger.ONE;
		for (int j = 0; j < q.length; j++) {
			if (lowestCD.remainder(BigInteger.valueOf(q[j])).compareTo(BigInteger.valueOf(0)) != 0) {
				lowestCD = lowestCD.multiply(BigInteger.valueOf(q[j]));
			}
		}
		return lowestCD;
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
	
	public static void main(String[] args) {
		// Tests.
		int[] p; //numerators
		int[] q; //denominators
		BigInteger[][] result;
		int n = 100;
		
		System.out.println("Test 1 Two big random arrays");
		p = getRandomIntArrayOfSize(n, 2000);
		q = getRandomIntArrayOfSize(n, 700);
		
		for (int i = 0; i < p.length; i++) {
			System.out.println(p[i]+"/"+q[i] + "=" + Arrays.toString(simplifyFraction(p[i], q[i])));
		}
		
		result = bringToLowestCommonDenominatorAndOrderAscending(p, q);
		for (int i = 0; i < result[0].length; i++) {
			System.out.println(result[0][i]+"/"+result[1][0]);
		}
	}

}
