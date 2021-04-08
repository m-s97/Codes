package dynamicProgramming;
/*
 * https://practice.geeksforgeeks.org/problems/friends-pairing-problem5425/1
 * 
 * Given N friends, each one can remain single or can be paired up with some other friend. 
 * Each friend can be paired only once. 
 * Find out the total number of ways in which friends can remain single or can be paired up.
 */
public class FriendsPairingProblem {
	// Recursive - TLE
    public long countFriendsPairingsRecur(int n) 
    { 
       return solveRecur(n);
    }
    long solveRecur(int n){
        if(n <= 2) return n; 
        
        long a = (solveRecur(n-1))%1000000007;
        long b = ((n-1)*solveRecur(n-2))%1000000007;
        return (a+b)%1000000007;
    }
    // DP - O(N)
    public long countFriendsPairings(int n) 
    { 
        long mat[] = new long[n + 1];    
        return solveDPUtil(n,mat);
    }
    long solveDPUtil(int n,long[] mat){
        for(int i = 0; i <= n; i++) {
            if(i <= 2) mat[i] = i%1000000007;
            else mat[i] = (mat[i - 1] + (i - 1) * mat[i - 2])%1000000007;
        }
        return mat[n];
    }
}
