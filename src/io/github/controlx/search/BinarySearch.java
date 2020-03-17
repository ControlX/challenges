package io.github.controlx.search;

import java.util.Arrays;

public class BinarySearch {

	public int search(int[] arr, int numberToSearch) {
		if(arr.length == 0)
			return -1;
//		return loopProbing(arr, numberToSearch);
		return recursiveProbing(arr, numberToSearch, 0, arr.length);
	}
	
	private int loopProbing(int[] arr, int numberToSearch) {
		int length = arr.length;
		int start = 0;
		int end = length;
		
		if(length == 0)
			return -1;
		
		while(start <= end) {
			int mid = (start + end)/2;
			
			if(arr[mid] == numberToSearch)
				return mid;
			
			else if(numberToSearch < arr[mid]) {
				end = mid - 1;
			}
			
			else {
				start = mid + 1;
			}
		}
		
		return -1;
	}
	
	private int recursiveProbing(int[] arr, int numberToSearch, int start, int end) {
		int mid = (start+end)/2;
		
		if(end >= start) {
			if(numberToSearch == arr[mid])
				return mid;
			else if(numberToSearch < arr[mid]) {
				return recursiveProbing(arr, numberToSearch, start, mid-1);
			}
			else{
				return recursiveProbing(arr, numberToSearch, mid+1, end);
			}
		}
		
		return -1;
	}
}
