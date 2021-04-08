package dynamicProgramming;

/*
 * Given two integers n and r, find nCr. 
 * 
 * https://practice.geeksforgeeks.org/problems/ncr1019/1
 * https://www.geeksforgeeks.org/binomial-coefficient-dp-9/
 */
public class BinomialCoefficient {
	
	// Easy approach; product will overflow for Greater numbers
    int solve(int n, int r)
    {
        if(r > n) return 0;
        
        return fact(n)/(fact(r)*fact(n-r));
    }
    int fact(int i){
        if(i == 0 || i == 1) return 1;
        else return i*fact(i-1);
    }
    // Recursive - O(2^n) TLE
    int solveRecur(int n, int r)
    {
        if(r > n) return 0;
        if(r == 0 || r == n) return 1;
        return solveRecur(n-1,r-1) + solveRecur(n-1,r);
    }
    // DP - O(n*r)
    int solveDP(int n, int r)
    {
        if(r > n) return 0;
        int[][] mat = new int[n+1][r+1];
        
        for(int i=0;i<=n;i++){
            for(int j=0;j<=Math.min(i, r);j++){
                if(j == i || j == 0) mat[i][j] = 1;
                else mat[i][j] = (mat[i-1][j-1] + mat[i-1][j])%1000000007;
            }
        }
        return mat[n][r]%1000000007;
    }
}
