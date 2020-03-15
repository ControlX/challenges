/**
 * Given a read only array of n + 1 integers between 1 and n, find one number that repeats in linear time using less than O(n) space and traversing the stream sequentially O(1) times.

Sample Input:

[3 4 1 4 1]
Sample Output:

1
If there are multiple possible answers ( like in the sample case above ), output any one.

If there is no duplicate, output -1
 */
package io.controlx.array;

import java.util.HashMap;

public class FindDuplicateInArray {
	 public int repeatedNumber(final int[] A) {
		 	int repeatedNumber = -9999;
	        HashMap<Integer, Integer> map = new HashMap<>();
	        for(int i=0; i<A.length; i++) {
	        	Integer retVal = map.put(A[i], 1);
	        	if(retVal == null) {
	        		continue;
	        	}else if(retVal == 1) {
	        		repeatedNumber = A[i];
	        		break;
	        	}
	        }
	        if(repeatedNumber == -9999)
	        	return -1;
	        else
	        	return repeatedNumber;
	 }
}
