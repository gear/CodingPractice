/* Find the median of 2 sorted int array of length m and n.
 * Time should be O(m+n)
 * This problem is updated to find k-th element.
 */

import java.util.Arrays;

public class median_sorted {
	public static void main(String[] args) {
		median_sorted test = new median_sorted();
		int[] a = new int[] {1, 2, 3, 3, 4};
		int[] b = new int[] {3, 4, 4, 5, 6, 7, 7, 8, 9};
		System.out.println(test.findMedianSortedArrays(a, b));
	}
}
