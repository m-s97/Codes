package dynamicProgramming.knapSack;

import java.util.Arrays;

/*
 * You are given weights and values of N items, 
 * put these items in a knapsack of capacity W to get the maximum total value in the knapsack.
 * find out the maximum profit.
 *  
 *  https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1
 */
public class KnapsackProblem01 {
	
	// Recursive Approach - O(2^n) TLE
    int solveRecur(int W, int wt[], int val[], int n) 
    { 
         return solveRecurUtil(W,wt,val,n); 
    } 
    int solveRecurUtil (int W, int wt[], int val[], int n) {
        if(W == 0 || n == 0) return 0;
        
        if(wt[n-1] <= W) 
            return Math.max(solveRecurUtil(W,wt,val,n-1),
                        val[n-1]+solveRecurUtil(W - wt[n-1],wt,val,n-1));
        else
            return solveRecurUtil(W,wt,val,n-1);
    }
    
    // Memoization - O(2^n) + O(n*m)
    int solveMem(int W, int wt[], int val[], int n) 
    { 
         int mat[][] = new int[n+1][W+1];
         for(int i=0;i<=n;i++) Arrays.fill(mat[i],-1);
         return solveMemUtil(W,wt,val,n,mat); 
    } 
    int solveMemUtil (int W, int wt[], int val[], int n,int mat[][]) {
        if(W == 0 || n == 0) return 0;
        if(mat[n][W] != -1) return mat[n][W];
        if(wt[n-1] <= W){
        	// Checking if sub-cases already calculated or not
            if(mat[n-1][W] != -1 && mat[n-1][W - wt[n-1]] != -1)
                return mat[n][W] = Math.max(mat[n-1][W],
                                    val[n-1]+mat[n-1][W - wt[n-1]]);
            else if(mat[n-1][W] != -1)
                return mat[n][W] = Math.max(mat[n-1][W],
                        val[n-1]+solveMemUtil(W - wt[n-1],wt,val,n-1,mat));
            else if(mat[n-1][W - wt[n-1]] != -1)
                return mat[n][W] = Math.max(solveMemUtil(W,wt,val,n-1,mat),
                        val[n-1]+mat[n-1][W - wt[n-1]]);
            return mat[n][W] = Math.max(solveMemUtil(W,wt,val,n-1,mat),
                        val[n-1]+solveMemUtil(W - wt[n-1],wt,val,n-1,mat));            
        }
        else
            return mat[n][W] = solveMemUtil(W,wt,val,n-1,mat);
    }
    
    // DP - O(m*n)
    int solveDP(int W, int wt[], int val[], int n) 
    { 
         int mat[][] = new int[n+1][W+1];

        return solveDPUtil(W,wt,val,n,mat); 
    } 
    int solveDPUtil (int W, int wt[], int val[], int n,int mat[][]) {

        for(int i= 1;i<=n;i++){
            for(int j= 1;j<=W;j++){
                if(wt[i-1] <= j){
                    mat[i][j] = Math.max(mat[i-1][j],
                                            val[i-1]+mat[i-1][j - wt[i-1]]);            
                }
                else
                    mat[i][j] = mat[i-1][j];
            }
        }
        return mat[n][W];
    }
}
