package io.github.controlx.search;

public class Init {

	public static void main(String[] args) {
		int arr[] = {-1, 2, 3, 4, 7, 9, 11};
//		int arr[] = {};
		BinarySearch binarySearch = new BinarySearch();
		System.out.println(binarySearch.search(arr, -1));
	}

}
