package by.jonline.algorithmization02.array_sort;

import java.util.Objects;

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
	public static void bringToLowestCommonDenominatorAndOrderAscending (int[] p, int[]q) {
		//p array of numerators
		//q array of denominators
		if( Objects.isNull(p) || Objects.isNull(q) || p.length == 0 || q.length == 0 || p.length != q.length ) {
			System.err.println("Arrays are either null, or not equal length. Check input arrays.");
			return;
		}
		
		int i = 0;
		
		while (i < p.length) {
			//insertion sort of fractions
			
		}

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
