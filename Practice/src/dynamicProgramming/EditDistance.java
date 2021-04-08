package dynamicProgramming;

import java.util.Arrays;

/*
 * Given two strings s and t. Find the minimum number of operations that need 
 * to be performed on str1 to convert it to str2. The possible operations are:
 * Insert
 * Remove
 * Replace
 * 
 * https://practice.geeksforgeeks.org/problems/edit-distance3702/1
 */
public class EditDistance {
	// Recursive Approach - O(2^n) TLE
    public int editDistanceRecur(String s, String t) {
        // Code here
        return editDistRecurUtil(s,t,s.length(),t.length());
    }
    int editDistRecurUtil(String s,String t,int i,int j){
        if(i == 0) return j;
        if(j == 0) return i;
        if(s.charAt(i-1) == t.charAt(j-1)) return editDistRecurUtil(s,t,i-1,j-1);
        
        else {
            return 1+Math.min(editDistRecurUtil(s,t,i-1,j-1),
            Math.min(editDistRecurUtil(s,t,i,j-1),editDistRecurUtil(s,t,i-1,j)));
        }
    }
    // Memoization
    public int editDistanceMem(String s, String t) {
        // Code here
        int[][] mat = new int[s.length()+1][t.length()+1];
        for(int i=0;i<=s.length();i++) Arrays.fill(mat[i],-1);
        return editDistMemUtil(s,t,s.length(),t.length(),mat);
    }
    int editDistMemUtil(String s,String t,int i,int j,int[][] mat){
        if(i == 0) return j;
        if(j == 0) return i;
        if(mat[i][j] != -1) return mat[i][j];
        if(s.charAt(i-1) == t.charAt(j-1)) 
            return mat[i][j] = editDistMemUtil(s,t,i-1,j-1,mat);
        else {
            return mat[i][j] = 1+Math.min(editDistMemUtil(s,t,i-1,j-1,mat),
            Math.min(editDistMemUtil(s,t,i,j-1,mat),editDistMemUtil(s,t,i-1,j,mat)));
        }
    }
    // DP - O(n*m)
    public int editDistanceDP(String s, String t) {
        // Code here
        int[][] mat = new int[s.length()+1][t.length()+1];
        for(int i=0;i<=s.length();i++) mat[i][0] = i;
        for(int i=0;i<=t.length();i++) mat[0][i] = i;
        return editDistDPUtil(s,t,s.length(),t.length(),mat);
    }
    int editDistDPUtil(String s,String t,int n,int m,int[][] mat){
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1) == t.charAt(j-1)) mat[i][j] = mat[i-1][j-1];
                else{
                    mat[i][j] = 1+Math.min(mat[i-1][j-1],Math.min(mat[i][j-1],
                    mat[i-1][j]));
                }
            }
        }
        return mat[n][m];
    }
}
