/**
 * Given a non-negative number represented as an array of digits,

add 1 to the number ( increment the number represented by the digits ).

The digits are stored such that the most significant digit is at the head of the list.

Example:

If the vector has [1, 2, 3]

the returned vector should be [1, 2, 4]

as 123 + 1 = 124.

 NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer.
For example, for this problem, following are some good questions to ask :
Q : Can the input have 0’s before the most significant digit. Or in other words, is 0 1 2 3 a valid input?
A : For the purpose of this question, YES
Q : Can the output have 0’s before the most significant digit? Or in other words, is 0 1 2 4 a valid output?
A : For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.
 */
package io.github.controlx.array;

public class AddOneToNumber {
    public int[] plusOne(int[] A) {
        int lengthOfArray = A.length;
        
        if(A[lengthOfArray-1] != 9){
            A[lengthOfArray-1] = A[lengthOfArray-1]+1;
            return truncateLeadingZeros(A);
        }
        else{
        	return truncateLeadingZeros(getModifiedArray(A, lengthOfArray-1));
        }
    }
    
    private int[] getModifiedArray(int[] arr, int i){
        if(i==0 && (arr[i] == 9)){
            int[] newArray = new int[arr.length + 1];
            arr[i] = 0;
            newArray[0] = 1;
            for(int j=1; j < newArray.length - 1; j++){
                newArray[j] = arr[j-1];
            }
            return newArray;
        }
        else if(arr[i] == 9){
            arr[i] = 0;
            return getModifiedArray(arr, (i-1));
        }
        else{
            arr[i] = arr[i] + 1;
            return arr;
        }
    }
    
    private int[] truncateLeadingZeros(int[] arr){
        int count = 0;
        for(int i=0; i<arr.length-1; i++){
            if(arr[i] == 0){
                count = count + 1;
            }
            else{
                break;
            }
        }
        
        int[] newArray = new int[arr.length - count];
        
        for(int j=0; j<newArray.length; j++){
            newArray[j] = arr[j+count];
        }
        
        return newArray;
    }
    
    public int[] plusOneWithoutRecurssion(int[] A) {
        int lengthOfArray = A.length;
        
        if(A[lengthOfArray-1] != 9){
            A[lengthOfArray-1] = A[lengthOfArray-1]+1;
            return truncateLeadingZeros(A);
        }
        else{
            int[] arr = A;
            for(int i=arr.length-1; i>=0; i--){
                if(i==0 && (arr[i] == 9)){
                    int[] newArray = new int[arr.length + 1];
                    arr[i] = 0;
                    newArray[0] = 1;
                    for(int j=1; j < newArray.length - 1; j++){
                        newArray[j] = arr[j-1];
                    }
                    arr = newArray;
                    break;
                }
                else if(arr[i] == 9){
                    arr[i] = 0;
                    continue;
                }
                else{
                    arr[i] = arr[i] + 1;
                    break;
                }
            }
            return truncateLeadingZeros(arr);
        }
    }
}

