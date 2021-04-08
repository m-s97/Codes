package dynamicProgramming.matrixChainMultiplication;
/*
 * Given a sequence of matrices, find the most 
 * efficient way to multiply these matrices together. 
 * 
 * https://www.geeksforgeeks.org/matrix-chain-multiplication-dp-8/
 */
public class MatrixChainMultiplication {
	// Recursive approach - O(2^N)
	int solveRecur(int[] ar) {
		return solveRecurUtil(ar,1,ar.length-1);
	}
	int solveRecurUtil(int[] ar,int i,int j) {
		if(i >= j) return 0;
		int min = Integer.MAX_VALUE;
		
		for(int k=i;k<j;k++) {
			int ans = solveRecurUtil(ar,i,k)+solveRecurUtil(ar,k+1,j)+
					ar[i-1]*ar[k]*ar[j];
			if(min > ans) min = ans;
		}
		return min;
	}
	// Memoization - O()??
	int solveMem(int[] ar) {
		int[][] mat = new int[1001][1001];
		return solveMemUtil(ar,1,ar.length-1,mat);
	}
	int solveMemUtil(int[] ar,int i,int j,int[][] mat) {
		if(i >= j) return 0;
	    if (mat[i][j] != -1) 
	    {
	      return mat[i][j];
	    }
	    mat[i][j] = Integer.MAX_VALUE;
		
		for(int k=i;k<j;k++) {
			mat[i][j] = Math.min(mat[i][j], solveMemUtil(ar,i,k,mat)+
					solveMemUtil(ar,k+1,j,mat)+ ar[i-1]*ar[k]*ar[j]);
		}
		return mat[i][j];
	}
}
