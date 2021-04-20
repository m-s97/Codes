package dynamicProgramming;

import java.util.HashMap;

/*
 * Given a 2D matrix, find the largest rectangular sub-matrix whose sum is 0. 
 */
// Similar approach as Maximum Sum Rectangle problem
public class LargestSubMatrixSum0 {
    int subRectangle(int r, int c, int m[][]) {
        int maxRec = Integer.MIN_VALUE;
        int i = 0,j = 0;
        
        while(i < r){
        	int arr[] = new int[c];
            while(j < r){
                for(int k=0;k<c;k++){
                	arr[k] += m[j][k];
                }
                // length*breadth
                maxRec = Math.max(maxRec, sumZero(arr,c)*(j-i+1));
                j++;
            }
            i++;
            j = i;
        }
        return maxRec;
    }
    // for calculating the length of matrix with sum 0
    int sumZero(int[] arr,int c) {
        HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();
        
        int sum = 0; // Initialize sum of elements
        int max_len = 0; // Initialize result
 
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (arr[i] == 0 && max_len == 0)
                max_len = 1;
 
            if (sum == 0)
                max_len = i + 1;
 
            // If this sum is seen before, then update max_len
            if (hM.containsKey(sum))
                max_len = Math.max(max_len, i - hM.get(sum));
            else
                hM.put(sum, i);
        }
        return max_len;
    }
}
