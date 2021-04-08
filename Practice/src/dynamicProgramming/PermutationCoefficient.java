package dynamicProgramming;
/*
 * Given n,r calculate P(n,r)
 */
public class PermutationCoefficient {
	// Easy approach; O(n)
    int solve(int n, int r)
    {
        if(r > n) return 0;
        int fn = 1;
        int fr = 1;
        
        for(int i=2;i<=n;i++) {
        	fn *= i;
        	if(i == n-r) fr = fn;  
        }
        return fn/fr;
    }
    // Recursive - O(2^n) TLE
    int solveRecur(int n, int r)
    {
        if(r > n) return 0;
        if(r == 0) return 1;
        return solveRecur(n-1,r-1) + r*solveRecur(n-1,r);
    }
    // DP - O(n*r)
    int solveDP(int n, int r)
    {
        if(r > n) return 0;
        int[][] mat = new int[n+2][r+2];
        
        for(int i=0;i<=n;i++){
            for(int j=0;j<=Math.min(i, r);j++){
                if(j == 0) mat[i][j] = 1;
                else mat[i][j] = ((mat[i-1][j-1]*j) + mat[i-1][j]);
                mat[i][j+1] = 0;
            }
        }
        return mat[n][r];
    }
}
