package dynamicProgramming.matrixChainMultiplication;

import java.util.Arrays;
/*
 * leetcode - 312
 * https://leetcode.com/problems/burst-balloons/
 */
public class BurstBalloons {
	// Recursive approach - TLE O(2^n)
    public int maxCoins(int[] nums) {
        int size = nums.length;
        int[] n = new int[size+2];
        n[0] = 1;
        for(int i=0;i<size;i++){
            n[i+1] = nums[i];
        }
        n[size+1] = 1;
        return solveRecur(n,1,size+1);
    }
    public int solveRecur(int[] n,int i,int j){
        if(j <= i) return 0;
        int max = Integer.MIN_VALUE;
        
        for(int k=i;k<j;k++){
            int sum = solveRecur(n,i,k)+solveRecur(n,k+1,j)+(n[i-1] * n[k] * n[j]);
            if(max < sum) max = sum;
        }
        return max;
    }
    // Memoization
    public int solveMem(int[] nums) {
        int size = nums.length;
        int[] n = new int[size+2];
        n[0] = 1;
        for(int i=0;i<size;i++){
            n[i+1] = nums[i];
        }
        n[size+1] = 1;
        int mat[][] = new int[size+2][size+2];
        for(int i = 0; i < size+2; ++i) {
            Arrays.fill(mat[i], Integer.MIN_VALUE);
        }        
        return solveMem(n,1,size+1,mat);
    }
    public int solveMem(int[] n,int i,int j,int mat[][]){
        if(j <= i) return 0;
        if(mat[i][j] != Integer.MIN_VALUE) return mat[i][j];
        
        for(int k=i;k<j;k++){
            int p1 = (mat[i][k] != Integer.MIN_VALUE)?mat[i][k] :solveMem(n,i,k,mat);
            int p2 = (mat[k+1][j] != Integer.MIN_VALUE)?mat[k+1][j] :solveMem(n,k+1,j,mat);
            mat[i][j] = Math.max(p1 +p2+(n[i-1] * n[k] * n[j]),mat[i][j]);
        }
        return mat[i][j];
    }
}
