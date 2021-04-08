package dynamicProgramming;

import java.util.Arrays;

/*
 * Given a value N, find the number of ways to make change for N cents, 
 * if we have infinite supply of each of coins = { S1, S2, .. , SM } valued coins. 
 * 
 * https://practice.geeksforgeeks.org/problems/coin-change2448/1#
 */

public class CoinChange {
	
	// Recursive Approach - O(2^n) TLE
    public long solveRecur(int coins[], int m, int n) 
    { 
        return solveRecurUtil(coins,m,n);
    } 
    public long solveRecurUtil(int coins[],int m,int n){
        if(n == 0) return 1;
        if(n < 0) return 0;
        if(n >= 1 && m <= 0) return 0;
        
        return solveRecurUtil(coins,m-1,n)+solveRecurUtil(coins,m,n-coins[m-1]);
    }
    
    // Memoization - O(2^n) + O(n*m)
    public long solveMem(int S[], int m, int n) 
    { 
        long mat[][] = new long[n+1][m+1];
        for(int i=0;i<=n;i++) Arrays.fill(mat[i],-1);
        
        return solveMemUtil(S,m,n,mat);
    } 
    public long solveMemUtil(int coins[],int m,int n,long[][] mat){
        if(n == 0) return 1;
        if(n < 0) return 0;
        if(n >= 1 && m <= 0) return 0;
        if(mat[n][m] != -1) return mat[n][m];
        
        return mat[n][m] = solveMemUtil(coins,m-1,n,mat)+
        		solveMemUtil(coins,m,n-coins[m-1],mat);
    } 
    
    // DP - O(m*n)
    public long solveDP(int S[], int m, int n) 
    { 
        long mat[][] = new long[m+1][n+1];
        //initialization
        for(int i=0;i<=m;i++) mat[i][0] = 1;
        for(int i=1;i<=n;i++) mat[0][i] = 0;
        
        return solveDPUtil(S,m,n,mat);
    } 
    public long solveDPUtil(int coins[],int m,int n,long[][] mat){
        
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(coins[i-1] <= j){
                    mat[i][j] = mat[i][j-coins[i-1]] + mat[i-1][j];
                }else mat[i][j] = mat[i-1][j];
            }
        }
        return mat[m][n];
    }
}
