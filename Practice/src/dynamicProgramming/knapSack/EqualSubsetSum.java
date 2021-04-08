package dynamicProgramming.knapSack;
/*
 * https://practice.geeksforgeeks.org/problems/subset-sum-problem2014/1
 * 
 * Given an array arr[] of size N, check if it can be partitioned into 
 * two parts such that the sum of elements in both parts is the same.
 */
public class EqualSubsetSum {
	// DP solution - O(n*summation(arr)/2))
    static int equalPartition(int n, int arr[])
    {
        int sum = 0;
        for(int i=0;i<arr.length;i++) sum += arr[i];
        if(sum%2 != 0) return 0;
        boolean[][] mat = new boolean[n+1][sum/2+1];
        
        for(int i=0;i<=n;i++) mat[i][0] = true;
        for(int i=1;i<=sum/2;i++) mat[0][i] = false;
        
        for(int i= 1;i<=n;i++){
            for(int j= 1;j<=sum/2;j++){
                if(arr[i-1] <= j){
                    mat[i][j] = mat[i-1][j] || mat[i-1][j - arr[i-1]];            
                }
                else
                    mat[i][j] = mat[i-1][j];
            }
        }
        if(mat[n][sum/2]) return 1;
        return 0;
    }
}
