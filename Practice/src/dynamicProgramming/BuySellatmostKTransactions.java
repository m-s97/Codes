package dynamicProgramming;
/*
 * In the stock market, a person buys a stock and sells it on some future date. 
 * Given the stock prices of N days in an array A[ ] and a positive integer K,
 * find out the maximum profit a person can make in at-most K transactions.
 *  
 * https://practice.geeksforgeeks.org/problems/maximum-profit4657/1
 * leetcode - 188
 */
public class BuySellatmostKTransactions {
	// DP - O(k*n^2)
    static int maxProfit(int k, int n, int A[]) {
        int dp[][] = new int[k+1][n+1];
        
        for(int i=1;i<=k;i++){
            for(int j=1;j<=n;j++){
                int p1 = dp[i][j-1]; // not making any transaction
                int p2 = Integer.MIN_VALUE;
                for(int m=0;m<j;m++){ // selecting a buying day
                    p2 = Math.max(A[j-1]-A[m]+dp[i-1][m],p2); // Making a transation
                }
                dp[i][j] = Math.max(p1,p2);
            }
        }
        return dp[k][n];
    }
    // DP - O(k*n)
    static int maxProfitDP(int k, int n, int A[]) {
        int dp[][] = new int[k+1][n+1];
        
        for(int i=1;i<=k;i++){
            int prevDif = Integer.MIN_VALUE;
            for(int j=1;j<=n;j++){
                int p1 = dp[i][j-1];
                prevDif = Math.max(-A[j-1]+dp[i-1][j-1],prevDif);
                int p2 = prevDif + A[j-1];
                dp[i][j] = Math.max(p1,p2);
            }
        }
        return dp[k][n];
    }
}
