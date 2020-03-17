/**
 * Find the contiguous subarray within an array, A of length N which has the largest sum.

Input Format:

The first and the only argument contains an integer array, A.
Output Format:

Return an integer representing the maximum possible sum of the contiguous subarray.
Constraints:

1 <= N <= 1e6
-1000 <= A[i] <= 1000
For example:

Input 1:
    A = [1, 2, 3, 4, -10]

Output 1:
    10

Explanation 1:
    The subarray [1, 2, 3, 4] has the maximum possible sum of 10.

Input 2:
    A = [-2, 1, -3, 4, -1, 2, 1, -5, 4]

Output 2:
    6

Explanation 2:
    The subarray [4,-1,2,1] has the maximum possible sum of 6.
 */
package io.github.controlx.array;

import java.util.Arrays;

public class MaxSumContagiousSubArray {
	public int maxSubArrayDivideAndConquer(final int[] A) {
		return maxSubArraySum(A);
    }
	
	//=========================my code=======================
	/**
	 * 
	 * recursion breaks on 1
	 * break array into two and get max sum for each
	 * return left max sum + right max sum
	 * @param arr
	 * @param n
	 * @return
	 */
	private int maxSubArraySum(int[] arr) {
		int n = arr.length;
		
		if(n == 1) {
			return arr[0];
		}
		
		int middle = (n)/2;
		int[] leftArray = Arrays.copyOfRange(arr, 0, middle);
		int[] rightArray = Arrays.copyOfRange(arr, middle, n);
		
		int leftMSS = maxSubArraySum(leftArray);
		int rightMSS = maxSubArraySum(rightArray);
		
		int leftSum = Integer.MIN_VALUE;
		int rightSum = Integer.MIN_VALUE;
		
		int sum = 0;
		/**
		 * Explanation for why it should be traversed back:
		 * 
		 * --CSPlayerDamon--
		 * Because you're iterating the left part of the array. 
		 * What you're trying to find there is if there is a sum in the 
		 * middle greater than the sums on left/right part alone. 
		 * Hence, you're going through the middle and up for the right 
		 * array and for the middle and down through the left. 
		 * If you go from the start and up from the left, 
		 * which is what you're saying, 
		 * it's not going to give you the correct answer for obvious reasons.
		 * 
		 * More details for left to right traversal:
		 * 
		 * You want the MSA, meaning the elements are continuous. 
		 * Since it is an array, you'll go from 0 to arrayCount, 
		 * which you can think as left to right. Draw your full array. 
		 * Going from left to right find the MSA. Now break the array 
		 * into two arrays, a leftArray and a rightArray. If you try 
		 * to find the MSS of the leftArray from left to right and the 
		 * MSS of the rightArray from left to right, you'll lose any 
		 * overlapping points. That means, once you connect the two MSA, 
		 * you won't get the true MSA of the big array. 
		 * 
		 */
		for(int i=leftArray.length-1; i>=0; i--) {
			sum = sum + leftArray[i];
			leftSum = max(leftSum, sum);
		}
		
		sum = 0;
		for(int i=0; i<rightArray.length; i++) {
			sum = sum + rightArray[i];
			rightSum = max(rightSum, sum);
		}
		
		int ans = max(leftMSS, rightMSS);
		return max(ans, (leftSum + rightSum));
	}
	
	private int max(int a, int b) {
		if(a >= b)
			return a;
		else
			return b;
	}
	
	public int maxSubArrayBruteForce(final int[] A) {
		int lengthOfArray = A.length;
		int maxSum = -9999;
		
		for(int startIndex=0; startIndex<lengthOfArray; startIndex++) {
			int subArraySum = 0;
			for(int subArray=0; startIndex+subArray<lengthOfArray; subArray++) {
				subArraySum = subArraySum + A[startIndex+subArray]; 
				if(subArraySum > maxSum) {
					maxSum = subArraySum;
				}
			}
		}
		return maxSum;
    }
	
	
	// ==========================[Not used] Copied from online================================================
	/**
	 * main:
	 * 
	 * int n = A.length;
	 * int max_sum = maxSubArraySum(A, 0, n-1); 
	 * @param arr
	 * @param l
	 * @param m
	 * @param h
	 * @return
	 */
	// Find the maximum possible sum in arr[]  
    // such that arr[m] is part of it 
    static int maxCrossingSum(int arr[], int l, 
                                int m, int h) 
    { 
        // Include elements on left of mid. 
        int sum = 0; 
        int left_sum = Integer.MIN_VALUE; 
        for (int i = m; i >= l; i--) 
        { 
            sum = sum + arr[i]; 
            if (sum > left_sum) 
            left_sum = sum; 
        } 
  
        // Include elements on right of mid 
        sum = 0; 
        int right_sum = Integer.MIN_VALUE; 
        for (int i = m + 1; i <= h; i++) 
        { 
            sum = sum + arr[i]; 
            if (sum > right_sum) 
            right_sum = sum; 
        } 
  
        // Return sum of elements on left 
        // and right of mid 
        return left_sum + right_sum; 
    } 
  
    // Returns sum of maxium sum subarray  
    // in aa[l..h] 
    static int maxSubArraySum(int arr[], int l,  
                                      int h) 
    { 
    // Base Case: Only one element 
    if (l == h) 
        return arr[l]; 
  
    // Find middle point 
    int m = (l + h)/2; 
  
    /* Return maximum of following three  
    possible cases: 
    a) Maximum subarray sum in left half 
    b) Maximum subarray sum in right half 
    c) Maximum subarray sum such that the  
    subarray crosses the midpoint */
    return Math.max(Math.max(maxSubArraySum(arr, l, m), 
                    maxSubArraySum(arr, m+1, h)), 
                    maxCrossingSum(arr, l, m, h)); 
    }
}
