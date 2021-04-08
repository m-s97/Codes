package dynamicProgramming.matrixChainMultiplication;

import java.util.Arrays;

/*
 * leetcode - 1039
 * https://leetcode.com/problems/minimum-score-triangulation-of-polygon/
 */
public class MinScoreTriangulation {
	//Using Memoization
    public int minScoreTriangulation(int[] nums) {
        int size = nums.length;
         int mat[][] = new int[size+1][size+1];
         for(int i = 0; i < size+1; ++i) {
             Arrays.fill(mat[i], Integer.MAX_VALUE);
         }        
         return solveMem(nums,1,size-1,mat);
     }
     public int solveMem(int[] n,int i,int j,int mat[][]){
         if(j <= i) return 0;
         if(mat[i][j] != Integer.MAX_VALUE) return mat[i][j];
         
         for(int k=i;k<j;k++){
             int p1 = (mat[i][k] != Integer.MAX_VALUE)?mat[i][k] :solveMem(n,i,k,mat);
             int p2 = (mat[k+1][j] != Integer.MAX_VALUE)?mat[k+1][j] :solveMem(n,k+1,j,mat);
             mat[i][j] = Math.min(p1 +p2+(n[i-1] * n[k] * n[j]),mat[i][j]);
         }
         return mat[i][j];
     }
 }
