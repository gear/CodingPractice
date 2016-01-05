/* Find the median of 2 sorted int array of length m and n.
 * Time should be O(m+n)
 */

import java.util.Arrays;

public class median_sorted {
	
	float median(int[] a) {
		if (a.length % 2 != 0) {
			return a[a.length/2];
		} else {
			return (a[a.length/2-1] + a[a.length/2]) / (float)2.0;
		}
	}

	// This approach can be improved by counting while merging
	// Space is improved to O(1), time is still O(n), but Theta(n/2)	
	public float median_naive(int[] a, int[] b) {
		
		if (a == null || b == null)
			throw new NullPointerException();
		if (a.length == 0 && b.length > 0)
			return median(b);	
		if (a.length > 0 && b.length == 0)
			return median(a);
		if (a.length == 0 && b.length == 0)
			return 0;
			
		float med_a = median(a);
		float med_b = median(b);
		
		if (med_a == med_b) 
			return med_a;
		
		int[] c = new int[a.length + b.length];
		int j = 0;
		int i = 0;
		int k = 0;
		while (i < a.length && j < b.length) {
			if (a[i] < b[j]) {
				c[k] = a[i];
				++i;
			} else {
				c[k] = b[j];
				++j;
			}
			++k;
		}
		if (i != a.length-1)
			for(;i < a.length; ++i)
				c[k++] = a[i];
		if (j != b.length-1)
			for(;j < b.length; ++j)
				c[k++] = b[j];
		return median(c);
	}

	public float median(int [] a, int[] b) {
		if (a == null || b == null)
			throw new NullPointerException();
		if (a.length == 0 && b.length > 0)
			return median(b);	
		if (a.length > 0 && b.length == 0)
			return median(a);
		if (a.length == 0 && b.length == 0)
			return 0;
			
		float med_a = median(a);
		float med_b = median(b);
		
		if (med_a == med_b) 
			return med_a;

		
	}

	public static void main(String[] args) {
		median_sorted test = new median_sorted();
		int[] a = new int[] {1, 2, 3, 3, 4, 5};
		int[] b = new int[] {3, 4, 4, 5, 6, 7, 7, 8, 9};
		System.out.println(test.median_naive(a, b));
	}
}
