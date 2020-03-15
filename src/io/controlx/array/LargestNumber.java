/**
 * Given a list of non negative integers, arrange them such that they form the largest number.

For example:

Given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.
 */
package io.controlx.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LargestNumber {
	public String largestNumber(final int[] A) {
		ArrayList<String> list = new ArrayList<>();
		for(int i=0; i<A.length; i++) {
			long num = A[i];
//			int length = String.valueOf(num).length();
//			ArrayList<Long> subList = new ArrayList();
//			for(int j=length-1; j>=0; j--) {
//				long exp = calculatePow(10, j);
//				subList.add(num/exp);
//				num = num%exp;
//			}
////			Collections.sort(subList);
////			Collections.reverse(subList);
//			StringBuilder sb = new StringBuilder();
//			for (Long s : subList)
//			{
//			    sb.append(s+"");
//			}
			list.add(num+"");
		}
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				String XY = o1+o2;
				String YX = o2+o1;
				return XY.compareTo(YX) > 0 ? -1:1; 
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for (String s : list)
		{
		    sb.append(s);
		}
		return removeZero(sb.toString());
    }
    
    private String removeZero(String str) 
    { 
        // Count leading zeros 
        int i = 0; 
        while (i < str.length() && str.charAt(i) == '0') 
            i++; 
  
        // Convert str into StringBuffer as Strings 
        // are immutable. 
        StringBuffer sb = new StringBuffer(str); 
  
        // The  StringBuffer replace function removes 
        // i characters from given index (0 here) 
        sb.replace(0, i, ""); 
  
        if(sb.toString().isEmpty()) {
        	sb.append("0");
        }
        return sb.toString();  // return in String 
    } 
	
	public String largestNumberIndividual(final int[] A) {
		ArrayList<Long> list = new ArrayList<>();
		for(int i=0; i<A.length; i++) {
			long num = A[i];
			int length = String.valueOf(num).length();
			for(int j=length-1; j>=0; j--) {
				long exp = calculatePow(10, j);
				list.add(num/exp);
				num = num%exp;
			}
		}
		Collections.sort(list);
		Collections.reverse(list);
		StringBuilder sb = new StringBuilder();
		for (long s : list)
		{
		    sb.append(s+"");
		}
		return sb.toString();
    }
	
	private long calculatePow(int base, int exponent) {
		long result = 1;

        for (;exponent != 0; --exponent)
        {
            result *= base;
        }
        
        return result;
	}
}
