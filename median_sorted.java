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

	/*
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
	*/

	/* Leetcode solution */
	public double findMedianSortedArrays(int A[], int B[]) {
		int m = A.length;
		int n = B.length;

		if ((m+n) % 2 != 0)
			return (double) findKth(A, B, (m+n) / 2, 0, m - 1, 0, n - 1);
		else {
			return (findKth(A, B, (m + n) / 2, 0 , m - 1, 0, n - 1) +
					findKth(A, B, (m + n) / 2 - 1, 0, m - 1, 0, n - 1)) * 0.5;
		}
	}

	public static int findKth(int A[], int B[], int k, int aStart, int aEnd, int bStart, int bEnd) {

		int aLen = aEnd - aStart + 1;
		int bLen = bEnd - bStart + 1;
	 
		// Handle special cases
		if (aLen == 0)
			return B[bStart + k];
		if (bLen == 0)
			return A[aStart + k];
		if (k == 0)
			return A[aStart] < B[bStart] ? A[aStart] : B[bStart];
	 
		int aMid = aLen * k / (aLen + bLen); // a's middle count
		int bMid = k - aMid - 1; // b's middle count
	 
		// make aMid and bMid to be array index
		aMid = aMid + aStart;
		bMid = bMid + bStart;
	 
		if (A[aMid] > B[bMid]) {
			k = k - (bMid - bStart + 1);
			aEnd = aMid;
			bStart = bMid + 1;
		} else {
			k = k - (aMid - aStart + 1);
			bEnd = bMid;
			aStart = aMid + 1;
		}
	 
		return findKth(A, B, k, aStart, aEnd, bStart, bEnd);
	}
	/* End Leetcode solution */

	public static void main(String[] args) {
		median_sorted test = new median_sorted();
		int[] a = new int[] {1, 2, 3, 3, 4};
		int[] b = new int[] {3, 4, 4, 5, 6, 7, 7, 8, 9};
		System.out.println(test.findMedianSortedArrays(a, b));
	}
}
