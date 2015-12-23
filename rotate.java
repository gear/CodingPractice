/*  
    Programming Creek Interview practice
    String - Question 1: Rotate a string
    Java
*/

import java.util.Arrays;

public class rotate {
    // Container for 3 methods of rotating
    // an array of integer.

    public void rotate_naive(int[] nums, int k) {
        // O(n) time, O(n) space
        // Input: array of integers (nums)
        //        rotation step (k) - neg = left rotation 
        
        if (k > nums.length) {
            k = k % nums.length;
        }
        
        if (k < 0) {
            k = nums.length - ((-k) % nums.length);
        }

        int[] result = new int[nums.length];

        for(int i = 0; i < k; ++i) {
            result[i] = nums[i + nums.length - k]; 
        }	

        for(int i = k; i < nums.length; ++i) {
            result[i] = nums[i - k];
        }

        System.arraycopy(result, 0, nums, 0, nums.length);
	}
    
    public void rotate_bubble(int[] nums, int k) {
        // O(n*k) time, O(1) space
        // Input: array of integers (nums)
        //        rotation step (k) - neg = left rotation

        if (k > nums.length) {
            k = k % nums.length;
        }
        
        if (k < 0) {
            k = nums.length - ((-k) % nums.length);
        }

        for(int i = 0; i < k; ++i) {
            for(int j = 0; j < nums.length; ++j) {
                int temp = nums[nums.length-1];
                nums[nums.length-1] = nums[j];
                nums[j] = temp; 
            }
        }
    }

    public void rotate_reverse(int[] nums, int k) {
		// Divide the array into 2 parts: k and n-k
		// Reverse each array and then reverse the whole array
		// reverse(a.b) = reverse(b).reverse(a)
		// reverse(reverse(a).reverse(b)) = b.a.
		// O(1) space, O(n) time

        if (k > nums.length) {
            k = k % nums.length;
        }
        
        if (k < 0) {
            k = nums.length - ((-k) % nums.length);
        }
		
		int m = nums.length - k;

		// Reverse the first part of array
		int j = m - 1;
		for (int i = 0; i < j; ++i) {
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
			--j;
		}

		// Reverse the second part
		j = nums.length - 1;
		for (int i = m; i < j; ++i) {
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;	
			--j;
		}

		// Reverse the whole array
		j = nums.length - 1;
		for (int i = 0; i < j; ++i) {
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
			--j;
		}
	}

    public static void main(String[] args) {
        // Test for rotating string
        int[] test1 = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        int[] test2 = new int[]{};
        int[] test3 = new int[]{1,1,1,1,1,1,1,2,1,1,1,1,1,1};
        int[] test4 = new int[]{3,4,2,5,7,2,1,4,3,6,8,4,3,12,7};
        int k1 = 1;
        int k2 = 5;
        int k3 = 77;
        int k4 = 19999;
        int k5 = 0;
        int k6 = -1;

        rotate test_obj = new rotate();
        test_obj.rotate_reverse(test1, -1);
        System.out.println(Arrays.toString(test1));
    }
}
