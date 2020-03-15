/**
 * Given an array of integers, A of length N, find out the maximum sum sub-array of non negative numbers from A.

The sub-array should be contiguous i.e., a sub-array created by choosing the second and fourth element and skipping the third element is invalid.

Maximum sub-array is defined in terms of the sum of the elements in the sub-array.

Find and return the required subarray.

NOTE:

    1. If there is a tie, then compare with segment's length and return segment which has maximum length.
    2. If there is still a tie, then return the segment with minimum starting index.


Input Format:

The first and the only argument of input contains an integer array A, of length N.
Output Format:

Return an array of integers, that is a subarray of A that satisfies the given conditions.
Constraints:

1 <= N <= 1e5
1 <= A[i] <= 1e5
Examples:

Input 1:
    A = [1, 2, 5, -7, 2, 3]

Output 1:
    [1, 2, 5]

Explanation 1:
    The two sub-arrays are [1, 2, 5] [2, 3].
    The answer is [1, 2, 5] as its sum is larger than [2, 3].

Input 2:
    A = [10, -1, 2, 3, -4, 100]
    
Output 2:
    [100]

Explanation 2:
    The three sub-arrays are [10], [2, 3], [100].
    The answer is [100] as its sum is larger than the other two.
 */
package io.controlx.array;

import java.util.Arrays;
import java.util.Stack;

public class MaxNonNegativeSubArray {
	public int[] maxset(int[] A) {
		int[] arr = A;
		long sum = 0;
		long highSum = 0;
		int subArrayCount = 0;
		Stack<Integer[]> stack = new Stack();
		stack.push(new Integer[0]);
		for(int i=0; i<arr.length; i++) {
			if(i==arr.length-1 && arr[i]>=0) {
				subArrayCount = subArrayCount + 1;
			}
			if((i==arr.length-1 || arr[i] < 0) && subArrayCount != 0) {
				if(i==arr.length-1 && arr[i]>=0) {
					i=i+1;
				}
				Integer[] stackArray = new Integer[subArrayCount];
				for(int j=subArrayCount; j>0; j--) {
					sum = sum + arr[i-j];
					stackArray[subArrayCount - j] = arr[i-j];
				}
				
				//Stack operations
				if(highSum < sum) {
					highSum = sum;
					if(!stack.isEmpty())
						stack.pop();
					stack.push(stackArray);
				}
				else if(highSum == sum) {
					if(stack.peek().length > subArrayCount){
						// Nothing to do
					}
					else if(stack.peek().length < subArrayCount){
						stack.pop();
						stack.push(stackArray);
					}
					else if(stack.peek().length == subArrayCount) {
						if(stack.peek()[0] > stackArray[0]) {
							stack.pop();
							stack.push(stackArray);
						}
					}
					else {
						stack.pop();
						stack.push(stackArray);
					}
				}
				
				//Reset counters
				subArrayCount = 0;
				sum = 0;
				continue;
			}
			else if(arr[i] >= 0) {
				subArrayCount = subArrayCount + 1;
			}
		}
		
		Integer[] array = stack.peek();
		int[] intArray = Arrays.stream(array).mapToInt(Integer::intValue).toArray();
		return intArray;
    }
}
